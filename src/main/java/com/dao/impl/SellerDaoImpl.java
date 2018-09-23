package com.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

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
	public void InfoSave(Map<String, String> editInfo) {
		Set<String> keySet = editInfo.keySet();
		Iterator<String> it = keySet.iterator();
		Query query = null;
		Update update = new Update();
		
		while(it.hasNext()){
			String key = it.next();
			String value = editInfo.get(key);
			if(key == "id")
				query = Query.query(Criteria.where("_id").is(value));
			else
				update.set(key, value);
		}
		this.getMongoTemplate().updateFirst(query, update, Seller.class);
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
 		Query query = new Query(Criteria.where("_id").is(sellerId));
		query.fields().slice("commoditys", (int)skip, (int)limit);
		return this.getMongoTemplate().findOne(query, Seller.class, "seller").getCommoditys();
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
		/*Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.unwind("$sellerOrders"),
				Aggregation.match(Criteria.where("_id").is(sellerId).and("sellerOrders.orderState").is(orderState)),
				Aggregation.project("sellerOrders"),
				Aggregation.skip(skip),	
				Aggregation.limit(limit));
		
		AggregationResults<Object> aggRes = this.getMongoTemplate().
				aggregate(aggregation, "seller", Object.class);
		
		aggRes.getMappedResults();  //返回List<Object>，怎么转为List<SellerOrder>？ */
		
		Query query = new Query(Criteria.where("_id").is(sellerId).and("sellerOrders.orderState").is(orderState));
		query.fields().slice("sellerOrders", (int)skip, (int)limit);
		return this.getMongoTemplate().findOne(query, Seller.class, "seller").getSellerOrders();
	}

}
