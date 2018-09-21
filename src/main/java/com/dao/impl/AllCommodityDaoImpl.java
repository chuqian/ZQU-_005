package com.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dao.AllCommodityDao;
import com.entity.AllCommodity;
import com.util.ConditionBeanUnit;

/**
 * @author liangjiahong
 * @date 2018年9月20日 上午10:44:18
 * @describe 
 */
@Repository
public class AllCommodityDaoImpl extends BaseDaoImpl<AllCommodity> implements AllCommodityDao {

	@Override
	public List<AllCommodity> findFuzzy(List<ConditionBeanUnit> conditionBeanUnits, int skip, int limit) {
		Query query = new Query();
		int size = conditionBeanUnits.size();
		Criteria[] criterias = new Criteria[size];
		int i=0;
		for (ConditionBeanUnit co : conditionBeanUnits) {
			criterias[i] = Criteria.where(co.getKey()).regex(co.getValue());
			i++;
		}
		query.addCriteria(new Criteria().orOperator(criterias[0],criterias[1],criterias[2])).skip(skip).limit(limit);
		return this.getMongoTemplate().find(query, AllCommodity.class);
	}

}
