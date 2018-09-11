package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.SellerDao;
import com.entity.Seller;
import com.service.SellerService;

/**
 * @author chenchuqian
 * @date 2018年9月11日 上午11:21:57
 * @describe 卖家service实现
 */
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDao sellerDao;

	@Override
	public void save(Seller seller) {
		sellerDao.save(seller);
	}
	
	
}
