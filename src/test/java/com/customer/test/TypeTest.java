package com.customer.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.TypeDao;
import com.entity.Type;

/**
 * @author liangjiahong
 * @date 2018年9月25日 上午11:35:17
 * @describe 
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class TypeTest {
	@Autowired
	private TypeDao typeDao;
	
	@Test
	public void getAllType() {
		List<Type> lists = typeDao.findAll();
		for (Type type : lists) {
			System.out.println(type.toString());
		}
	}
	
	@Test
	public void testDeleteCommodityTypes() {
		String id = "type993";
		String commodityType = "商品类型2";
		typeDao.deleteCommodityTypes(id, commodityType);
	}
}
