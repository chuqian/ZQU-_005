
package com.service;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Customer;

/**
 *@author : 李国鹏
 *@datetime : Sep 6, 2018 4:55:26 PM
 *@descriptioin :  
 */
@Service
public interface CustomerService {
	void saveCustomer(BaseDao<Customer> cBaseDao, Customer customer);
}
