package com.service;

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
	 * @return
	 */
	public Pager<Commodity> list();
	
	/**
	 * 添加/修改
	 * @param commodity
	 * @return 1:操作成功; 0:操作失败
	 */
	public int addOrUpdate(Commodity commodity);
	
	/**
	 * 商品上/下架
	 * @param shelf 1:上架; 0:下架
	 * @return 1:操作成功; 0:操作失败
	 */
	public int onOrDown(String id, int shelf);

}
