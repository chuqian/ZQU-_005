
package com.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.dao.CustomerDao;
import com.dto.GetAddress;
import com.entity.Collect;
import com.entity.CommentMsg;
import com.entity.Customer;
import com.entity.CustomerOrder;
import com.entity.ShopCart;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *@author : 李国鹏
 *@datetime : Sep 7, 2018 2:47:18 PM
 *@descriptioin :  买家 Dao 接口实现类
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
	
	private final String EMAIL = "email";
	
	@Override
	public Customer findByEmail(String email) {
		return getMongoTemplate().findOne(new Query(Criteria.where(EMAIL).is(email)), Customer.class);
	}
		
	@Override
	public Customer findByNickName(String nickName) {
		return getMongoTemplate().findOne(new Query(Criteria.where("nickName").is(nickName)), Customer.class);
	}

	@Override
	public void updateCustomer(String userName, String nickNmae, String customerId) {
		Update update = new Update();
		update.set("nickname", nickNmae);
		update.set("username", userName);
		getMongoTemplate().findAndModify(new Query(Criteria.where("id").is(customerId)), update, Customer.class);	
	}

	@Override
	public void alterEmail(String email, String customerId) {
		Update update = new Update();
		update.set("email", email);
		getMongoTemplate().findAndModify(new Query(Criteria.where("id").is(customerId)), update, Customer.class);
	}

	@Override
	public void alterPhone(String phone, String customerId) {
		Update update = new Update();
		update.set("phone", phone);
		getMongoTemplate().findAndModify(new Query(Criteria.where("id").is(customerId)), update, Customer.class);
	}

	@Override
	public void updateCart(int count, double amount, String commodityId, String customerId) {
		Update update = new Update();
		update.set("count", count);
		update.set("amount", amount);
		getMongoTemplate().findAndModify(new Query(Criteria.where("commodityId").is(commodityId).and("customerId").is(customerId)), update, ShopCart.class);
	}
	
	@Override
	public ShopCart isExistCart(String customerId, String commodityId) {
		return getMongoTemplate().findOne(new Query(Criteria.where("customerId").is(customerId).and("commodityId").is(commodityId)), ShopCart.class);
	}

	@Override
	public void insertCart(ShopCart cart) {
		getMongoTemplate().save(cart);
	}
	
	@Override
	public List<ShopCart> findAllCart(String customerId, String lastId, int recordCount, int findType) {
		return getMongoTemplate().find(getQuery(customerId,"", "",lastId, recordCount, findType), ShopCart.class);
	}

	@Override
	public List<ShopCart> findCartByFuzzy(String customerId, String value, String lastId, int recordCount, int findType) {
		Query query = new Query();
		Pattern pattern = Pattern.compile("^.*" + value + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("commodityId").regex(pattern).gt(lastId), Criteria.where("name").regex(pattern));
		criteria.andOperator(Criteria.where("customerId").is(customerId));
		query.addCriteria(criteria);
		query.limit(recordCount);
		query.with(new Sort(Direction.ASC, "commodityId"));
		return getMongoTemplate().find(query, ShopCart.class);
	}

	@Override
	public void deleteCart(String customerId, String commodityId) {
		getMongoTemplate().remove(new Query(Criteria.where("customerId").is(customerId).and("commodityId").is(commodityId)), ShopCart.class);
	}

	@Override
	public void insertOrder(CustomerOrder order) {
		getMongoTemplate().save(order);
	}
	
	@Override
	public CustomerOrder findOneOrder(String orderId) {
		return getMongoTemplate().findOne(new Query(Criteria.where("orderId").is(orderId)), CustomerOrder.class);
	}

	@Override
	public List<CustomerOrder> findAllOrder(String customerId, String idFiled, String lastId, String sortFiled, int recordCount, int findType) {
		Criteria criteria = new Criteria("orderState");
		criteria.is(1);	//状态为 0 的订单表示已经被买家删除，不再显示
		Query query = getQuery(customerId, idFiled, lastId, sortFiled, recordCount, findType);
		query.addCriteria(criteria);
		return getMongoTemplate().find(query, CustomerOrder.class);
	}

	@Override
	public List<CustomerOrder> findOrderByFuzzy(String customerId, String value, String lastId, int recordCount, int findType) {
		List<CustomerOrder> list = null;
		Query query = new Query();
		Pattern pattern = Pattern.compile("^.*" + value + ".*$", Pattern.CASE_INSENSITIVE);	//忽略大小写
		Criteria criteria = new Criteria("");
		criteria.orOperator(Criteria.where("orderId").regex(pattern).gt(lastId), Criteria.where("commodityMsgs.commodityName").regex(pattern), Criteria.where("commodityMsgs.commodityId").regex(pattern));
		criteria.andOperator(Criteria.where("customerId").is(customerId));
		query.addCriteria(criteria);
		query.limit(10);
		query.with(new Sort(Direction.ASC, "orderId"));
		list = getMongoTemplate().find(query, CustomerOrder.class);
		
		return list;
	}

	@Override
	public void deleteOrder(String orderId) {
		Update update = new Update();
		update.set("orderState", 0);
		getMongoTemplate().findAndModify(new Query(Criteria.where("orderId").is(orderId)), update, CustomerOrder.class);
	}

	@Override
	public void updateOrder(Date dealTime, String orderId) {
		Update update = new Update();
		update.set("afterSale.$.dealtime", dealTime);
		update.set("afterSale.$.returnState", 1);
		getMongoTemplate().findAndModify(new Query(Criteria.where("orderId").is(orderId)), update, CustomerOrder.class);
	}
	
	@Override
	public List<Customer> getAddresses(String customerId) {
		return getMongoTemplate().find(new Query(Criteria.where("customerId").is(customerId)), Customer.class);
	}

	@Override
	public void insertAddress(GetAddress address, String customerId) {
		Update update = new Update();
		update.addToSet("address", address);	//一样的地址信息不插入
		getMongoTemplate().upsert(new Query(Criteria.where("id").is(customerId)), update, Customer.class);
	}

	@Override
	public void deleteAddress(String addressId, String customerId) {
		String target = "{'$pull' : {'address' : {'addressId' : '" + addressId + "'}}}";	//根据地址 id 删除相应的地址
		Update update = new BasicUpdate(target);
		getMongoTemplate().upsert(new Query(Criteria.where("id").is(customerId)), update, Customer.class);
	}

	@Override
	public void updateAddress(GetAddress address, String customerId) {
		Update update = new Update();
		update.set("address.$", address);	//进行原子性更新
		getMongoTemplate().findAndModify(new Query(Criteria.where("id").is(customerId).and("address.addressId").is(address.getAddressId())), update, Customer.class);
	}

	@Override
	public void insertCollection(Collect collection) {
		getMongoTemplate().save(collection);
	}

	@Override
	public void deleteCollection(String customerId, String commodityId) {
		getMongoTemplate().remove(new Query(Criteria.where("customerId").is(customerId).and("commodityId").is(commodityId)), Collect.class);
	}

	@Override
	public Collect isExistCollection(String customerId, String commodityId) {
		return getMongoTemplate().findOne(new Query(Criteria.where("customerId").is(customerId).and("commodityId").is(commodityId)), Collect.class);
	}

	@Override
	public List<Collect> findCollection(String customerId, String lastId, int recordCount, int findType) {
		return getMongoTemplate().find(getQuery(customerId, lastId,"","" ,recordCount, findType), Collect.class);
	}

	@Override
	public List<CustomerOrder> getAfterSale(String customerId, String pageId, int recordCount, int findType) {
		DBObject queryObject = new BasicDBObject();
		queryObject.put("customerId", customerId);  
		DBObject fielsObject = new BasicDBObject();
		fielsObject.put("afterSale", true);	//只需返回售后服务信息
		Query query = new BasicQuery(queryObject, fielsObject);
		query.limit(recordCount);
		query.with(new Sort(Direction.ASC, "customerId"));
		return getMongoTemplate().find(query, CustomerOrder.class);	
	}

	@Override
	public void insertCommentMsg(CommentMsg commentMsg) {
		getMongoTemplate().save(commentMsg);
	}

	@Override
	public void deleteCommentMsg(String orderId) {
		getMongoTemplate().remove(new Query(Criteria.where("orderId").is(orderId)), CommentMsg.class);
	}

	@Override
	public List<CommentMsg> findCommentMsg(String customerId, String filed, String lastId, int recordCount, int findType) {
		return getMongoTemplate().find(getQuery(customerId, "", "", lastId, recordCount, findType), CommentMsg.class);
	}
	
	private  Query getQuery(String id, String idFiled, String pageId, String sortFiled, int recordCount, int findType) {
		Query query = new Query();
		Criteria criteria = new Criteria(idFiled);
		criteria.is(id);
		Criteria criteria2 = new Criteria(sortFiled);
		
		if(findType == 1)
			criteria2.gt(pageId);
		else
			criteria2.lt(pageId);
		
		query.addCriteria(criteria);
		query.addCriteria(criteria2);
		query.with(new Sort(Direction.ASC, sortFiled));
		query.limit(recordCount);
		
		return query;
	}
}
