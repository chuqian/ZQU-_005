package com.dao;

import com.entity.User;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:57:23 PM
 *@descriptioin :  User Dao 接口
 */
public interface UserDao extends BaseDao<User>{
	/**
	 * 增加角色
	 * @param key
	 * @param value
	 */
	void addRole(String key, String value);
	
	/**
	 * 修改密码
	 * @param key
	 * @param value
	 */
	void updatePassword(String key, String value);
}
