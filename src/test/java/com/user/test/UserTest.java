/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 7:44:13 PM
 *@descriptioin :  
 */
package com.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.User;
import com.service.UserService;
import com.util.MD5;
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class UserTest {
	
	@Autowired
	private User user;
	@Autowired
	private UserService userService;
	
	@Test
	public void testInsertUser() {
		String permissions[] = new String[2];
		permissions[0] = "add";
		permissions[1] = "delete";
		String roles[] = new String[2];
		roles[0] = "admin";
		roles[1] = "user";
		user.setId("123");
		user.setRoles(roles);
		user.setUserType("admin");
		user.setPassword(MD5.encode("123", "123"));
		user.setPermissions(permissions);
	
		userService.saveUser(user);
	}
	
	@Test
	public void testFindUser() {
		System.out.println("the user id is " + userService.findUser("123").getId());
	}
	
}
