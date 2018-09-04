package com.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dao.SellerDao;
import com.dto.Comment;
import com.entity.Commodity;
import com.entity.Seller;
import com.mongodb.WriteResult;

/**
 * @author liangjiahong
 * @date 2018年8月31日 下午9:41:26
 * @describe 商家接口实现类
 */
@Repository
public class SellerDaoImpl extends BaseDaoImpl<Seller> implements SellerDao {
	
	@Override
	public void updateComment(String commodityId,String commentId,Comment comment) {
		Criteria criteria = Criteria.where("commoditys._id").is(commodityId).and("commoditys.comments.content").is(commentId);
		Query query = new Query(criteria);
		Update update = new Update();
		update.set("commoditys.comments.$[].answer", comment.getAnswer());
		update.set("commoditys.comments.$[].answerTime", comment.getAnswerTime());
		this.getMongoTemplate().upsert(query, update, Seller.class);
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
}
