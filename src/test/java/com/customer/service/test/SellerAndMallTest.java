package com.customer.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dto.AfterSale;
import com.dto.Comment;
import com.dto.SellerOrder;
import com.entity.Seller;
import com.service.SellerAndMallService;

/**
 * @author liangjiahong
 * @date 2018年9月25日 上午11:46:41
 * @describe 
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class SellerAndMallTest {
	
	@Autowired
	private SellerAndMallService sellerAndMallService;
	
	@Test
	public void testFindByCommodityId() {
		String commodityId = "shangping1Tue Sep 25 16:13:21 CST 2018";
		Seller seller = sellerAndMallService.findByCommodityId(commodityId);
		System.out.println(seller.toString());
	}
	
	@Test
	public void testUpdateCollentNum() {
		String commodityId = "shangping1Tue Sep 25 16:13:21 CST 2018";
		int flag = -1;
		int re = sellerAndMallService.updateCollentNum(commodityId, flag);
		System.out.println(re);
	}
	
	@Test
	public void testInsertSellerOrder() {
		Random ra =new Random();
		int ran = ra.nextInt(1000)+1;
		String SellerId = "5ba9ee225370c75264dde2d3";
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
		int re = sellerAndMallService.insertSellerOrder(SellerId, sellerOrder);
		System.out.println(re);
	}
	
	@Test
	public void testInsertComments() {
		String commodityId = "shangping16Tue Sep 25 16:13:21 CST 2018";
		List<Comment> comments = new ArrayList<>();
		Random ra =new Random();
		for (int i = 0; i < 3; i++) {
			int ran = ra.nextInt(1000+i)+1;
			Comment comment = new Comment();
			comment.setContent("评论9999999" + ran);
			comment.setContentTime(new Date());
			comment.setMember(i + "成员" + ran);
			comment.setState(1);
			comments.add(comment);
		}
		int re = sellerAndMallService.insertComments(commodityId, comments);
		System.out.println(re);
	}
	
	@Test
	public void testInsertAfterSale() {
		String SellerId = "5ba9ee225370c75264dde2d3";
		String SellerOrderId = "shangjiadingdan1Tue Sep 25 16:13:21 CST 2018";
		Random ra =new Random();
		int ran = ra.nextInt(1000)+1;
		AfterSale afterSale = new AfterSale();
		afterSale.setReturnId("sellerReturnId" + ran);
		afterSale.setApplytime(new Date());
		afterSale.setSeviceType(1);
		afterSale.setReason("码数不合+1");
		int re = sellerAndMallService.insertAfterSale(SellerId, SellerOrderId, afterSale);
		System.out.println(re);
	}
	
	@Test
	public void testUpdateAfterSale() {
		String SellerId = "5ba9ee225370c75264dde2d3";
		String SellerOrderId = "shangjiadingdan1Tue Sep 25 16:13:21 CST 2018";
		AfterSale afterSale = new AfterSale();
		afterSale.setDealtime(new Date());
		afterSale.setReturnState(0);
		int re = sellerAndMallService.updateAfterSale(SellerId, SellerOrderId, afterSale);
		System.out.println(re);
	}
}
