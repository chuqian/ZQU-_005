package com.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.SellerAndMallDaoImpl;
import com.dto.Commodity;
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
	
	
}
