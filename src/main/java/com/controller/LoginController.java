package com.controller;

import java.io.IOException;
import javax.servlet.http.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.realm.MyUsernamePasswordToken;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 10:03:10 AM
 *@descriptioin :  
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	private final String LOGIN_FIAL = "fail";

	@ResponseBody
	@RequestMapping(value = "/{role}", method = RequestMethod.POST)
	public String login(HttpServletRequest request, boolean rememberMe, @PathVariable(value="role")String role) throws IOException {

		Subject subject = SecurityUtils.getSubject();
		MyUsernamePasswordToken token = new MyUsernamePasswordToken(request.getParameter("logUsername"), request.getParameter("logPassword"), role);
		token.setRememberMe(rememberMe);
		
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
			return LOGIN_FIAL;
		}
		
		return null;
	}
}
