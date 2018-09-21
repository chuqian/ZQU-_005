package com.dao;

import java.util.List;

import com.entity.Customer;
import com.entity.CustomerOrder;
import com.entity.ShopCart;

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
	
	/**
	 * 更新购物车
	 * @param count
	 * @param amount
	 * @param commodityId
	 */
	void updateCart(int count, double amount, String commodityId);
	
	/**
	 * 生成购物车
	 * @param cart
	 */
	void insertCart(ShopCart cart);
	
	/**
	 * 检查买家购物车是否已经存在此商品
	 * @param customerId
	 * @param commodityId
	 * @return
	 */
	ShopCart findShopCart(String customerId, String commodityId);
	
	/**
	 * 生成订单
	 * @param order
	 */
	void insertOrder(CustomerOrder order);
	
	/**
	 * 查找订单
	 * @param key
	 * @return
	 */
	List<CustomerOrder> findOrder(String value);
	
	/**
	 * 删除订单
	 * @param orderId
	 */
	void deleteOrder(String orderId);
}
