package com.service;

import com.entity.User;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:49:19 PM
 *@descriptioin :  
 */
public interface UserService {
	/**查找账号信息
	 * @param id
	 * @return user
	 */
	User findUser(String id);
	
	/**保存账号信息
	 * @param user
	 */
	void saveUser(User user);
	
	/**添加角色
	 * @param user
	 */
	void updateRole(String id, String role);
	
	/**
	 * 修改账号密码
	 * @param key
	 * @param password
	 */
	void updatePassword(String id, String password);
	

}
