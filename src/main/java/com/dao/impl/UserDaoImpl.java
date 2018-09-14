package com.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.dao.UserDao;
import com.entity.Customer;
import com.entity.Seller;
import com.entity.User;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:58:25 PM
 *@descriptioin :  
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	private static final String TARGET = "id";
	
	@Override
	public void addRole(String key, String value) {
		Update update = new Update().addToSet(key, value);
		this.getMongoTemplate().findAndModify(getQuery(key), update, User.class);
	}

	@Override
	public void updatePassword(String key, String value) {
		Update update = new Update().set(key, value);
		this.getMongoTemplate().updateFirst(getQuery(key), update, User.class);
	}

	@Override
	public User getUserFromSellerByName(String name) {
		User user = null;
		Seller seller = null;
		seller = this.getMongoTemplate().findOne(new Query(Criteria.where("name").is(name)), Seller.class);
		
		if(seller != null)
			user = this.findById(seller.getId());
		
		return user;
	}

	@Override
	public User getUserFromSellerByEmail(String email) {
		User user = null;
		Seller seller = null;
		seller = this.getMongoTemplate().findOne(new Query(Criteria.where("email").is(email)), Seller.class);
		
		if(seller != null)
			user = this.findById(seller.getId());
		
		return user;
	}

	@Override
	public User getUserFromSellerByPhone(String phone) {
		User user = null;
		Seller seller = null;
		seller = this.getMongoTemplate().findOne(new Query(Criteria.where("phone").is(phone)), Seller.class);
		
		if(seller != null)
			user = this.findById(seller.getId());
		
		return user;
	}

	@Override
	public User getUserFromCustomerByName(String name) {
		User user = null;
		Customer customer = null;
		customer = this.getMongoTemplate().findOne(new Query(Criteria.where("name").is(name)), Customer.class);
		
		if(customer != null)
			user = this.findById(customer.getId());
		
		return user;
	}

	@Override
	public User getUserFromCustomerByEmail(String email) {
		User user = null;
		Customer customer = null;
		customer = this.getMongoTemplate().findOne(new Query(Criteria.where("email").is(email)), Customer.class);
		
		if(customer != null)
			user = this.findById(customer.getId());
		
		return user;
	}

	@Override
	public User getUserFromCustomerByPhone(String phone) {
		User user = null;
		Customer customer = null;
		customer = this.getMongoTemplate().findOne(new Query(Criteria.where("phone").is(phone)), Customer.class);
		
		if(customer != null)
			user = this.findById(customer.getId());
		
		return user;
	}

	private static final Query getQuery(String value) {
		return new Query(Criteria.where(TARGET).is(value));
	}
	
}
