/**
 *@author : lgpeng
 *@datetime : Sep 3, 2018 8:43:21 PM
 *@descriptioin :  
 */
package com.util;

import java.security.spec.EncodedKeySpec;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.entity.User;

public class MD5 {
	
	/**
	 * encode the user password 
	 * @param password
	 * @param userName
	 * @return encodePassword
	 */
	public String encode(String password, String userName) {
		String encodedPassword = new Md5Hash(password, userName).toHex();
		
		return encodedPassword;
	}
}
