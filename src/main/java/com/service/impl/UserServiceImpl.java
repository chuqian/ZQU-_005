/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:50:44 PM
 *@descriptioin :  
 */
package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource(name = "userDaoImpl")
	UserDao userDao;
	
	@Override
	public User findUser(String id) {
		// TODO Auto-generated method stub
		
		return userDao.findUser(id);
	}
	
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}
	
}
