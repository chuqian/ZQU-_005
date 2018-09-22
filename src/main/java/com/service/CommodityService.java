package com.service;

import java.util.List;

import com.common.PageQueryVo;
import com.common.Pager;
import com.dto.Commodity;
import com.entity.AllCommodity;
import com.entity.Seller;

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
	 * 删除商品
	 * @param sellerId
	 * @param commodityId
	 * @return
	 */
	public boolean delete(String sellerId, String commodityId);

	/**
	 * 商品上架
	 * @param sellerId 卖家id
	 * @param commodity 商品信息
	 * @return true 成功 false 失败 
	 * @author linjie
	 */
	public boolean commodityUpload(String sellerId, Commodity commodity);
	
	/**
	 * 查找商家商品
	 * @param sellerId 卖家id
	 * @param skip 当前位置
	 * @param size 一次查询商品数
	 * @return
	 */
	public List<Commodity> findSellerCommodity(String sellerId, int skip, int size);
	
	/**
	 * 商家锁拥有商品总数
	 * @param sellerId
	 * @return
	 */
	int count(String sellerId);
	
}
