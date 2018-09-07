
package com.service.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.dao.BaseDao;
import com.entity.User;
import com.service.UserService;
/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:50:44 PM
 *@descriptioin :  
 */
@Service
public class UserServiceImpl implements UserService{
	private static final int NO_EXIST = 0;
	private static final int HAVE_SELLER_ROLE = 1;	//此账号拥有卖家角色
	private static final int HAVE_CUSTOMER_ROLE = 2;	//此账号拥有买家角色
	private static final int HAVE_TWO_ROLE = 3;	//此账号同时拥有卖、买家角色
	
	@Override
	public User findUser(BaseDao<User> uBaseDao, String id) {
		return uBaseDao.findById(id);
	}

	@Override
	public void saveUser(BaseDao<User> uBaseDao, User user) {
		uBaseDao.save(user);
	}

	@Override
	public void updateUser(BaseDao<User> uBaseDao, User user) {
		Query query = new Query(Criteria.where("role").is(user.getId()));
		Update update = new Update().addToSet("role", user.getRoles()[0]);
		uBaseDao.findAndModify(query, update, User.class);
	}

	@Override
	public int validateEmail(BaseDao<User> baseDao, String email) {
		User user = baseDao.findById(email);
		
		if(user == null)	//email 没有注册过
			return NO_EXIST;
		else if(user.getRoles().length == 2)
			return HAVE_TWO_ROLE;
		else if(user.getRoles()[0].equals("seller"))
			return HAVE_SELLER_ROLE;
		else 
			return HAVE_CUSTOMER_ROLE;		
	}
	
	@Override
	public boolean validateEmail(String role, int type) {
		if(type == NO_EXIST)
			return true;
		else if(type == HAVE_SELLER_ROLE && compareRole(role))
			return false;
		else if(type == HAVE_SELLER_ROLE && compareRole(role))
			return true;
		else if(type == HAVE_CUSTOMER_ROLE && compareRole(role))
			return true;
		else if(type == HAVE_CUSTOMER_ROLE && compareRole(role))
			return false;
		else
			return false;
	}
	
	public boolean compareRole(String role) {
		return "seller".equals(role);
	}
}
