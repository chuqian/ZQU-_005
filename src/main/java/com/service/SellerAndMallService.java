package com.service;

import java.util.List;

import com.dto.AfterSale;
import com.dto.Comment;
import com.dto.SellerOrder;
import com.entity.Seller;

/**
 * @author liangjiahong
 * @date 2018年9月25日 上午10:26:22
 * @describe 
 */
public interface SellerAndMallService {

	/**
	 * 根据商品id查询商铺信息及商品信息(商品详情)
	 * @param commodityId
	 * @return Seller
	 */
	public Seller findByCommodityId(String commodityId);
	
	/**
	 * 查询商品是否存在，根据商品id修改商品收藏数量
	 * @param commodityId
	 * @param flag 为1时加1，为-1时减1
	 * @return 1操作成功，-1操作失败
	 */
	public int updateCollentNum(String commodityId, int flag);
	
	/**
	 * 根据卖家Id插入订单信息(订单生成)
	 * @param SellerId
	 * @param sellerOrder
	 * @return 1操作成功，-1操作失败
	 */
	public int insertSellerOrder(String SellerId, SellerOrder sellerOrder);
	
	/**
	 * 根据商品id增加批量评论(评论订单里的商品)
	 * @param CommodityId
	 * @param comments
	 * @return 1操作成功，-1操作失败
	 */
	public int insertComments(String commodityId, List<Comment> comments);
	
	/**
	 * 查询商家及订单是否存在，根据商家订单id添加售后服务信息
	 * @param SellerId
	 * @param SellerOrderId
	 * @param afterSale
	 * @return
	 */
	public int insertAfterSale(String SellerId, String SellerOrderId, AfterSale afterSale);
	
	/**
	 * 查询商家及订单是否存在，根据商家订单id修改售后服务信息
	 * @param SellerId
	 * @param SellerOrderId
	 * @param afterSale
	 * @return
	 */	
	public int updateAfterSale(String SellerId, String SellerOrderId, AfterSale afterSale);
}
