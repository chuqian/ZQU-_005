package com.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dao.CommodityDao;
import com.entity.Commodity;

/**
 * @author chenchuqian
 * @date 2018年8月29日 下午3:45:10
 * @describe 商品接口实现类
 */
@Repository
public class CommodityDaoImpl extends BaseDaoImpl<Commodity> implements CommodityDao {

	@Override
	public List<Commodity> findByCondition(Commodity commodity) {
		Pattern pattern = Pattern.compile("^.*" + commodity.getName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		return this.getMongoTemplate().find(new Query(criteria), Commodity.class);
	}

	@Override
	public List<Commodity> findByCondition(Commodity commodity, int skip, int limit) {
		Pattern pattern = Pattern.compile("^.*" + commodity.getName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		Query query = new Query(criteria).skip(skip).limit(limit);
		return this.getMongoTemplate().find(query, Commodity.class);
	}
	
	@Override
	public long rowsCount(Commodity commodity){
		Pattern pattern = Pattern.compile("^.*" + commodity.getName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = Criteria.where("name").regex(pattern);
		return this.getMongoTemplate().count(new Query(criteria), Commodity.class);
	}

}
