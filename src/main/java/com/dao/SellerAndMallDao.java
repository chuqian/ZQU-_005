package com.dao;

import com.entity.Seller;

/**
 * @author liangjiahong
 * @date 2018年9月19日 下午9:20:15
 * @describe 商城操作卖家信息接口
 */
public interface SellerAndMallDao extends BaseDao<Seller> {
	
	/**
	 * 根据商品id查询商铺信息及商品信息
	 * @param commodityId
	 * @return
	 */
	Seller findByCommodityId(String commodityId);
	
	
	int UpdateCollentNum(String commodityId);
	
}
