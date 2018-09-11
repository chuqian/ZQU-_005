
package com.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.dao.CustomerDao;
import com.entity.Customer;

/**
 *@author : 李国鹏
 *@datetime : Sep 7, 2018 2:47:18 PM
 *@descriptioin :  买家 Dao 接口实现类
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
	
	private static final String EMAIL = "email";
	@Override
	public Customer findByEmail(String email) {
		Query query = new Query(Criteria.where(EMAIL).is(email));
		
		if(this.getMongoTemplate().find(query, Customer.class).size() != 0)
			return this.getMongoTemplate().find(query, Customer.class).get(0);
		
		return null;
	}
	
}
