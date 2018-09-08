
package com.dao;

import com.entity.Customer;

/**
 *@author : 李国鹏
 *@datetime : Sep 7, 2018 2:46:34 PM
 *@descriptioin :  买家 Dao 接口
 */
public interface CustomerDao extends BaseDao<Customer>{
	/**
	 * 注册时根据 email 查询此 email 是否已经注册过买家
	 * @param email
	 * @return
	 */
	Customer findByEmail(String email);
}
