package com.dao.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.CommodityDaoImpl;
import com.dto.SendAddress;
import com.entity.Commodity;
import com.entity.Seller;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class CommodityDaoImplTest {

	@Autowired
	private CommodityDaoImpl commodityDaoImpl;
	
	@Test
	public void testFindAll(){
		System.out.println(commodityDaoImpl.findAll());
	}
	
	@Test
	public void testInsert(){
		Commodity commodity = new Commodity();
		commodity.setName("五谷粉");
		commodity.setPrice(10.5);
		commodity.setSaledNum(12674);
		commodityDaoImpl.insert(commodity);
	}
	
	@Test
	public void testInsert2(){
		SendAddress sendAddress = new SendAddress();
		sendAddress.setCity("guangdoang");
		sendAddress.setCounty("zhaoqing");
		Seller seller = new Seller();
		seller.setName("seller1");
		seller.setSendAddress(sendAddress);
		commodityDaoImpl.insert(seller);
		
		Seller seller2 = new Seller();
		seller2.setName("chenchuqian");
		seller2.setIdentity("441522");
		commodityDaoImpl.insert(seller2);
	}
	
	
	
}
