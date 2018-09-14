package com.service;

import com.common.PageQueryVo;
import com.common.Pager;
import com.dto.Commodity;
import com.entity.AllCommodity;

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
	public Pager<AllCommodity> list(AllCommodity commodity, PageQueryVo page);
	
	/**
	 * 添加/修改
	 * @param commodity
	 * @return succe/fail
	 */
	public String save(AllCommodity commodity);
	
	/**
	 * 商品删除
	 * @param id
	 * @return succe/fail
	 */
	public String delete(String id);

	/**
	 * 商品上架
	 * @param sellerId 卖家id
	 * @param commodity 商品信息
	 * @return true 成功 false 失败 
	 * @author linjie
	 */
	public boolean commodityUpload(String sellerId, Commodity commodity);
	
}
