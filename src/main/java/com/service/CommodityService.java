package com.service;

import com.common.PageQueryVo;
import com.common.Pager;
import com.entity.Commodity;

/**
 * 
 * @author chenchuqian
 * @date 2018年8月26日 下午8:54:19
 * @describe
 */
public interface CommodityService {
	
	/**
	 * 商品展示
	 * @param commodity
	 * @param page
	 * @return
	 */
	public Pager<Commodity> list(Commodity commodity, PageQueryVo page);
	
	/**
	 * 添加/修改
	 * @param commodity
	 * @return succe/fail
	 */
	public String save(Commodity commodity);
	
	/**
	 * 商品删除
	 * @param id
	 * @return succe/fail
	 */
	public String delete(String id);

	/**
	 * 商品上/下架
	 * @param shelf 1:上架; 0:下架
	 * @return succe/fail
	 */
	public String onOrDown(String id, int shelf);
	
}
