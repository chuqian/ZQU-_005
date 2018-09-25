package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.dao.SellerAndMallDao;
import com.dao.SellerDao;
import com.dto.AfterSale;
import com.dto.Comment;
import com.dto.Commodity;
import com.dto.SellerOrder;
import com.entity.Seller;
import com.service.SellerAndMallService;

/**
 * @author liangjiahong
 * @date 2018年9月25日 上午10:26:43
 * @describe 实现商城操作卖家service
 */
@Service
public class SellerAndMallServiceImpl implements SellerAndMallService {

	@Autowired
	private SellerAndMallDao sellerAndMallDao;
	@Autowired
	private SellerDao sellerDao;

	@Override
	public Seller findByCommodityId(String commodityId) {
		return sellerAndMallDao.findByCommodityId(commodityId);
	}

	@Override
	public int updateCollentNum(String commodityId, int flag) {
		Seller seller = sellerAndMallDao.findByCommodityId(commodityId);
		if(seller!=null) {
			if(seller.getCommoditys()!=null) {
				for (Commodity commodity: seller.getCommoditys()) {
					if(commodityId.equals(commodity.getId()) && !(commodity.getCollectedNum()<=0 && flag==-1)) {
						return sellerAndMallDao.updateCollentNum(commodityId, flag);
					}
					break;
				}
			}
		}
		return -1;		
	}

	@Override
	public int insertSellerOrder(String SellerId, SellerOrder sellerOrder) {
		Seller seller = sellerDao.findById(SellerId);
		if(seller!=null) {
			return sellerAndMallDao.insertSellerOrder(SellerId, sellerOrder);
		}
		return -1;
	}

	@Override
	public int insertComments(String commodityId, List<Comment> comments) {
		Seller seller = sellerAndMallDao.findByCommodityId(commodityId);
		if(seller!=null) {
			if(seller.getCommoditys()!=null) {
				for (Commodity commodity: seller.getCommoditys()) {
					if(commodityId.equals(commodity.getId())) {
						return sellerAndMallDao.insertComments(commodityId, comments);
					}
					break;
				}
			}
		}
		return -1;		
	}

	@Override
	public int insertAfterSale(String SellerId, String SellerOrderId, AfterSale afterSale) {
		Seller seller = sellerDao.findById(SellerId);
		List<SellerOrder> sellerOrders = seller.getSellerOrders();
		if (sellerOrders != null) {
			for (SellerOrder sellerOrder : sellerOrders) {
				if (sellerOrder.getOrderId().equals(SellerOrderId)) {
					if (sellerOrder.getAfterSale() == null) {
						return sellerAndMallDao.insertAfterSale(SellerOrderId, afterSale);
					}
				}
				break;
			}
		}
		return -1;
	}

	@Override
	public int updateAfterSale(String SellerId, String SellerOrderId, AfterSale afterSale) {
		Seller seller = sellerDao.findById(SellerId);
		List<SellerOrder> sellerOrders = seller.getSellerOrders();
		if (sellerOrders != null) {
			for (SellerOrder sellerOrder : sellerOrders) {
				if (sellerOrder.getOrderId().equals(SellerOrderId)) {
					if (sellerOrder.getAfterSale().getDealtime() == null
							&& sellerOrder.getAfterSale().getDealtime() == null) {
						return sellerAndMallDao.updateAfterSale(SellerOrderId, afterSale);
					}
					break;
				}
			}
		}
		return -1;
	}

}
