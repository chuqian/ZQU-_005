package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CollectDao;
import com.entity.Collect;
import com.service.CollectService;

/**
 * @author liangjiahong
 * @date 2018年9月29日 下午5:05:26
 * @describe 
 */
@Service
public class CollectServiceImpl implements CollectService {
	
	@Autowired
	private CollectDao collectDao;

	@Override
	public Collect findByCusIdAndCommodity(String customerId, String commodityId) {
		return collectDao.findByCusIdAndCommodity(customerId, commodityId);
	}
	
	
}
