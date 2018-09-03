package com.dao;

import java.util.List;

import com.entity.Seller;
import com.mongodb.WriteResult;

/**
 * @author liangjiahong
 * @date 2018年8月31日 下午9:39:47
 * @describe 商家类接口
 */
public interface SellerDao {
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
	WriteResult updateSellerSecond(String sellerId,String commodityId, String secondName, Double price);
}
