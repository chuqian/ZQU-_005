package com.dao;

import java.util.Date;
import java.util.List;
import com.dto.GetAddress;
import com.entity.Collect;
import com.entity.CommentMsg;
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
	 * 检测此昵称是否已经存在
	 * @param nickName
	 * @return
	 */
	Customer findByNickName(String nickName);
	
	/**
	 * 设置买家的昵称和姓名（设置完后不能进行修改）
	 * @param userName
	 * @param nickName
	 * @param customerId
	 */
	void updateCustomer(String userName, String nickName, String customerId);
	
	/**
	 * 换绑 email
	 * @param email
	 */
	void alterEmail(String email, String customerId);
	
	/**
	 * 修改买家手机号码
	 * @param phone
	 * @param customerId
	 */
	void alterPhone(String phone, String customerId);
	
	/**
	 * 更新购物车
	 * @param count
	 * @param amount
	 * @param commodityId
	 */
	void updateCart(int count, double amount, String commodityId, String customerId);
	
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
	ShopCart isExistCart(String customerId, String commodityId);
	
	/**
	 * 获取买家购物车的所有信息（进行分页操作）
	 * @return
	 */
	List<ShopCart> findAllCart(String customerId, String lastId, int recordCount, int findType);
	
	/**
	 * 对买家的购物车进行模糊查询（进行分页操作）
	 * @param customerId
	 * @param value
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<ShopCart> findCartByFuzzy(String customerId, String value, String lastId, int recordCount, int findType);
	
	/**
	 * 根据买家 Id 和商品 id 删除相应的购物车
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
	 * 查找买家所有的订单
	 * @param customerId
	 * @param idFiled
	 * @param lastId
	 * @param sortFiled
	 * @param recordCount
	 * @param findType
	 * @return
	 */
	List<CustomerOrder> findAllOrder(String customerId, String idFiled, String lastId, String sortFiled, int recordCount, int findType);
	
	/**
	 * 对买家订单进行模糊查询
	 * @param customerId
	 * @param value
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<CustomerOrder> findOrderByFuzzy(String customerId, String value, String lastId, int recordCount, int findType);
	
	/**
	 * 删除订单
	 * @param orderId
	 */
	void deleteOrder(String orderId);
	
	/**
	 * 对订单进行更新（主要是对售后信息进行更新）
	 * @param dealTime
	 * @param orderId
	 */
	void updateOrder(Date dealTime, String orderId);
	
	/**
	 * 查询买家收货地址
	 * @param customerId
	 * @return
	 */
	List<Customer> getAddresses(String customerId);
	
	/**
	 * 添加收货地址
	 * @param address
	 * @param customerId
	 */
	void insertAddress(GetAddress address, String customerId);
	
	/**
	 * 删除地址
	 * @param addressId
	 * @param customerId
	 */
	void deleteAddress(String addressId, String customerId);
	
	/**
	 * 更新收货地址
	 * @param address
	 * @param customerId
	 */
	void updateAddress(GetAddress address, String customerId);

	/**
	 * 添加商品收藏
	 * @param collection
	 */
	void insertCollection(Collect collection);
	
	/**
	 * 删除收藏夹里面的商品
	 * @param customerId
	 * @param commodityId
	 */
	void deleteCollection(String customerId, String commodityId);
	
	/**
	 * 检查买家收藏夹是否已收藏此商品
	 * @param customerId
	 * @param commodityId
	 * @return
	 */
	Collect isExistCollection(String customerId, String commodityId);
	
	/**
	 * 查询收藏夹的所有信息
	 * @param customerId
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<Collect> findCollection(String customerId, String lastId, int recordCount, int findType);
	
	/**
	 * 获取买家售后清单
	 * @param customerId
	 * @param lastId
	 * @param recordCount
	 * @return
	 */
	List<CustomerOrder> getAfterSale(String customerId, String lastId, int recordCount, int findType);
	
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
