package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dao.SellerDao;
import com.dto.Comment;
import com.dto.Commodity;
import com.dto.SellerOrder;
import com.entity.AllCommodity;
import com.entity.Seller;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

/**
 * @author liangjiahong
 * @date 2018年8月31日 下午9:41:26
 * @describe 商家接口实现类
 */
@Repository
public class SellerDaoImpl extends BaseDaoImpl<Seller> implements SellerDao {
	
	private final String EMAIL = "email";
	@Override
	public Seller findByEmail(String email) {
		Query query = new Query(Criteria.where(EMAIL).is(email));
		
		if(this.getMongoTemplate().find(query, Seller.class).size() != 0 )
			return this.getMongoTemplate().find(query, Seller.class).get(0);
		
		return null;
	}

	@Override
	public int updateCommentState(String commodityId, Comment comment) {
		Criteria criteria = Criteria.where("commoditys._id").is(commodityId);
		Query query = new Query(criteria);
		Seller seller = this.getMongoTemplate().findOne(query, Seller.class);
		Commodity commodity = new Commodity();
		List<Commodity> Cylists = seller.getCommoditys();
		int flag1 = -1, flag2 = -1;
		for (Commodity commodity2 : Cylists) {
			flag1++;
			if(commodityId.equals(commodity2.getId()))
			{
				commodity = commodity2;
				break;
			}
		}
		List<Comment> Ctlists = commodity.getComments();
		for (Comment comment3 : Ctlists) {
			flag2++;
			if(comment.getMember().equals(comment3.getMember()) && comment.getContentTime().equals(comment3.getContentTime())) {
				break;
			}
		}
		seller.getCommoditys().get(flag1).getComments().get(flag2).setState(comment.getState());
		this.getMongoTemplate().save(seller);
		return 1;
	}
	
	@Override
	public int updateCommentAnswer(String commodityId, Comment comment) {
		Criteria criteria = Criteria.where("commoditys._id").is(commodityId);
		Query query = new Query(criteria);
		Seller seller = this.getMongoTemplate().findOne(query, Seller.class);
		Commodity commodity = new Commodity();
		List<Commodity> Cylists = seller.getCommoditys();
		int flag1 = -1, flag2 = -1;
		for (Commodity commodity2 : Cylists) {
			flag1++;
			if(commodityId.equals(commodity2.getId()))
			{
				commodity = commodity2;
				break;
			}
		}
		List<Comment> Ctlists = commodity.getComments();
		for (Comment comment3 : Ctlists) {
			flag2++;
			if(comment.getMember().equals(comment3.getMember()) && comment.getContentTime().equals(comment3.getContentTime())) {
				break;
			}
		}
		seller.getCommoditys().get(flag1).getComments().get(flag2).setAnswer(comment.getAnswer());
		seller.getCommoditys().get(flag1).getComments().get(flag2).setAnswerTime(comment.getAnswerTime());
		this.getMongoTemplate().save(seller);
		return 1;
	}

	@Override
	public void insertComment(String commodityId,Comment comment) {
		Query query = Query.query(Criteria.where("commoditys.id").is(commodityId));
		Update update = new Update();
//		update.push("commoditys.$.comments", comment);
		update.addToSet("commoditys.$.comments", comment);//两种都是可以的
		this.getMongoTemplate().upsert(query, update, Seller.class);
	}
	
	@Override
	public void deleteSellerSecond(String commodityId,Commodity commodity) {
		Query query = Query.query(Criteria.where("commoditys.id").is(commodityId));
		Update update = new Update();
		update.pull("commoditys",commodity);
		this.getMongoTemplate().updateFirst(query, update, Seller.class);
	}
	
	@Override
	public void insertSellerSecond(String sellerId, Commodity commodity) {
		Query query = Query.query(Criteria.where("id").is(sellerId));
		Update update = new Update();
		update.push("commoditys", commodity);
//		update.addToSet("commoditys", commodity);//两种都是可以的
		this.getMongoTemplate().upsert(query, update, Seller.class);
	}
	
	@Override
	public void updateSellerFirst(String sellerId, String name, String store) {
		Criteria criteria = Criteria.where("id").is(sellerId);
		Query query = new Query(criteria);
		Update update = Update.update("name", name).set("store", store);
		this.getMongoTemplate().updateFirst(query, update, Seller.class);
	}

	@Override
	public WriteResult updateSellerSecond(String commodityId, String secondName, Double price) {
		Criteria criteria = Criteria.where("commoditys._id").is(commodityId);
		Query query = new Query(criteria);
		Update update = new Update();
		update.set("commoditys.$.name", secondName);
		update.set("commoditys.$.price", price);
		return this.getMongoTemplate().upsert(query, update, Seller.class);
	}

