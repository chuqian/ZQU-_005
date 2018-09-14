
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
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.entity.User;
import com.service.LoginService;
import com.service.UserService;
import com.util.MD5;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 11:23:00 AM
 *@descriptioin :  自定义 realm
 */
public class LoginRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(Arrays.asList(user.getRoles()));
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		MyUsernamePasswordToken token2 = (MyUsernamePasswordToken)token;
		String role = token2.getRole();
		String userName = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		
		User user = loginService.getUser(role, userName);
		
		System.out.println(user);
		System.out.println("the role is " + role);
		System.out.println("the login password is " + password);
		
		if(user == null) 
			throw new UnknownAccountException();	//没有此账号
		
		if(!user.getPassword().equals(MD5.encode(password, user.getId()))) {
			System.out.println("the password error");
			throw new IncorrectCredentialsException();	//密码错误
		}
		/**																		    
		 * 	传入 user 对象方面后面的授权操作
		 *	token 的密码已在 LoginController 进行盐值加密，所以直接传入数据库的密码进行匹配即可  
		 */
		return new SimpleAuthenticationInfo(user,  user.getPassword(), getName());

	}
 
}
