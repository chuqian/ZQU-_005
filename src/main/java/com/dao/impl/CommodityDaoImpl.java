package com.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dao.CommodityDao;
import com.dto.Commodity;
import com.entity.AllCommodity;
import com.entity.Seller;

/**
 * @author chenchuqian
 * @date 2018年8月29日 下午3:45:10
 * @describe 商品接口实现类
 */
@Repository
public class CommodityDaoImpl extends BaseDaoImpl<AllCommodity> implements CommodityDao {

	@Override
	public List<AllCommodity> findByCondition(AllCommodity commodity) {
		Pattern pattern = Pattern.compile("^.*" + commodity.getCommodityName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		return this.getMongoTemplate().find(new Query(criteria), AllCommodity.class);
	}

	@Override
	public List<AllCommodity> findByCondition(AllCommodity commodity, int skip, int limit) {
		Pattern pattern = Pattern.compile("^.*" + commodity.getCommodityName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern);
		Query query = new Query(criteria).skip(skip).limit(limit);
		return this.getMongoTemplate().find(query, AllCommodity.class);
	}
	
	@Override
	public long rowsCount(AllCommodity commodity){
		Pattern pattern = Pattern.compile("^.*" + commodity.getCommodityName() + ".*$", Pattern.CASE_INSENSITIVE);
		Criteria criteria = Criteria.where("name").regex(pattern);
		return this.getMongoTemplate().count(new Query(criteria), Commodity.class);
	}
	
	@Override
	public boolean commodityUpload(Commodity commodity, AllCommodity allCommodity) {
		Query query = new Query(Criteria.where("_id").is(allCommodity.getSellerId()));
		Update update = new Update().push("commoditys", commodity);
		//把商品添加到卖家
		this.getMongoTemplate().findAndModify(query, update, Seller.class);
		//把商品添加到平台商品中
		this.getMongoTemplate().save(allCommodity);
		return true;
	}

}
