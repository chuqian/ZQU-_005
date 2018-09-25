package com.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dao.TypeDao;
import com.entity.Type;

/**
 * @author liangjiahong
 * @date 2018年9月19日 上午11:50:36
 * @describe 商品类型接口实现
 */
@Repository
public class TypeDaoImpl extends BaseDaoImpl<Type> implements TypeDao {
	
	@Override
	public int deleteCommodityTypes(String id, String commodityType) {
		try {
			Query query = Query.query(Criteria.where("_id").is(id));
			Update update = new Update();
			update.pull("commodityTypes", commodityType);
			this.getMongoTemplate().updateMulti(query, update, Type.class);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}
}
