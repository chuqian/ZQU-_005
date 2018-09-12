
package com.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:50:44 PM
 *@descriptioin :  
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Resource(name = "userDaoImpl")
	private UserDao userDao; 
	
	@Override
	public void updateRole(String id, String role) {
		userDao.addRole(id, role);
	}

	@Override
	public void updatePassword(String id, String password) {
		userDao.updatePassword(id, password);
	}

	@Override
	public User findUser(String id) {
		return userDao.findById(id);
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

}
