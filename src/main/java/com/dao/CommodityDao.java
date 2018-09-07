package com.dao;

import java.util.List;

import com.dto.Commodity;

/**
 * @author chenchuqian
 * @date 2018年8月29日 下午3:43:36
 * @describe 商品类接口
 */
public interface CommodityDao {

	/**
	 * 条件查询
	 * @param commodity
	 * @return
	 */
	public List<Commodity> findByCondition(Commodity commodity);

	/**
	 * 条件分页查询
	 * @param commodity
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<Commodity> findByCondition(Commodity commodity, int skip, int limit);

	/**
	 * 统计记录条数 
	 * @param commodity
	 * @return
	 */
	long rowsCount(Commodity commodity);
	
}
