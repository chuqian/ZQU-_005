package com.dao.impl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.TypeDaoImpl;
import com.entity.Type;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class TypeDaoImplTest {

	@Autowired
	private TypeDaoImpl typeDaoImpl;
	
	@Test
	public void getAllType() {
		List<Type> lists = typeDaoImpl.findAll();
		for (Type type : lists) {
			System.out.println(type.toString());
		}
	}
	
	/**
	 * 添加类型
	 */
	@Test
	public void testInsert(){
		List<String> commodityTypes = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			commodityTypes.add("商品类型" + i);			
		}
		
		List<Type> lists = new ArrayList<Type>();
		Random ra =new Random();
		for (int i = 1; i <= 5; i++) {
			Type type = new Type();
			int ran = ra.nextInt(100+i)+1;
			type.setId("type" + ran + i);
			type.setSellType("类型" + ran + i);
			type.setCommodityTypes(commodityTypes);
			System.out.println(type.toString());
			lists.add(type);
		}
		System.out.println(lists.size());
		typeDaoImpl.save(lists);
	}
	
	/**
	 * 删除一个商品类型
	 */
	@Test
	public void testDeleteOneCommodityTypes() {
		String id = "type993";
		String commodityType = "商品类型1";
		typeDaoImpl.deleteCommodityTypes(id, commodityType);
	}
	
}
