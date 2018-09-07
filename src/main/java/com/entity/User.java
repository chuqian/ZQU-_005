package com.entity;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午10:49:08
 * @describe 用户类
 */
@Component
@Document(collection="user")
public class User implements Serializable {

	private static final long serialVersionUID = 5445975308468971325L;
	
	@Id
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", userType=" + userType + ", roles="
				+ Arrays.toString(roles) + ", permissions=" + Arrays.toString(permissions) + "]";
	}
}
