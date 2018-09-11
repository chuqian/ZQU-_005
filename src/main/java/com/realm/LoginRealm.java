
package com.realm;

import java.util.Arrays;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.entity.User;
import com.service.UserService;
import com.util.MD5;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 11:23:00 AM
 *@descriptioin :  自定义 realm
 */
@Component 
public class LoginRealm extends AuthorizingRealm {
	
	@Autowired
	private User user;
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(Arrays.asList(user.getRoles()));
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String)token.getPrincipal();
		System.out.println("the loginRealm userName is " + userName);
		String password = new String((char[])token.getCredentials());
		
		user = userService.findUser(userName);
		System.out.println("the loginRealm find user is " + user.getPassword());
		if(user == null) 
			throw new UnknownAccountException();/*no account was found*/
		
		if(!user.getPassword().equals(MD5.encode(password, userName))) { 
			System.out.println("the database's password is " + user.getPassword() + " the input password is " + password);
			throw new IncorrectCredentialsException();/*error password*/
		}
		System.out.println("the realm name is " + getName());
		return new SimpleAuthenticationInfo(user.getId(), password, getName());
	}
 
}
