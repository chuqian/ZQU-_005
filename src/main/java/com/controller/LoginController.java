/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 10:03:10 AM
 *@descriptioin :  
 */
package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;


@Controller
public class LoginController {
	
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(User user, HttpServletResponse response) throws IOException {
 
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getId(), user.getPassword());
		
		try {
			subject.login(token);
			if(subject.hasRole("admin"))
				return "admin";
			else if(subject.hasRole("user"))
				return "user";
			else 
				return "saller";
		} catch (Exception e) {
			// TODO: handle exception
			
			Map<String, Object> map = new HashMap<>();
			map.put("msg", "1");
			JSON json = new JSONObject(map);

			response.getWriter().println(json);
			response.getWriter().close();
	
		}
		
		return null;
	}
}
