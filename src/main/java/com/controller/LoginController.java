
package com.controller;

import java.io.IOException;
import javax.servlet.http.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.entity.User;
import com.util.MD5;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 10:03:10 AM
 *@descriptioin :  处理登录请求
 */
@Controller
public class LoginController {
	
	private final String LOGIN_FIAL = "fail";
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpServletResponse response, boolean rememberMe) throws IOException {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getId(), MD5.encode(user.getPassword(), user.getId()));
		token.setRememberMe(rememberMe);
		
		try {
			subject.login(token);
			if(subject.hasRole("admin"))		
				return "admin";	
			else if(subject.hasRole("user")) 
				return "user";
			else 
				return "saller";
		} catch (Exception e) {
			return LOGIN_FIAL;
		}
	}
}
