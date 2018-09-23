package com.service;

import java.util.Map;

import com.common.PageQueryVo;
import com.common.Pager;
import com.dto.Commodity;
import com.dto.SellerOrder;
import com.entity.Seller;

/**
 * @author chenchuqian
 * @date 2018年9月11日 上午11:22:29
 * @describe 
 */
public interface SellerService {

	/**
	 * 商家/店铺信息
	 * @param sellerId
	 * @return
	 */
	public Seller info(String sellerId); 
	
	/**
	 * 商家/店铺信息保存
	 * @param seller
	 */
	public void infoSave(Map<String, String> editInfo);
	
 	/**
	 * 店铺注销
	 * @param sellerId
	 */
	public void storeCancel(String sellerId);
 	/**
	 * 获取在卖商品
	 * @param sellerId
	 * @param commodity
	 * @param page
	 * @return
	 */
	public Pager<Commodity> getCommodiyBySeller(String sellerId, Commodity commodity, PageQueryVo page);
	
	/**
	 * 添加在卖商品
	 * @param sellerId
	 * @param commodity
	 */
	public void commodityToSeller(String sellerId, Commodity commodity);
	
	/**
	 * 卖家所有订单
	 * @param sellerId
	 * @param orderState
	 * @param page
	 * @return
	 */
	public Pager<SellerOrder> getOrders(String sellerId, int orderState, PageQueryVo page);

}
