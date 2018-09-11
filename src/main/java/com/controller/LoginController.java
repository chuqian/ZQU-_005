
package com.controller;

import java.io.IOException;
import javax.servlet.http.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.entity.User;
import com.util.MD5;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 10:03:10 AM
 *@descriptioin :  
 */
@Controller
public class LoginController {
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpServletResponse response) throws IOException {
		System.out.println("the user id is " + user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getId(),user.getPassword());
		Session session = subject.getSession();
		
		try {
			subject.login(token);
			if(subject.hasRole("admin")) {
				System.out.println("return admin");
				return "admin";
			}
				
			else if(subject.hasRole("user")) {
				System.out.println("return  user");
				return "user";
			}
				
				
			else {
				System.out.println("return saller");
				return "saller";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("1");
		}
		
		return null;
	}
}
