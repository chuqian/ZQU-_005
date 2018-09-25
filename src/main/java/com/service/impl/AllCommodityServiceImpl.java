package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AllCommodityDao;
import com.entity.AllCommodity;
import com.service.AllCommodityService;
import com.util.ConditionBeanUnit;

/**
 * @author liangjiahong
 * @date 2018年9月21日 下午6:24:50
 * @describe 平台商品实现
 */
@Service
public class AllCommodityServiceImpl implements AllCommodityService {
	
	@Autowired
	private AllCommodityDao allCommodityDao;

	@Override
	public List<AllCommodity> getAllCommodityByPage(int skip, int limit) {
		return allCommodityDao.find(skip, limit);
	}

	@Override
	public List<AllCommodity> getSearchCommodityByPage(List<ConditionBeanUnit> conditionBeanUnits, int skip,
			int limit) {
		return allCommodityDao.findFuzzy(conditionBeanUnits, skip, limit);
	}

	@Override
	public int saveOrUpdateOneAllCommodity(AllCommodity allCommodity) {
		return allCommodityDao.save(allCommodity);
	}

	@Override
	public int deleteOneAllCommodity(String id) {
		return allCommodityDao.deleteById(id);
	}


}
