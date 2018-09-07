
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
import com.service.SellerService;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.util.CodeUtil;
import com.util.MailUtil;
/**
 *@author : lgpeng
 *@datetime : Sep 3, 2018 4:50:11 PM
 *@descriptioin :  
 */
@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseCacheService baseCacheService;
	private static final int NO_ROLE = 0;
	/**
	 * @param seller
	 * @return 注册完后要返回的页面
	 * @description 卖家注册
	 */
	@RequestMapping(value = "/registerSeller", method = RequestMethod.POST)
	public ModelAndView registerSaller(Seller seller) {
		ModelAndView mv = new ModelAndView("注册完后要跳转的页面");
		mv.addObject("seller", seller);
		sellerService.saveSeller(seller);
		
		return mv;
	}
	
	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public ModelAndView registerCustomer(Customer customer) {
		ModelAndView mv = new ModelAndView("注册完后要跳转的页面");
		mv.addObject("customer", customer);
		customerService.saveCustomer(customer);
		
		return mv;
	}
	
	@RequestMapping(value = "/registerAccount", method = RequestMethod.POST)
	public ModelAndView registerAccount(User user) {
		ModelAndView mv = new ModelAndView("注册完账号后要跳转的页面");
		
		if(userService.validateEmail(user.getId()) != NO_ROLE) //此账号没有注册过买家和卖家
			userService.saveUser(user);
		else
			userService.updateUser(user);	//此账号已经注册过卖家或买家其中一个角色账号
		
		mv.addObject("user", user);
		
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
		new MailUtil(email, code).run();
		
		baseCacheService.set(code, code);
		baseCacheService.expire(code, 60);
		baseCacheService.set(email, email);
		baseCacheService.expire(email, 60);
	
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
		String afterCode = baseCacheService.get(preCode);
		String afterEmail = baseCacheService.get(preEmail);
		
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
	@RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
	public void validateEmail(HttpServletRequest request, HttpServletResponse response) {
		String role = (String)request.getParameter("role");
		String email = (String) request.getParameter("email");
		
		try {
			if(userService.validateEmail(role, userService.validateEmail(email)))
				response.getWriter().write("1");
			else
				response.getWriter().write("0");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
