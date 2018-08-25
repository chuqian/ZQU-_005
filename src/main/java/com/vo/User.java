package com.vo;
/**
 * @author chenchuqian
 * @date 2018年8月25日 上午12:13:13
 * @describe 用户类
 */
public class User {
	private String id;        //用户id
	private String password;    //用户密码
	private String userType;    //用户类型
	private String[] roles;     //用户角色
	private String[] permissions;  //用户权限
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public String[] getPermissions() {
		return permissions;
	}
	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}
	
}
