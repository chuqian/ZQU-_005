
package com.service.impl;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;
import com.entity.Seller;
import com.service.SellerService;
/**
 *@author : 李国鹏
 *@datetime : Sep 6, 2018 3:02:36 PM
 *@descriptioin :  
 */
@Service
public class SellerServiceImpl implements SellerService{

	@Override
	public void saveSeller(BaseDao<Seller> baseDao, Seller seller) {
		// TODO Auto-generated method stub
		baseDao.save(seller);
	}

}
