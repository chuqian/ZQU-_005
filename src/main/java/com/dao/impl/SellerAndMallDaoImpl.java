package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.dao.SellerAndMallDao;
import com.dao.SellerDao;
import com.entity.Seller;

/**
 * @author liangjiahong
 * @date 2018年9月20日 上午10:44:53
 * @describe 
 */
@Repository
public class SellerAndMallDaoImpl extends BaseDaoImpl<Seller> implements SellerAndMallDao {

	@Override
	public Seller findByCommodityId(String commodityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int UpdateCollentNum(String commodityId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
