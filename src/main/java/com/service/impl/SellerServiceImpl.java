
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.impl.SellerDaoImpl;
import com.entity.Seller;
import com.service.SellerService;

/**
 *@author : 李国鹏
 *@datetime : Sep 7, 2018 2:56:44 PM
 *@descriptioin :  卖家 SellerService 实现类
 */
@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private SellerDaoImpl sellerDaoImpl;
	
	@Override
	public void saveSeller(Seller seller) {
		sellerDaoImpl.save(seller);
	}
	
}
