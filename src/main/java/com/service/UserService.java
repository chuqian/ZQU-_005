package com.service;

import org.springframework.stereotype.Service;
import com.dao.BaseDao;
import com.entity.User;
/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:49:19 PM
 *@descriptioin :  
 */
@Service
public interface UserService {
	boolean validateEmail(String role, int type);
	User findUser(BaseDao<User> uBaseDao, String id);
	void saveUser(BaseDao<User> uBaseDao, User user);
	void updateUser(BaseDao<User> uBaseDao, User user);
	int validateEmail(BaseDao<User> uBaseDao, String id);	
}
