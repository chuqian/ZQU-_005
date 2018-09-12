
package com.service;

/**
 *@author : 李国鹏
 *@datetime : Sep 7, 2018 8:04:16 PM
 *@descriptioin :  
 */
public interface RegisterService {
	/**
	 * 获取要返回的视图
	 * @param path
	 * @return
	 */
	String getRedirect(String path);
	
	/**
	 * 将注册账号信息写入数据库
	 * @param path
	 * @param user
	 */
	void saveObject(String path, String password, String email);
	
	/**
	 * 获取缓存中相应 key 的值
	 * @param key
	 * @return
	 */
	String getCache(String key);
	
	/**
	 * 设置缓存相应的 key 和 value
	 * @param key
	 * @param value
	 */
	void setCache(String key, String value);
	
	/**
	 * 设置缓存的过期时间
	 * @param key
	 * @param seconds
	 */
	void expireCache(String key, int seconds);
	
	/**验证邮箱
	 * @param id
	 * @return
	 */
	boolean validateEmail(String id, String role);	
}
