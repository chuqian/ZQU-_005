
package com.service.impl;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Customer;
import com.service.CustomerService;
/**
 *@author : 李国鹏
 *@datetime : Sep 6, 2018 4:57:12 PM
 *@descriptioin :  
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public void saveCustomer(BaseDao<Customer> cBaseDao, Customer customer) {
		cBaseDao.save(customer);
	}

}
