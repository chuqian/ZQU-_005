package com.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 *@author : lgpeng
 *@datetime : Sep 14, 2018 9:14:57 AM
 *@descriptioin :  将 UsernamePasswordToken 改成自己想要的形式
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken{
	private String role;
	private static final long serialVersionUID = 1L;
	
	public MyUsernamePasswordToken(final String userName, final String password, final String role) {
		super(userName, password);
		this.role = role;
	}
	
	public MyUsernamePasswordToken(final String userName, final String password, final String role, final boolean rememberMe) {
		super(userName, password, rememberMe);
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
