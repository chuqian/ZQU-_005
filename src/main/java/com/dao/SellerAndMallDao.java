package com.dao;

import java.util.List;

import com.dto.AfterSale;
import com.dto.Comment;
import com.dto.SellerOrder;
import com.entity.Seller;

/**
 * @author liangjiahong
 * @date 2018年9月19日 下午9:20:15
 * @describe 商城操作卖家信息接口
 */
public interface SellerAndMallDao extends BaseDao<Seller> {
	
	/**
	 * 根据商品id查询商铺信息及商品信息
	 * @param commodityId
	 * @return
	 */
	Seller findByCommodityId(String commodityId);
	
	/**
	 * 根据商品id修改商品收藏数量
	 * @param commodityId
	 * @param flag 为1时加1，为-1时减1
	 * @return
	 */
	int updateCollentNum(String commodityId, int flag);
	
	/**
	 * 根据卖家Id插入订单信息
	 * @param SellerId
	 * @param sellerOrder
	 * @return
	 */
	int insertSellerOrder(String SellerId, SellerOrder sellerOrder);
	
	/**
	 * 根据商品id增加批量评论
	 * @param CommodityId
	 * @param comments
	 * @return
	 */
	int insertComments(String CommodityId, List<Comment> comments);
	
	/**
	 * 根据商家订单id添加售后服务信息
	 * @param SellerOrderId
	 * @param afterSale
	 * @return
	 */
	int insertAfterSale(String SellerOrderId, AfterSale afterSale);
	
	/**
	 * 根据商家订单id修改售后服务信息
	 * @param SellerOrderId
	 * @param afterSale
	 * @return
	 */
	int updateAfterSale(String SellerOrderId, AfterSale afterSale);
	
}
