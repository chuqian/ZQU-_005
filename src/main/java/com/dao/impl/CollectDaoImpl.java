package com.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dao.CollectDao;
import com.entity.Collect;

/**
 * @author liangjiahong
 * @date 2018年9月29日 下午4:55:00
 * @describe 
 */
@Repository
public class CollectDaoImpl extends BaseDaoImpl<Collect> implements CollectDao {

	@Override
	public Collect findByCusIdAndCommodity(String customerId, String commodityId) {
		Criteria criteria = new Criteria();
		criteria = Criteria.where("customerId").is(customerId).where("commodityId").is(commodityId);
		Query query = new Query(criteria);		
		this.getMongoTemplate().find(query, Collect.class);
		return null;
	}
	
}
