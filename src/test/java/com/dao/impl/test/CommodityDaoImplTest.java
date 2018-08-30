package com.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.CommodityDaoImpl;
import com.entity.Commodity;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class CommodityDaoImplTest {

	@Autowired
	private CommodityDaoImpl commodityDaoImpl;
	
	@Test
	public void testFindAll(){
		List<Commodity> list = commodityDaoImpl.findAll();
	}
	
	@Test
	public void testInsert(){
		Commodity commodity = new Commodity();
		commodity.setName("炒米粉");
		commodity.setPrice(10.5);
		commodity.setSaledNum(12674);
		commodityDaoImpl.save(commodity);
	}
	
	@Test
	public void testInsert2(){
		List<Commodity> list = new ArrayList<>();
		for(int i=0; i<20; i++){
			Commodity commodity = new Commodity();
			commodity.setName("name" + i); 
			list.add(commodity);
		}
		commodityDaoImpl.save(list);
	}
	
	@Test
	public void testUpdate(){
		List<Commodity> list = commodityDaoImpl.findAll();
		for(int i=0; i<list.size(); i++){
			Commodity commodity = list.get(i);
			commodity.setName("naem" + i + 1); 
			commodity.setPrice(null);
			/*commodity.setPrice(100.0 + i + 1);*/
			list.set(i, commodity);
		}
		int count = commodityDaoImpl.save(list);
		System.out.println(count);
	}

	@Test
	public void testDelete() {
		List<Commodity> list = commodityDaoImpl.findAll();
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
