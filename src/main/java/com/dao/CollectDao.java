package com.dao;

import com.entity.Collect;

/**
 * @author liangjiahong
 * @date 2018年9月29日 下午4:54:41
 * @describe 
 */
public interface CollectDao extends BaseDao<Collect> {
	
	/**
	 * 根据顾客id和商品id查找收藏夹
	 * @param customerId
	 * @param commodityId
	 * @return
	 */
	Collect findByCusIdAndCommodity(String customerId, String commodityId);
}
