package com.dao;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.support.odps.udf.CodecCheck.A;
import com.dto.Commodity;
import com.entity.AllCommodity;

/**
 * @author chenchuqian
 * @date 2018年8月29日 下午3:43:36
 * @describe 商品类接口
 */
public interface CommodityDao extends BaseDao<AllCommodity>{

	/**
	 * 条件查询
	 * @param commodity
	 * @return
	 */
	public List<AllCommodity> findByCondition(AllCommodity commodity);

	/**
	 * 条件分页查询
	 * @param commodity
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<AllCommodity> findByCondition(AllCommodity commodity, int skip, int limit);

	/**
	 * 统计记录条数 
	 * @param commodity
	 * @return
	 */
	long rowsCount(AllCommodity commodity);
	
	/**
	 * 商品上架
	 * @param commodity
	 * @param allCommodity
	 * @return
	 */
	boolean commodityUpload(Commodity commodity, AllCommodity allCommodity);
	
	/**
	 * 删除上架商品
	 * @param sellerId
	 * @param commodityId
	 * @return
	 */
	boolean commodityDelete(String sellerId, String commodityId);
	
	/**
	 * 删除平台的某件商品
	 * @param commodityId
	 * @return
	 */
	boolean allCommodityDelete(String commodityId);
	
	/**
	 * 查找商家商品
	 * @param sellerId 卖家id
	 * @param skip 当前位置
	 * @param size 一次查询商品数
	 * @return
	 */
	List<Commodity> findSellerCommodity(String sellerId, int skip, int size);
	
	/**
	 * 查找商家某一件商品
	 * @param sellerId 卖家id
	 * @param commodityId 商品id
	 * @return
	 */
	Commodity findSellerCommodityOne(String sellerId, String commodityId);
	
	/**
	 * 商家拥有商品总数
	 * @param sellerId
	 * @return
	 */
	int commodityCount(String sellerId);
	
}
