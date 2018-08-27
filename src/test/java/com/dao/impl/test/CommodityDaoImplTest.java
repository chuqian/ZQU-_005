package com.dao.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.CommodityDaoImpl;
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
	public void testInsertOne(){
		Commodity commodity = new Commodity();
		commodity.setName("五谷粉");
		commodityDaoImpl.insert(commodity);
	}
	
}
