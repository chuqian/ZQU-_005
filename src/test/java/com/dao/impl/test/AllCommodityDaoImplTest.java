package com.dao.impl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.AllCommodityDaoImpl;
import com.entity.AllCommodity;
import com.util.ConditionBeanUnit;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class AllCommodityDaoImplTest {

	@Autowired
	private AllCommodityDaoImpl allCommodityDaoImpl;
	
	/**
	 * 多条件（商品id、商品价格、商品类型）模糊查询商品,分页
	 */
	@Test
	public void testFindFuzzy(){
		long startTime = System.currentTimeMillis(); // 获取开始时间
		ConditionBeanUnit co1 = new ConditionBeanUnit();
		ConditionBeanUnit co2 = new ConditionBeanUnit();
		ConditionBeanUnit co3 = new ConditionBeanUnit();
		List<ConditionBeanUnit> lists = new ArrayList<ConditionBeanUnit>();
		co1.setKey("id");
		co1.setValue("allCommodity5");
		lists.add(co1);
		co2.setKey("commodityName");
		co2.setValue("商品2");
		lists.add(co2);
		co3.setKey("commodityType");
		co3.setValue("类型1");
		lists.add(co3);
		List<AllCommodity> allCommodities = allCommodityDaoImpl.findFuzzy(lists,0,12);
		for (AllCommodity allCommodity : allCommodities) {
			System.out.println(allCommodity.toString());
		}
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
	}
	
	/**
	 * 查询所有平台商品，分页
	 */
	@Test
	public void testPage() {
		List<AllCommodity> lists = new ArrayList<AllCommodity>();
		lists = allCommodityDaoImpl.find(0, 20);
		System.out.println(lists.size());
	}
	
	/**
	 * 批量添加平台商品信息
	 */
	@Test
	public void testInsert(){
		List<AllCommodity> lists = new ArrayList<AllCommodity>();
		Random ra =new Random();
		for (int i = 1; i <= 3; i++) {
			AllCommodity allCommodity = new AllCommodity();
			int ran = ra.nextInt(100+i)+1;
			allCommodity.setId("allCommodity" + ran + i);
			allCommodity.setCommodityName("商品" + ran + i);
			allCommodity.setCommodityType("类型" + ran + i);
			allCommodity.setImgSrc("图片地址" + ran + i);
			allCommodity.setPrice(1.00 + i);
			allCommodity.setSaledNum(0 + i);
			allCommodity.setSellerId("seller" + ran + i);
			System.out.println(allCommodity.toString());
			lists.add(allCommodity);
		}
		System.out.println(lists.size());
		allCommodityDaoImpl.save(lists);
	}
	
	@Test
	public void testUpdate() {
		AllCommodity allCommodity = new AllCommodity();
		Random ra =new Random();
		int ran = ra.nextInt(1000)+1;
		allCommodity.setId("allCommodity553");
		allCommodity.setCommodityName("商品" + ran);
		allCommodity.setCommodityType("类型" + ran);
		allCommodity.setImgSrc("图片地址" + ran);
		allCommodity.setPrice(1.00);
		allCommodity.setSaledNum(0);
		allCommodity.setSellerId("seller" + ran);
		allCommodityDaoImpl.save(allCommodity);
	}
	
}
