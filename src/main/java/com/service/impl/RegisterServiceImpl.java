
package com.service.impl;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cache.BaseCacheService;
import com.dao.CustomerDao;
import com.dao.SellerDao;
import com.dao.UserDao;
import com.entity.Customer;
import com.entity.Seller;
import com.entity.User;
import com.service.RegisterService;
import com.util.MD5;

/**
 *@author : 李国鹏
 *@datetime : Sep 7, 2018 8:06:01 PM
 *@descriptioin :  注册接口的实现类
 */
@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private BaseCacheService baseCacheService;
	private final String SELLER = "seller";
	private final String CUSTOMER = "customer";
	private final String REDIRECT_VIEW = "customer";
	
	public String getRedirect(String path) {
		if(REDIRECT_VIEW.equals(path))
			return REDIRECT_VIEW;
		else
			return SELLER;
	}
	
	public void saveObject(String role,String password, String email) {
		User user = new User();
		String uuid = UUID.randomUUID().toString();
		
		if(REDIRECT_VIEW.equals(role)) {
			Customer customer = new Customer();
			customer.setId(uuid);
			customer.setEmail(email);
			customerDao.save(customer);
			
			if(sellerDao.findByEmail(email) == null) { //此 email 没有注册过卖家 
				String roles[] = {CUSTOMER};
				user.setId(uuid);
				user.setPassword(MD5.encode(password, uuid));
				user.setRoles(roles);
				userDao.save(user);
			}
			else {
				String key = sellerDao.findByEmail(email).getId();
				userDao.addRole(key, CUSTOMER);
			}
		}
		else {
			Seller seller = new Seller();
			seller.setId(uuid);
			seller.setEmail(email);
			sellerDao.save(seller);
			
			if(customerDao.findByEmail(email) == null) { //此 email 没有注册过买家 
				String roles[] = {SELLER};
				user.setId(uuid);
				user.setPassword(MD5.encode(password, uuid));
				user.setRoles(roles);
				userDao.save(user);
			}
			else {
				String key = sellerDao.findByEmail(email).getId();
				userDao.addRole(key, CUSTOMER);
			}
		}
	}

	@Override
	public boolean validateEmail(String email, String role) {
		if(SELLER.equals(role)) 
			if(sellerDao.findByEmail(email) == null)
				return true;	//此账号没有注册过卖家
			else
				return false;
		else
			if(customerDao.findByEmail(email) == null)
				return true;	//此账号没有注册过买家
			else 
				return false;
	}

	@Override
	public String getCache(String key) {
		return baseCacheService.get(key);
	}

	@Override
	public void setCache(String key, String value) {
		baseCacheService.set(key, value);
	}

	@Override
	public void expireCache(String key, int seconds) {
		baseCacheService.expire(key, seconds);
	}
	
}
