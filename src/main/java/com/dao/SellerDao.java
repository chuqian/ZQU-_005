package com.dao;

import java.util.List;
import java.util.Map;

import com.dto.Comment;
import com.dto.Commodity;
import com.dto.SellerOrder;
import com.entity.Seller;
import com.mongodb.WriteResult;

/**
 * @author liangjiahong
 * @date 2018年8月31日 下午9:39:47
 * @describe 商家类接口
 */
public interface SellerDao extends BaseDao<Seller>{
	
	/**
	 * 条件查询
	 * @param seller
	 * @return
	 */
	public List<Seller> findByCondition(Seller seller);

	/**
	 * 条件分页查询
	 * @param seller
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<Seller> findByCondition(Seller seller, int skip, int limit);
	
	/** add by lgp
	 * 注册时根据 email 查询此 email 是否已经注册过卖家
	 * @param email
	 * @return
	 */
	public Seller findByEmail(String email);
	
	/**
	 * 统计记录条数 
	 * @param seller
	 * @return
	 */
	long rowsCount(Seller seller);
	
	/**
	 * 模糊查询
	 * @param key
	 * @param value
	 * @return
	 */
	public List<Seller> findFuzzy(String key,String value);
	
	/**
	 * 更新数据
	 * @param key1
	 * @param value1
	 * @param key2
	 * @param value2
	 * @return
	 */
	int update(String key1, String value1, String key2, Object value2, String key3, String value3);
	
	/**
	 * 第一层修改
	 * @param sellerId
	 * @param name
	 * @param store
	 */
	void updateSellerFirst(String sellerId, String name, String store);
	
	/**
	 * 第二层修改
	 * @param sellerId
	 * @param secondName
	 * @param price
	 */
	WriteResult updateSellerSecond(String commodityId, String secondName, Double price);
	
	/**
	 * 第二层添加
	 * @param sellerId
	 * @param commodity
	 */
	void insertSellerSecond(String sellerId, Commodity commodity);
	
	/**
	 * 第二层删除，信息要完全匹配才可以删除
	 * @param commodityId
	 */
	void deleteSellerSecond(String commodityId);
	
	/**
	 * 第三层添加，评论
	 * @param commodityId
	 * @param comment
	 */
	void insertComment(String commodityId, Comment comment);
	
	/**
	 * 第三层修改，回复评论
	 * @param commentId
	 * @param comment
	 */
	int updateCommentAnswer(String commodityId, Comment comment);

	/**
	 * 第三层修改，修改评论状态
	 * @param commodityId
	 * @param comment
	 * @return
	 */
	int updateCommentState(String commodityId, Comment comment);
	
	
	
	/**
	 * 获取商家店铺/信息
	 * @param sellerId
	 * @return
	 */
	Seller getInfoById(String sellerId);
	
	/**
	 * 商家店铺/信息保存
	 * @param editInfo
	 */
	void InfoSave(Map<String, String> editInfo);
	
 	/**
	 * 店铺注销
	 * @param sellerId
	 */
	void storeCancel(String sellerId);
	
	/**
	 * 获取商家在卖商品
	 * @param sellerId
	 * @param skip
	 * @param limit
	 * @return
	 */
	List<Commodity> getCommodiyBySeller(String sellerId, long skip, long limit);
	
	/**
	 * 新增在卖商品
	 * @param sellerId
	 * @param commodity
	 */
	void commodityToSeller(String sellerId, Commodity commodity);
 	/**
	 * 获取商家订单
	 * @param sellerId
	 * @param orderState 
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<SellerOrder> getOrdersBySeller(String sellerId, int orderState, long skip, long limit);
}
