package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.AllCommodityDao;
import com.dao.ConditionBeanUnit;
import com.dao.SellerDao;
import com.entity.AllCommodity;
import com.entity.Seller;

/**
 * @author liangjiahong
 * @date 2018年9月20日 上午10:44:18
 * @describe 
 */
@Repository
public class AllCommodityDaoImpl extends BaseDaoImpl<AllCommodity> implements AllCommodityDao {

	@Override
	public List<AllCommodity> findFuzzy(List<ConditionBeanUnit> conditionBeanUnits, int skip, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
