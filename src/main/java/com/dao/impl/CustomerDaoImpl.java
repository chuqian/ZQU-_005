
package com.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.dao.CustomerDao;
import com.entity.Customer;
import com.entity.CustomerOrder;
import com.entity.ShopCart;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

/**
 *@author : 李国鹏
 *@datetime : Sep 7, 2018 2:47:18 PM
 *@descriptioin :  买家 Dao 接口实现类
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
	
	private static final String EMAIL = "email";
	@Override
	public Customer findByEmail(String email) {
		Query query = new Query(Criteria.where(EMAIL).is(email));
		
		return getMongoTemplate().findOne(query, Customer.class);
	}
	
	@Override
	public void updateCart(int count, double amount, String commodityId) {
		Query query = new Query(Criteria.where("commodityId").is(commodityId));
		Update update = new Update();
		update.set("count", count);
		update.set("amount", amount);
		getMongoTemplate().updateFirst(query, update, ShopCart.class);
	}
	
	@Override
	public ShopCart findShopCart(String customerId, String commodityId) {
		Query query = new Query(Criteria.where("customerId").is(customerId).and("commodityId").is(commodityId));
		
		return getMongoTemplate().findOne(query, ShopCart.class);
	}

	@Override
	public void insertCart(ShopCart cart) {
		getMongoTemplate().save(cart);
	}

	@Override
	public void insertOrder(CustomerOrder order) {
		getMongoTemplate().save(order);
	}
	
	@Override
	public List<CustomerOrder> findOrder(String value) {
		List<CustomerOrder> list = null;
		Query query = new Query();
		Pattern pattern = Pattern.compile("^.*" + value + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("orderId").regex(pattern), Criteria.where("commodityMsgs.commodityName").regex(pattern), Criteria.where("commodityMsgs.commodityId").regex(pattern));
		query.addCriteria(criteria);
		list = getMongoTemplate().find(query, CustomerOrder.class);
		
		return list;
	}

	@Override
	public void deleteOrder(String orderId) {
		
	}
	
	
}