	@Override
	public List<Seller> findByCondition(Seller seller) {
		Pattern pattern = Pattern.compile("^.*" + seller.getName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		return this.getMongoTemplate().find(new Query(criteria), Seller.class);
	}

	@Override
	public List<Seller> findByCondition(Seller seller, int skip, int limit) {
		Pattern pattern = Pattern.compile("^.*" + seller.getName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		Query query = new Query(criteria).skip(skip).limit(limit);
		return this.getMongoTemplate().find(query, Seller.class);
	}

	@Override
	public long rowsCount(Seller seller) {
		Pattern pattern = Pattern.compile("^.*" + seller.getName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = Criteria.where("name").regex(pattern);
		return this.getMongoTemplate().count(new Query(criteria), Seller.class);

	}

	@Override
	public List<Seller> findFuzzy(String key, String value) {
		Query query = Query.query(Criteria.where(key).regex(value));
		return this.getMongoTemplate().find(query, Seller.class);
	}

	@Override
	public int update(String key1, String value1, String key2, Object value2, String key3, String value3) {
		// 更新条件不变，更新字段改成了一个我们集合中不存在的，用set方法如果更新的key不存在则创建一个新的key
		Query query = Query.query(Criteria.where(key1).is(value1));
		Update update = Update.update(key2, value3);// .set(key3, value3);
		this.getMongoTemplate().updateMulti(query, update, Seller.class);
		return 0;
	}

	
	
	@SuppressWarnings("serial")
	@Override
	public Seller getInfoById(String sellerId) {
		Map<String, Boolean> fieldMap = new HashMap<String, Boolean>(){{
			put("name", true);
			put("store", true);
			put("type", true);
			put("phone", true);
			put("identity", true);
			put("sex", true);
			put("info", true);
			put("email", true);
			put("contactAddress", true);
			put("storeImg", true);
		}};
		DBObject queryObject = new BasicDBObject("_id", sellerId);
		DBObject fieldsObject = new BasicDBObject(fieldMap);
		Query query = new BasicQuery(queryObject, fieldsObject);
		
		return this.getMongoTemplate().findOne(query, Seller.class);
	}
 	@Override
	public void storeCancel(String sellerId) {
		Query query = new Query(Criteria.where("_id").is(sellerId));
		Update update = new Update().unset("store").unset("type").unset("info")
				.unset("contactAddress").unset("storeImg").unset("commoditys");
		this.getMongoTemplate().updateFirst(query, update, Seller.class);
	}
 	@Override
	public List<Commodity> getCommodiyBySeller(String sellerId, long skip, long limit) {
		DBObject queryObject = new BasicDBObject("_id", sellerId);
		DBObject fieldObject = new BasicDBObject("commoditys", true);
		Query query = new BasicQuery(queryObject, fieldObject);
		//此种方法查询性能差，待改进
		List<Commodity> commodityList = this.getMongoTemplate().findOne(query, Seller.class).getCommoditys();
		//return commodityList.subList(fromIndex, toIndex);
		return null;
	}
 	@Override
	public void commodityToSeller(String sellerId, Commodity commodity) {
		//把商品添加至平台
		AllCommodity platformCommodity = new AllCommodity(sellerId, commodity);
		this.getMongoTemplate().insert(platformCommodity);
	
		//把商品添加至商家
		Query query = new Query(Criteria.where("_id").is(sellerId));
		commodity.setId(platformCommodity.getId());
		Update update = new Update().addToSet("commoditys", commodity);
		this.getMongoTemplate().updateFirst(query, update, Seller.class);
	}
 	@Override
	public List<SellerOrder> getOrdersBySeller(String sellerId, int orderState,	long skip, long limit) {
		
		/*此种方法查询性能太低
		DBObject queryObject = new BasicDBObject("_id", sellerId);
		DBObject fieldsObject = new BasicDBObject("sellerOrders", true);
		Query query = new BasicQuery(queryObject, fieldsObject);
		Seller seller = this.getMongoTemplate().findOne(query, Seller.class);
		return seller.getSellerOrders().subList(1, 10);*/
		
		//下面这种方法还没找到解决方案
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("_id").is(sellerId)),
				Aggregation.unwind("sellerOrders"),
				Aggregation.match(Criteria.where("sellerOrders.orderState").is(orderState)),
				Aggregation.skip(skip),	
				Aggregation.limit(limit));
		
		/*AggregationResults<Seller> aggRes = this.getMongoTemplate().
				aggregate(aggregation, "seller", Seller.class);*/      //这里会报错
		return null;
		/*return aggRes.getMappedResults();*/
	}
	
}
