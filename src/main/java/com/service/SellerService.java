package com.service;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Seller;

/**
 *@author : 李国鹏
 *@datetime : Sep 6, 2018 11:10:29 AM
 *@descriptioin :  
 */
@Service
public interface SellerService {
	void saveSeller(BaseDao<Seller> baseDao, Seller seller);
}
