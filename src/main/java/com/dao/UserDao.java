/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:57:23 PM
 *@descriptioin :  
 */
package com.dao;

import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserDao {
	User findUser(String id);
	void insertUser(User user);
}
