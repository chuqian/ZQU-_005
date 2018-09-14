/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 7:44:13 PM
 *@descriptioin :  
 */
package com.user.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private UserService userService;
	
	
	public void testInsertUser() {
		String permissions[] = new String[2];
		permissions[0] = "add";
		permissions[1] = "delete";
		String roles[] = new String[2];
		roles[0] = "admin";
		roles[1] = "user";
		User user = new User();
		user.setId("1234567");
		user.setRoles(roles);
		user.setUserType("admin");
		user.setPassword(MD5.encode("1234567", "1234567"));
		user.setPermissions(permissions);
	
		userService.saveUser(user);
	}
	
	
	public void testFindUser() {
		System.out.println("the user id is " + userService.findUser("123").getId());
	}
	
	@Test
    public void test() {
    	String testd = "12";
    	Pattern pattern = Pattern.compile(testd);
    	Matcher matcher = pattern.matcher("23");
    	System.out.println(matcher.matches());
    }
}
