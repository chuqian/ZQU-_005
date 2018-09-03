/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 7:44:13 PM
 *@descriptioin :  
 */
package com.user.test;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entity.User;
import com.service.UserService;

public class UserTest {
	
	private User user;
	private UserService userService;
	
	public void testInsertUser() {
		init();
		
		String permissions[] = new String[2];
		permissions[0] = "add";
		permissions[1] = "delete";
		
		String roles[] = new String[2];
		roles[0] = "admin";
		roles[1] = "user";
		user.setId("12312");
		user.setRoles(roles);
		user.setUserType("admin");
		user.setPassword("123");
		user.setPermissions(permissions);
	
		userService.insertUser(user);
	}
	
	@Test
	public void testFindUser() {
		init();
		
		System.out.println("the user id is " + userService.findUser("123").getId());
	}
	
	public void init() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		user = (User)applicationContext.getBean("user");
		userService = (UserService)applicationContext.getBean("userServiceImpl");
	}
}
