package com.service;

import org.springframework.stereotype.Service;
import com.dao.BaseDao;
import com.entity.User;
/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:49:19 PM
 *@descriptioin :  
 */
public interface UserService {
	User findUser(String id);
	void saveUser(User user);
	void updateUser(User user);
	int validateEmail(String id);	
	boolean validateEmail(String role, int type);
}
