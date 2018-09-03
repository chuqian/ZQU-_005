/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:49:19 PM
 *@descriptioin :  
 */
package com.service;

import org.springframework.stereotype.Service;

import com.entity.User;

@Service
public interface UserService {
	User findUser(String id);
	void insertUser(User user);
}
