package com.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.CommodityDaoImpl;
import com.entity.AllCommodity;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class CommodityDaoImplTest {

	@Autowired
	private CommodityDaoImpl commodityDaoImpl;
	
	@Test
	public void testInsert(){
		AllCommodity allCommodity = new AllCommodity();
		allCommodity.setCommodityName("炒米粉");
		allCommodity.setPrice(10.5);
		allCommodity.setSaledNum(12674);
		commodityDaoImpl.save(allCommodity);
	}
	
	@Test
	public void testInsert2(){
		List<AllCommodity> list = new ArrayList<>();
		for(int i=0; i<20; i++){
			AllCommodity commodity = new AllCommodity();
			commodity.setCommodityName("name" + i); 
			list.add(commodity);
		}
		commodityDaoImpl.save(list);
	}
	
	@Test
	public void testUpdate(){
		List<AllCommodity> list = commodityDaoImpl.findAll();
		for(int i=0; i<list.size(); i++){
			AllCommodity allCommodity = list.get(i);
			allCommodity.setCommodityName("naem" + i + 1); 
			allCommodity.setPrice(null);
			/*commodity.setPrice(100.0 + i + 1);*/
			list.set(i, allCommodity);
		}
		int count = commodityDaoImpl.save(list);
		System.out.println(count);
	}

	@Test
	public void testDelete() {
		List<AllCommodity> list = commodityDaoImpl.findAll();
		String[] ids = new String[list.size()];
		for(int i=0; i<ids.length; i++)
			ids[i] = list.get(i).getId();
		commodityDaoImpl.deleteById(ids);
	}
	
	@Test
	public void testRowsCount() {
		System.out.println(commodityDaoImpl.rowsCount());
	}
}
