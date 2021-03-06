package com.customer.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Type;
import com.service.TypeService;

/**
 * @author liangjiahong
 * @date 2018年9月25日 上午11:46:41
 * @describe 
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class TypeTest {
	
	@Autowired
	private TypeService typeService;
	
	@Test
	public void getAllType() {
		List<Type> lists = typeService.getAllType();
		for (Type type : lists) {
			System.out.println(type.toString());
		}
	}
	
	@Test
	public void testDeleteOneType() {
		String id = "type14";
		typeService.deleteOneType(id);
	}
	
	@Test
	public void testDeleTypeOneCommodityType() {
		String id = "type993";
		String commodityType = "商品类型5";
		typeService.deleTypeOneCommodityType(id, commodityType);
	}
	
}
