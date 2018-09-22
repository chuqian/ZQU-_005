package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AllCommodityDao;
import com.service.AllCommodityService;

/**
 * @author liangjiahong
 * @date 2018年9月21日 下午6:24:50
 * @describe 平台商品实现
 */
@Service
public class AllCommodityServiceImpl implements AllCommodityService {
	
	@Autowired
	private AllCommodityDao allCommodityDao;

}
