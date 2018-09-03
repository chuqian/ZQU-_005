/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 11:23:00 AM
 *@descriptioin :  
 */
package com.realm;

import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.entity.User;
import com.service.UserService;

@Component 
public class LoginRealm extends AuthorizingRealm {
	
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		User user = (User)principals.getPrimaryPrincipal();
		System.out.println("the user type is " + user);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(Arrays.asList(user.getRoles()));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("step into loginrealm");
		String userName = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		
		User user = userService.findUser(userName);
		
		if(user == null)
			throw new UnknownAccountException();/*no account was found*/
		
		if(!user.getPassword().equals(password)) {
			System.out.println("the login id is " + user.getId());
			System.out.println("the login user password is " + user.getPassword());
			throw new IncorrectCredentialsException();/*error password*/
		}

		return new SimpleAuthenticationInfo(user, new Md5Hash(user.getPassword(), ""), "LoginRealm");
		
	}
 
}