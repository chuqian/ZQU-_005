package com.dao.impl;

import static org.hamcrest.CoreMatchers.is;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.types.Code;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.dao.CommodityDao;
import com.dto.Commodity;
import com.entity.AllCommodity;
import com.entity.Seller;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;

/**
 * @author chenchuqian
 * @date 2018年8月29日 下午3:45:10
 * @describe 商品接口实现类
 */
@Repository
public class CommodityDaoImpl extends BaseDaoImpl<AllCommodity> implements CommodityDao {

	@Override
	public List<AllCommodity> findByCondition(AllCommodity commodity) {
		Pattern pattern = Pattern.compile("^.*" + commodity.getCommodityName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		return this.getMongoTemplate().find(new Query(criteria), AllCommodity.class);
	}

	@Override
	public List<AllCommodity> findByCondition(AllCommodity commodity, int skip, int limit) {
		Pattern pattern = Pattern.compile("^.*" + commodity.getCommodityName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		Query query = new Query(criteria).skip(skip).limit(limit);
		return this.getMongoTemplate().find(query, AllCommodity.class);
	}

	@Override
	public long rowsCount(AllCommodity commodity) {
		Pattern pattern = Pattern.compile("^.*" + commodity.getCommodityName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = Criteria.where("name").regex(pattern);
		return this.getMongoTemplate().count(new Query(criteria), Commodity.class);
	}

	@Override
	public boolean commodityUpload(Commodity commodity, AllCommodity allCommodity) {
		Query query = new Query(Criteria.where("_id").is(allCommodity.getSellerId()));
		Update update = new Update().push("commoditys", commodity);
		// 把商品添加到卖家
		this.getMongoTemplate().findAndModify(query, update, Seller.class);
		// 把商品添加到平台商品中
		this.getMongoTemplate().save(allCommodity);
		return true;
	}

	@Override
	public boolean commodityDelete(String sellerId, String commodityId) {
		try {
			System.out.println(sellerId + " " + commodityId);
			Query query = Query.query(Criteria.where("_id").is(sellerId).and("commoditys._id").is(commodityId));
			Update update = new Update();
			update.unset("commoditys.$");
			this.getMongoTemplate().updateFirst(query, update, Seller.class);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean allCommodityDelete(String commodityId) {
		try {
			Query query = Query.query(Criteria.where("_id").is(commodityId));
			this.getMongoTemplate().remove(query, AllCommodity.class);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Commodity> findSellerCommodity(String sellerId, int skip, int size) {
		Query query = new Query(Criteria.where("_id").is(sellerId));
		query.fields().slice("commoditys", skip, size);
		return this.getMongoTemplate().findOne(query, Seller.class, "seller").getCommoditys();
	}

	@Override
	public Commodity findSellerCommodityOne(String sellerId, String commodityId) {
		Query query = new Query(Criteria.where("_id").is(sellerId).and("commoditys._id").is(commodityId));
		query.fields().include("commoditys");
		return this.getMongoTemplate().findOne(query, Seller.class, "seller").getCommoditys().get(0);
	}

	@Override
	public int commodityCount(String sellerId) {
		DBObject size = new BasicDBObject("$size", "$commoditys");
		DBObject count = new BasicDBObject("count", size);
		count.put("_id", 0);
		DBObject project = new BasicDBObject("$project", count);
		System.out.println(project.toString());
		// 筛选条件
		DBObject id = new BasicDBObject("_id", new ObjectId(sellerId));
		DBObject match = new BasicDBObject("$match", id);

		AggregationOutput out = this.getMongoTemplate().getCollection("seller").aggregate(match, project);
		int total = 0;
		for (Iterator<DBObject> iterator = out.results().iterator(); iterator.hasNext();) {
			DBObject dbObject = iterator.next();
			total = Integer.valueOf(dbObject.get("count").toString());
		}
		return total;
	}

	@Override
	public List<Commodity> commodityCondition(String sellerId, String name, Double down, Double up, Integer isShelf,
			Integer skip, Integer limit) {
		List<DBObject> dbObjects = toDBDbObjects(sellerId, name, down, up, isShelf);
		// 分页
		BasicDBObject $skip = new BasicDBObject("$skip", skip);
		BasicDBObject $limit = new BasicDBObject("$limit", limit);
		dbObjects.add($skip);
		dbObjects.add($limit);
		List<Commodity> commodities = new ArrayList<Commodity>();
		@SuppressWarnings("deprecation")
		AggregationOutput out = this.getMongoTemplate().getCollection("seller").aggregate(dbObjects);
		for (@SuppressWarnings("deprecation")
		Iterator<DBObject> iterator = out.results().iterator(); iterator.hasNext();) {
			DBObject dbObject = iterator.next();
			// 将Json字符串转换成Commodity对象
			Commodity obj = JSONObject.parseObject(dbObject.get("commoditys").toString(), Commodity.class);
			commodities.add(obj);
		}
		return commodities;
	}

	@Override
	public int commodityConditionCount(String sellerId, String name, Double down, Double up, Integer isShelf) {
		List<DBObject> dbObjects = toDBDbObjects(sellerId, name, down, up, isShelf);
		DBObject $count = new BasicDBObject("$count", "count");
		dbObjects.add($count);
		AggregationOutput out = this.getMongoTemplate().getCollection("seller").aggregate(dbObjects);
		int total = 0;
		for (@SuppressWarnings("deprecation")
		Iterator<DBObject> iterator = out.results().iterator(); iterator.hasNext();) {
			DBObject dbObject = iterator.next();
			total = Integer.valueOf(dbObject.get("count").toString());
		}
		return total;
	}

	private List<DBObject> toDBDbObjects(String sellerId, String name, Double down, Double up, Integer isShelf) {
		List<DBObject> dbObjects = new ArrayList<DBObject>();
		// 将数组类型字段拆分成多条
		DBObject unwind = new BasicDBObject("$unwind", "$commoditys");
		dbObjects.add(unwind);
		// 查找条件
		DBObject conditions = new BasicDBObject("_id", new ObjectId(sellerId));
		if (name != null && !name.equals("")) {
			DBObject blur = new BasicDBObject("$regex", name);
			blur.put("$options", "i");
			conditions.put("commoditys.name", blur);
		}
		if (down != null || up != null) {
			DBObject price = new BasicDBObject();
			if (down != null)
				price.put("$gte", down);
			if (up != null)
				price.put("$lte", up);
			if (down != null && up != null)
				conditions.put("commoditys.price", price);
		}
		if (isShelf != null) {
			conditions.put("commoditys.isShelf", isShelf);
		}
		DBObject match = new BasicDBObject("$match", conditions);
		dbObjects.add(match);
		// 选择要显示的字段
		DBObject select = new BasicDBObject("_id", 0);
		select.put("commoditys", 1);
		DBObject project = new BasicDBObject("$project", select);
		dbObjects.add(project);
		return dbObjects;
	}

}
