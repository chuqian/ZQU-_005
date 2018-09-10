
package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.cache.BaseCacheService;
import com.dao.BaseDao;
import com.dao.UserDao;
import com.dao.impl.SellerDaoImpl;
import com.entity.Customer;
import com.entity.Seller;
import com.entity.User;
import com.service.CustomerService;
import com.service.RegisterService;
import com.service.SellerService;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.util.CodeUtil;
import com.util.MD5;
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
	public ModelAndView registerSaller(@RequestParam(value = "role")String role, HttpServletRequest request) {
		String email = (String)request.getParameter("email");
		String password = (String)request.getParameter("password");
		String returnView = registerService.getRedirect(role);
		
		registerService.saveObject(role, email, MD5.encode(password, email));
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
	public void getCode(HttpServletRequest request, HttpServletResponse response) {
		String code = CodeUtil.generateUniqueCode();
		String email = (String)request.getParameter("email");
		new Thread(new MailUtil(email, code)).start(); //启动发送验证码线程
		
		registerService.setCache(code, code);
		registerService.expireCache(code, 60); //验证码时间为 60s
		registerService.setCache(email, email);
		registerService.expireCache(email, 60);
	
		try {
			response.getWriter().write(code);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	/**
	 * @param request
	 * @param response
	 * @description 验证用户输入的验证码是否与服务器发送的验证码一致
	 */
	@ResponseBody
	@RequestMapping(value = "/validateCode", method = RequestMethod.POST)
	public void validateCode(HttpServletRequest request, HttpServletResponse response) {
		String preCode = request.getParameter("code");
		String preEmail = request.getParameter("email");
		String afterCode = registerService.getCache(preCode);
		String afterEmail = registerService.getCache(preEmail);
		
		try {
			if(afterEmail == null)	//不是原先的 email
				response.getWriter().write("0");
			else if(afterCode == null)	//与服务器发送的验证码不一致
				response.getWriter().write("0");
			else 
				response.getWriter().write("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param role
	 * @param request
	 * @param response
	 * @description 检查此邮箱是否已经注册 
	 */
	@ResponseBody
	@RequestMapping(value = "/validateEmail/{role}", method = RequestMethod.POST)
	public void validateEmail(@RequestParam(value = "role")String role, HttpServletRequest request, HttpServletResponse response) {
		String email = (String) request.getParameter("email");
		
		try {
			if(registerService.validateEmail(role, registerService.validateEmail(email, role)))
				response.getWriter().write("1");
			else
				response.getWriter().write("0");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
