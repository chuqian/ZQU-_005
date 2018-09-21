package com.dao.impl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.SellerAndMallDaoImpl;
import com.dto.AfterSale;
import com.dto.Comment;
import com.dto.Commodity;
import com.dto.SellerOrder;
import com.entity.Seller;

/**
 * @author liangjiahong
 * @date 2018年9月19日 下午9:37:21
 * @describe 
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class SellerAndMallDaoImplTest {
	
	@Resource(name="sellerAndMallDaoImpl")
	private SellerAndMallDaoImpl sellerAndMallDaoImpl;
	
	/**
	 * 根据商品id查询商品信息、商家id、店铺名称
	 */
	@Test
	public void testFindByCommodityId() {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		String commodityId = "shangpin424Mon Sep 10 16:03:50 CST 2018";
		Seller seller = sellerAndMallDaoImpl.findByCommodityId(commodityId);
		String SellerId = seller.getId();
		String SellerName = seller.getName();
		System.out.println("SellerId:"+SellerId+",SellerName:"+SellerName);
		
		List<Commodity> commodities = new ArrayList<>();
		commodities = seller.getCommoditys();
		int i=0;
		for (Commodity commodity : commodities) {
			if (commodityId.equals(commodity.getId())) {
				break;
			}
			i++;
		}
		Commodity commodity = new Commodity();
		commodity = commodities.get(i);
		System.out.println(commodity.toString());
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
	}
	
	/**
	 * 根据商品id修改收藏数量
	 */
	@Test
	public void testUpdateCollentNum() {
		testFindByCommodityId();
		String commodityId = "shangpin424Mon Sep 10 16:03:50 CST 2018";
		int flag = -1;
		int w = sellerAndMallDaoImpl.updateCollentNum(commodityId, flag);
		if(w==1)
			System.out.println("收藏数量已修改");
		testFindByCommodityId();
	}
	
	/**
	 * 根据卖家id添加单个订单信息
	 */
	@Test
	public void testUpdataSellerOrder() {
		Random ra =new Random();
		int ran = ra.nextInt(1000)+1;
//		String SellerId = "shangjia0Mon Sep 10 16:03:50 CST 2018";
		String SellerId = "5b9625662fcc73437f2a47ce";
		
		SellerOrder sellerOrder = new SellerOrder();
		sellerOrder.setOrderId("shangjiadingdan"+ran);
		sellerOrder.setMember("y6666666"+ran);
		sellerOrder.setMoney(777.6+ran);
		sellerOrder.setDateTime(new Date());
		sellerOrder.setOrderState(ran);
		sellerOrder.setLogisticsState(ran);
		sellerOrder.setAfterSale(null);
		sellerOrder.setWayBillNum(null);
		sellerOrder.setLogistics(null);
		int w = sellerAndMallDaoImpl.updataSellerOrder(SellerId, sellerOrder);
		if(w==1)
			System.out.println("添加商家订单成功");
	}
	
	/**
	 * 根据商家id、商品id增加批量评论
	 */
	@Test
	public void testInsertComments() {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		Random ra =new Random();
//		String SellerId = "shangjia0Mon Sep 10 16:03:50 CST 2018";
//		String CommodityId = "shangpin01Mon Sep 10 16:03:50 CST 2018";
		String SellerId = "5b9625662fcc73437f2a47ce";
		String CommodityId = "f7ec6d74ec8640238b7fd38ce199e04a";
		List<Comment> comments = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			int ran = ra.nextInt(1000+i)+1;
			Comment comment = new Comment();
			comment.setContent("评论f7ec6d74ec8640238b7fd38ce199e04a" + ran);
			comment.setContentTime(new Date());
			comment.setMember(i + "成员" + ran);
			comment.setState(1);
			comments.add(comment);
		}
		int w = sellerAndMallDaoImpl.insertComments(CommodityId, comments);
		if(w==1)
			System.out.println("批量添加商品评论成功");
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
	}

	/**
	 * 根据商家id、订单id增加售后信息
	 */
	@Test
	public void testInsertAfterSale() {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		Random ra =new Random();
		int ran = ra.nextInt(1000)+1;
		String SellerId = "5b9625662fcc73437f2a47ce";
		String SellerOrderId = "shangjiadingdan6445";
		AfterSale afterSale = new AfterSale();
		afterSale.setReturnId("sellerReturnId" + ran);
		afterSale.setApplytime(new Date());
		afterSale.setSeviceType(1);
		afterSale.setReason("码数不合");
		afterSale.setDealtime(null);
		afterSale.setReturnState(null);
		System.out.println(afterSale.toString());
		int w = sellerAndMallDaoImpl.insertAfterSale(SellerId, SellerOrderId, afterSale);
		if(w==1)
			System.out.println("添加售后成功");
		else {
			System.out.println("添加售后失败");
		}
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
	}

	/**
	 * 根据商家id、订单id修改售后信息
	 */
	@Test
	public void testUpdateAfterSale() {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		Random ra =new Random();
		int ran = ra.nextInt(1000)+1;
		String SellerId = "5b9625662fcc73437f2a47ce";
		String SellerOrderId = "shangjiadingdan6445";
		AfterSale afterSale = new AfterSale();
		afterSale.setReturnId("sellerReturnId" + ran);
		afterSale.setApplytime(new Date());
		afterSale.setSeviceType(1);
		afterSale.setReason("码数不合");
		afterSale.setDealtime(null);
		afterSale.setReturnState(null);
		System.out.println(afterSale.toString());
		int w = sellerAndMallDaoImpl.updateAfterSale(SellerId, SellerOrderId, afterSale);
		if(w==1)
			System.out.println("修改售后成功");
		else {
			System.out.println("修改售后失败");
		}
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
	}
	
	

}
