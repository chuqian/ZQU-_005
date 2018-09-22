
package com.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.dao.CustomerDao;
import com.dto.GetAddress;
import com.entity.Customer;
import com.entity.CustomerOrder;
import com.entity.ShopCart;

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
	public void updateCart(int count, double amount, String commodityId) {
		Update update = new Update();
		update.set("count", count);
		update.set("amount", amount);
		getMongoTemplate().findAndModify(new Query(Criteria.where("commodityId").is(commodityId)), update, ShopCart.class);
	}
	
	@Override
	public ShopCart findShopCart(String customerId, String commodityId) {
		return getMongoTemplate().findOne(new Query(Criteria.where("customerId").is(customerId).and("commodityId").is(commodityId)), ShopCart.class);
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
		Update update = new Update();
		update.set("orderState", 0);
		getMongoTemplate().findAndModify(new Query(Criteria.where("orderId").is(orderId)), update, CustomerOrder.class);
	}

	@Override
	public List<Customer> getAddresses(String customerId) {
		return getMongoTemplate().find(new Query(Criteria.where("id").is(customerId)), Customer.class);
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
		update.set("address", address);
		getMongoTemplate().findAndModify(new Query(Criteria.where("id").is(customerId).and("address.addressId").is(address.getAddressId())), update, Customer.class);
	}
	
}
