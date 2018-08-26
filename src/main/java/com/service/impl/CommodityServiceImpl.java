package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.Pager;
import com.dao.impl.CommodityDaoImpl;
import com.entity.Commodity;
import com.service.CommodityService;

/**
 * 
 * @author chenchuqian
 * @date 2018年8月26日 下午8:54:38
 * @describe
 */
@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDaoImpl commodityDaoImpl;
	
	@Override
	public Pager<Commodity> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int addOrUpdate(Commodity commodity) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int onOrDown(String id, int shelf) {
		// TODO Auto-generated method stub
		return 1;
	}

}
