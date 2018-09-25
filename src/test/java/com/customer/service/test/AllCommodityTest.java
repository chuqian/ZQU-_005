package com.customer.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.AllCommodity;
import com.service.AllCommodityService;
import com.util.ConditionBeanUnit;

/**
 * @author liangjiahong
 * @date 2018年9月25日 上午11:46:41
 * @describe
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class AllCommodityTest {

	@Autowired
	private AllCommodityService allCommodityService;

	@Test
	public void testGetAllCommodityByPage() {
		List<AllCommodity> lists = allCommodityService.getAllCommodityByPage(0, 10);
		for (AllCommodity allCommodity : lists) {
			System.out.println(allCommodity.toString());
		}
	}

	@Test
	public void testGetSearchCommodityByPage() {
		ConditionBeanUnit co1 = new ConditionBeanUnit();
		ConditionBeanUnit co2 = new ConditionBeanUnit();
		ConditionBeanUnit co3 = new ConditionBeanUnit();
		List<ConditionBeanUnit> conditionBeanUnits = new ArrayList<ConditionBeanUnit>();
		co1.setKey("id");
		co1.setValue("allCommodity5");
		conditionBeanUnits.add(co1);
		co2.setKey("commodityName");
		co2.setValue("商品2");
		conditionBeanUnits.add(co2);
		co3.setKey("commodityType");
		co3.setValue("类型1");
		conditionBeanUnits.add(co3);
		List<AllCommodity> lists = allCommodityService.getSearchCommodityByPage(conditionBeanUnits, 0, 10);
		for (AllCommodity allCommodity : lists) {
			System.out.println(allCommodity.toString());
		}
	}

	@Test
	public void testSaveOneAllCommodity() {
		Random ra = new Random();
		AllCommodity allCommodity = new AllCommodity();
		for (int i = 1; i <= 1; i++) {
			int ran = ra.nextInt(100 + i) + 1;
			allCommodity.setId("allCommodity" + ran + i);
			allCommodity.setCommodityName("商品" + ran + i);
			allCommodity.setCommodityType("类型" + ran + i);
			allCommodity.setImgSrc("图片地址" + ran + i);
			allCommodity.setPrice(1.00 + i);
			allCommodity.setSaledNum(0 + i);
			allCommodity.setSellerId("seller" + ran + i);
			System.out.println(allCommodity.toString());
		}
		int re = allCommodityService.saveOrUpdateOneAllCommodity(allCommodity);
		System.out.println(re);
	}

	@Test
	public void testUpdateOneAllCommodity() {
		AllCommodity allCommodity = new AllCommodity();
		allCommodity.setId("allCommodity631");
		allCommodity.setCommodityName("商品wwwww");
		allCommodity.setCommodityType("类型www");
		allCommodity.setImgSrc("图片地址www");
		allCommodity.setPrice(1.00);
		allCommodity.setSaledNum(0);
		allCommodity.setSellerId("seller");
		System.out.println(allCommodity.toString());
		int re = allCommodityService.saveOrUpdateOneAllCommodity(allCommodity);
		System.out.println(re);
	}

	@Test
	public void testDeleteOneAllCommodity() {
		String id = "allCommodity501";
		int re = allCommodityService.deleteOneAllCommodity(id);
		System.out.println(re);
	}
}
