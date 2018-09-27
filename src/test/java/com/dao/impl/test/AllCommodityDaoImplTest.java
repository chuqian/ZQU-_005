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
		
		AllCommodity allCommodity1 = new AllCommodity();
		allCommodity1.setCommodityName("车厘子");
		allCommodity1.setCommodityType("水果");
		allCommodity1.setImgSrc("../customerFile/images/2.jpg");
		allCommodity1.setPrice(13.8);
		allCommodity1.setSaledNum(0);
		allCommodity1.setSellerId("seller");
		System.out.println(allCommodity1.toString());
		lists.add(allCommodity1);
		
		AllCommodity allCommodity2 = new AllCommodity();
		allCommodity2.setCommodityName("雪之恋和风大福");
		allCommodity2.setCommodityType("水果");
		allCommodity2.setImgSrc("../customerFile/images/1.jpg");
		allCommodity2.setPrice(13.8);
		allCommodity2.setSaledNum(0);
		allCommodity2.setSellerId("seller");
		System.out.println(allCommodity2.toString());
		lists.add(allCommodity2);
		
		AllCommodity allCommodity3 = new AllCommodity();
		allCommodity3.setCommodityName("雪之恋和风大福");
		allCommodity3.setCommodityType("水果");
		allCommodity3.setImgSrc("../customerFile/images/3.jpg");
		allCommodity3.setPrice(13.8);
		allCommodity3.setSaledNum(0);
		allCommodity3.setSellerId("seller");
		System.out.println(allCommodity3.toString());
		lists.add(allCommodity3);
		
		AllCommodity allCommodity4 = new AllCommodity();
		allCommodity4.setCommodityName("雪之恋和风大福");
		allCommodity4.setCommodityType("水果");
		allCommodity4.setImgSrc("../customerFile/images/5.jpg");
		allCommodity4.setPrice(13.8);
		allCommodity4.setSaledNum(0);
		allCommodity4.setSellerId("seller");
		System.out.println(allCommodity4.toString());
		lists.add(allCommodity4);
		
		AllCommodity allCommodity5 = new AllCommodity();
		allCommodity5.setCommodityName("小优布丁");
		allCommodity5.setCommodityType("水果");
		allCommodity5.setImgSrc("../customerFile/images/6.jpg");
		allCommodity5.setPrice(13.8);
		allCommodity5.setSaledNum(0);
		allCommodity5.setSellerId("seller");
		System.out.println(allCommodity5.toString());
		lists.add(allCommodity5);
		
		AllCommodity allCommodity6 = new AllCommodity();
		allCommodity6.setCommodityName("雪之恋和风大福");
		allCommodity6.setCommodityType("水果");
		allCommodity6.setImgSrc("../customerFile/images/7.jpg");
		allCommodity6.setPrice(13.8);
		allCommodity6.setSaledNum(0);
		allCommodity6.setSellerId("seller");
		System.out.println(allCommodity6.toString());
		lists.add(allCommodity6);
		
		AllCommodity allCommodity7 = new AllCommodity();
		allCommodity7.setCommodityName("雪之恋和风大福");
		allCommodity7.setCommodityType("水果");
		allCommodity7.setImgSrc("../customerFile/images/8.jpg");
		allCommodity7.setPrice(13.8);
		allCommodity7.setSaledNum(0);
		allCommodity7.setSellerId("seller");
		System.out.println(allCommodity7.toString());
		lists.add(allCommodity7);
		
		AllCommodity allCommodity8 = new AllCommodity();
		allCommodity8.setCommodityName("雪之恋和风大福");
		allCommodity8.setCommodityType("水果");
		allCommodity8.setImgSrc("../customerFile/images/9.jpg");
		allCommodity8.setPrice(13.8);
		allCommodity8.setSaledNum(0);
		allCommodity8.setSellerId("seller");
		System.out.println(allCommodity8.toString());
		lists.add(allCommodity8);
		
		AllCommodity allCommodity9 = new AllCommodity();
		allCommodity9.setCommodityName("雪之恋和风大福");
		allCommodity9.setCommodityType("水果");
		allCommodity9.setImgSrc("../customerFile/images/2.jpg");
		allCommodity9.setPrice(13.8);
		allCommodity9.setSaledNum(0);
		allCommodity9.setSellerId("seller");
		System.out.println(allCommodity9.toString());
		lists.add(allCommodity9);
			
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
