
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CustomerDao;
import com.entity.Customer;
import com.service.CustomerService;

/**
 *@author : 李国鹏
 *@datetime : Sep 6, 2018 4:57:12 PM
 *@descriptioin :  买家 CustomerService 实现类
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Override
	
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

}
