
package com.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.BaseCacheService;
import com.dao.BaseDao;
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
	private Seller seller;
	@Autowired
	private Customer customer;
	@Resource(name = "sellerBaseDaoImpl")
	private BaseDao<Seller> sBaseDao;
	@Resource(name = "customerBaseDaoImpl")
	private BaseDao<Customer> cBaseDao;
	@Autowired
	private BaseCacheService baseCacheService;
	private static final String REDIRECT_VIEW = "返回买家的视图";
	
	public String getRedirect(String path) {
		if(REDIRECT_VIEW.equals(path))
			return REDIRECT_VIEW;
		else
			return "要卖家的视图";
	}
	
	public void saveObject(String path,String password, String email) {
		
		if(REDIRECT_VIEW.equals(path)) {
			if(sBaseDao.findByEmail(email))
			customer.setEmail(email);
			cBaseDao.save(customer);
		}
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
