
package com.util;

import org.apache.shiro.crypto.hash.Md5Hash;
/**
 *@author : lgpeng
 *@datetime : Sep 3, 2018 8:43:21 PM
 *@descriptioin :  对用户的密码进行加密
 */
public class MD5 {
	/**
	 * 对密码进行加密 
	 * @param password
	 * @param userName
	 * @return encodePassword
	 */
	public static final String encode(String password, String id) {
		String encodedPassword = new Md5Hash(password, id).toString();
		
		return encodedPassword;
	}
}
