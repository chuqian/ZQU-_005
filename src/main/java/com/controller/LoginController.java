package com.controller;

import java.io.IOException;
import javax.servlet.http.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realm.MyUsernamePasswordToken;
import com.service.LoginService;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 10:03:10 AM
 *@descriptioin :  
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	private final String LOGIN_FIAL = "fail";
	
	@ResponseBody
	@RequestMapping(value = "/{role}", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, boolean rememberMe, @PathVariable(value="role")String role) throws IOException {
		Subject subject = SecurityUtils.getSubject();
		MyUsernamePasswordToken token = new MyUsernamePasswordToken(request.getParameter("userName"),request.getParameter("password"), role);
		token.setRememberMe(rememberMe);
		
		try {
			subject.login(token);
			return loginService.getLoginSuccessUrl(role);
		} catch (Exception e) {
			e.printStackTrace();
			return LOGIN_FIAL;
		}
	}
}
