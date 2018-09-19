package com.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.service.RegisterService;
import com.util.CodeUtil;
import com.util.MailUtil;

/**
 *@author : lgpeng
 *@datetime : Sep 3, 2018 4:50:11 PM
 *@descriptioin :  
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * @param seller
	 * @return 注册完后要返回的页面
	 * @description 卖家注册
	 */
	@RequestMapping(value = "/{role}", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, @PathVariable(value = "role")String role) {
		String email = (String)request.getParameter("regUsername");
		String password = (String)request.getParameter("regPassword1");
		String returnView = registerService.getRedirect(role);
		System.out.println("the register email is " + email);
		registerService.saveObject(role, password, email);
		ModelAndView mv = new ModelAndView(returnView);
		mv.addObject("user", email);
		
		return mv;
	}

	/**
	 * @param request
	 * @param response
	 * @description 获取验证码
	 */
	@ResponseBody
	@RequestMapping(value = "/getCode", method = RequestMethod.POST)
	public String getCode(HttpServletRequest request) {
		String code = CodeUtil.generateUniqueCode();
		String email = (String)request.getParameter("email");
		new Thread(new MailUtil(email, code)).start(); //启动发送验证码线程
		
		registerService.setCache(code, code);
		registerService.expireCache(code, 60); //验证码时间为 60s
		registerService.setCache(email, email);
		registerService.expireCache(email, 60);
	
		try {
			return code;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * @description 验证用户输入的验证码是否与服务器发送的验证码一致
	 */
	@ResponseBody
	@RequestMapping(value = "/validateCode", method = RequestMethod.POST)
	public String validateCode(HttpServletRequest request) {
		
		String preCode = request.getParameter("code");
		String preEmail = request.getParameter("email");
		String afterCode = registerService.getCache(preCode);
		String afterEmail = registerService.getCache(preEmail);
		System.out.println("the preemail is " + preEmail + "the precode is " + preCode + " the afteremail is " + afterEmail + " the aftercode is " + afterCode);
		try {
			if(afterEmail == null)	//不是原先的 email
				return "0";
			else if(afterCode == null)	//与服务器发送的验证码不一致
				return "0";
			else 
				return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	/**
	 * @param role
	 * @param request
	 * @param response
	 * @description 检查此邮箱是否已经注册 
	 */
	@ResponseBody
	@RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
	public String validateEmail(HttpServletRequest request) {
		System.out.println("step into validateEmail");
		String role = (String) request.getParameter("role");
		String email = (String) request.getParameter("email");
		
		try {
			if(registerService.validateEmail(email, role))
				return "1";
			else
				return "0";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}	
	}
}
