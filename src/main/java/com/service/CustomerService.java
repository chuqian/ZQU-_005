
package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dto.GetAddress;
import com.entity.Collect;
import com.entity.CommentMsg;
import com.entity.Customer;
import com.entity.CustomerOrder;
import com.entity.ShopCart;

/**
 *@author : 李国鹏
 *@datetime : Sep 6, 2018 4:55:26 PM
 *@descriptioin :  
 */
public interface CustomerService {
	
	/**
	 * 获取要返回的视图
	 * @param function
	 * @return
	 */
	String getReturnView(String function);
	
	/**
	 * 验证买家修改密码时输入的原密码
	 * @param request
	 * @param password
	 * @return
	 */
	boolean validatePassword(HttpServletRequest request, String password);
	
	/**
	 * 保存买家信息
	 * @param customer
	 */
	void saveCustomer(Customer customer);
	
	/**
	 * 设置买家的昵称和姓名（设置完后不能进行修改）
	 * @param userName
	 * @param nickName
	 * @param customerId
	 */
	boolean updateCustomer(String userName, String nickName, String customerId);
	
	/**
	 * 更换 email、密码、手机号
	 * @param field
	 * @param customerId
	 * @param alterType
	 */
	void alterCustomer(String field, String customerId, String alterType);
	
	/**
	 * 更新购物车的数量和金额
	 * @param count
	 * @param amount
	 * @param commodityId
	 * @param customerId
	 */
	void updateCart(int count, double amount, String commodityId, String customerId);
	
	/**
	 * 添加购物车
	 * @param shopCart
	 * @param customerId
	 * @param commodityId
	 */
	void insertCart(ShopCart shopCart, String customerId, String commodityId);
	
	/**
	 * 获取买家的购物车
	 * @param customerId
	 * @param filed
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<ShopCart> findAllCart(String customerId, String filed, String lastId, int recordCount, int findType);
	
	/**
	 * 对买家购物车进行模糊查询
	 * @param customerId
	 * @param filed
	 * @param value
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<ShopCart> findCartByFuzzy(String customerId, String filed, String value, String lastId, int recordCount, int findType);
	
	/**
	 * 删除买家的购物车
	 * @param customerId
	 * @param commodityId
	 */
	void deleteCart(String customerId, String commodityId);
	
	/**
	 * 生成订单
	 * @param order
	 */
	void insertOrder(CustomerOrder order);
	
	/**
	 * 查找订单详情
	 * @param orderId
	 * @return
	 */
	CustomerOrder findOneOrder(String orderId);
	
	/**
	 *  查找买家的订单
	 * @param customerId
	 * @param idFiled
	 * @param lastId
	 * @param sortFiled
	 * @param recordCount
	 * @param findType : 0 为查找小于页面 id 的数据，1 为查找大于页面 id 的数据
	 * @return
	 */
	List<CustomerOrder> findAllOrder(String customerId, String idFiled, String lastId, String sortFiled, int recordCount, int findType);
	
	/**
	 * 对买家的订单进行模糊查询
	 * @param customerId
	 * @param filed
	 * @param value
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<CustomerOrder> findOrderByFuzzy(String customerId, String filed, String value, String lastId, int recordCount, int findType);
	
	/**
	 * 删除订单
	 * @param orderId
	 */
	void deleteOrder(String orderId);
	
	/**
	 * 对订单进行更新
	 * @param orderId
	 */
	void updateOrder(String orderId);
	
	/**
	 * 获取买家的收货地址
	 * @param customerId
	 * @return
	 */
	List<GetAddress> getAddresses(String customerId);
	
	/**
	 * 添加收货地址
	 * @param address
	 * @param customerId
	 */
	void insertAddress(GetAddress address, String customerId);
	
	/**
	 * 删除买家收货地址
	 * @param addressId
	 * @param customerId
	 */
	void deleteAddress(String addressId, String customerId);
	
	/**
	 * 更新买家收货地址
	 * @param address
	 * @param customerId
	 */
	void updateAddress(GetAddress address, String customerId);
	
	/**
	 * 添加商品收藏
	 * @param collection
	 * @param filed
	 * @param customerId
	 * @param commodityId
	 */
	void insertCollection(Collect collection, String filed, String customerId, String commodityId);
	
	/**
	 * 删除收藏夹里面的商品
	 * @param customerId
	 */
	void deleteCollection(String customerId, String commodityId);
	
	/**
	 * 查询收藏夹的所有信息
	 * @param customerId
	 * @param filed
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<Collect> findCollection(String customerId, String filed, String lastId, int recordCount, int findType);
	
	/**
	 * 获取买家售后清单
	 * @param customerId
	 * @param filed
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<CustomerOrder> getAfterSale(String customerId, String filed, String lastId, int recordCount, int findType);
	
	/**
	 * 插入评论
	 * @param comment
	 */
	void insertCommentMsg(CommentMsg commentMsg);
	
	/**
	 * 删除评论（只是买家自己不可以见)
	 * @param commentId
	 */
	void deleteCommentMsg(String orderId);
	
	/**
	 * 查询买家的所有评论
	 * @param customerId
	 * @param filed
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<CommentMsg> findCommentMsg(String customerId, String filed, String lastId, int recordCount, int findType);
}
