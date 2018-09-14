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
	
	/**
	 * 根据卖家登录的用户名去查找相应的 id 和密码
	 * @param name
	 * @return
	 */
	User getUserFromSellerByName(String name);
	
	/**
	 * 根据卖家登录的 email 去查找相应的 id 和密码
	 * @param email
	 * @return
	 */
	User getUserFromSellerByEmail(String email);
	
	/**
	 * 根据卖家登录的手机号去查找相应的 id 和密码
	 * @param phone
	 * @return
	 */
	User getUserFromSellerByPhone(String phone);
	
	/**
	 * 根据买家登录的用户名去查找相应的 id 和密码
	 * @param name
	 * @return
	 */
	User getUserFromCustomerByName(String name);
	
	/**
	 * 根据买家登录的 email 去查找相应的 id 和密码
	 * @param email
	 * @return
	 */
	User getUserFromCustomerByEmail(String email);
	
	/**
	 * 根据买家登录的手机去查找相应的 id 和密码
	 * @param phone
	 * @return
	 */
	User getUserFromCustomerByPhone(String phone);
}
