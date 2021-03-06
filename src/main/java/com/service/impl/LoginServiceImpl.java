package com.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.UserDao;
import com.entity.User;
import com.service.LoginService;

/**
 *@author : lgpeng
 *@datetime : Sep 13, 2018 11:12:40 AM
 *@descriptioin :  
 */
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserDao userDao;
	private final String SELLER = "seller";
    private final String CUSTEMER = "customer";
   
	@Override
	public String getLoginSuccessUrl(String role) {
		if(SELLER.equals(role))
			return "/shopping/seller.jsp";
		else if(CUSTEMER.equals(role))
			return "/shopping/customer.jsp";
		else 
			return "/shopping/admin.jsp";
	}

	@Override
	public User getUser(String role, String id) {
		User user = null;
		String phone = "/^1[3,5,7,8]\\d{9}$/";
		String email = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
		Pattern pattern = Pattern.compile(phone);
		Pattern pattern2 = Pattern.compile(email);
		Matcher matcher = pattern.matcher(id);
		Matcher matcher2 = pattern2.matcher(id);
		
		if(SELLER.equals(role)) {
			if(matcher.matches() && id.length() == 11) {		//卖家通过手机登录
				user = userDao.getUserFromSellerByPhone(id);
				if(user != null)
					return user;
			}
			
			else if(matcher2.matches()) {	//卖家通过 email 登录的
				user = userDao.getUserFromSellerByEmail(id);
				if(user != null)
					return user;
			}
			
			else {	//卖家通过手机号登录
				System.out.println("step into get by name");
				user = userDao.getUserFromSellerByName(id);
				if(user != null)
					return user;
			}
		}
		else if(CUSTEMER.equals(role)){
			if(matcher.matches() && id.length() == 11) {
				user = userDao.getUserFromCustomerByPhone(id);
				if(user != null)
					return user;
			}
			else if(matcher2.matches()) {
				user = userDao.getUserFromCustomerByEmail(id);
				if(user != null)
					return user;
			}
			else {
				user = userDao.getUserFromCustomerByName(id);
				if(user != null)
					return user;
			}
		}
		else {
			user = userDao.findById(id);
			if(user != null)
				return user;
		}
		
		return null;
	}
   
}
