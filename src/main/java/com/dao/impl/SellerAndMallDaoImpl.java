package com.dao.impl;

import java.util.List;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.dao.SellerAndMallDao;
import com.dto.AfterSale;
import com.dto.Comment;
import com.dto.SellerOrder;
import com.entity.Seller;

/**
 * @author liangjiahong
 * @date 2018年9月20日 上午10:44:53
 * @describe 
 */
@Repository
public class SellerAndMallDaoImpl extends BaseDaoImpl<Seller> implements SellerAndMallDao {

	@Override
	public Seller findByCommodityId(String commodityId) {
		Criteria criteria = Criteria.where("commoditys._id").is(commodityId);
		Query query = new Query(criteria);
		return this.getMongoTemplate().findOne(query, Seller.class);
	}

	@Override
	public int updateCollentNum(String commodityId, int flag) {
		Criteria criteria = Criteria.where("commoditys._id").is(commodityId);
		Query query = new Query(criteria);
		query = new Query(criteria);
		Update update = new Update();
		update.inc("commoditys.$.collectedNum", flag);	
		this.getMongoTemplate().upsert(query, update, Seller.class);
		return 1;
	}
	
	@Override
	public int updataSellerOrder(String SellerId, SellerOrder sellerOrder) {
		Query query = Query.query(Criteria.where("_id").is(SellerId));
		Update update = new Update();
		update.push("sellerOrders", sellerOrder);
		this.getMongoTemplate().upsert(query, update, Seller.class);
		return 1;
	}
	
	@Override
	public int insertComments(String CommodityId, List<Comment> comments) {
		Query query = Query.query(Criteria.where("commoditys._id").is(CommodityId));
		Update update = new Update();
		int size = comments.size();
		for (int i=0; i<size; i++) {
			update.push("commoditys.$.comments", comments.get(i));
			this.getMongoTemplate().upsert(query, update, Seller.class);
		}		
		return 1;
	}
	
	@Override
	public int insertAfterSale(String SellerId, String SellerOrderId, AfterSale afterSale) {
		Criteria criteria = Criteria.where("id").is(SellerId);
		Query query = new Query(criteria);
		int flag=-1;
		try {
			Seller seller = this.getMongoTemplate().findOne(query, Seller.class);
			List<SellerOrder> sellerOrders = seller.getSellerOrders();
			if(sellerOrders!=null) {
				for (SellerOrder sellerOrder : sellerOrders) {
					if(sellerOrder.getOrderId().equals(SellerOrderId)) {
						if(sellerOrder.getAfterSale() == null)
						{
							Criteria criteria1 = Criteria.where("sellerOrders.orderId").is(SellerOrderId);
							Query query1 = new Query(criteria1);
							Update update = new Update();
							update.set("sellerOrders.$.afterSale", afterSale);
							this.getMongoTemplate().upsert(query1, update, Seller.class);
							flag=1;
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
