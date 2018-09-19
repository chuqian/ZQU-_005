
package com.service;
/**
 *@author : lgpeng
 *@datetime : Sep 13, 2018 11:11:46 AM
 *@descriptioin :  登录接口
 */

import com.entity.User;

public interface LoginService {
	/**
	 * 获取不同角色登录成功的跳转页面 
	 * @param role
	 * @return
	 */
	public String getLoginSuccessUrl(String role);
	
	/**
	 * 根据登录的账号找到 user 集合里面的 id 和 密码
	 * @param role
	 * @return
	 */
	public User getUser(String role, String id);
	
}
