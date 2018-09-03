/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:58:25 PM
 *@descriptioin :  
 */
package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	@Override
	public User findUser(String id) {
		// TODO Auto-generated method stub
		return findById(id);
	}
	
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		save(user);
	}
}
