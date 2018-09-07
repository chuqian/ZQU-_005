package com.service;

import com.entity.User;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:49:19 PM
 *@descriptioin :  
 */
public interface UserService {
	/**
	 * @param id
	 * @return user
	 */
	User findUser(String id);
	
	/**
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * @param id
	 * @return
	 */
	int validateEmail(String id);	
	
	/**
	 * @param role
	 * @param type
	 * @return
	 */
	boolean validateEmail(String role, int type);
}
