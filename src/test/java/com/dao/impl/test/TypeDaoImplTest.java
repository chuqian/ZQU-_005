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
		commodityTypes.add("蒸蛋糕");			
		commodityTypes.add("脱水蛋糕");			
		commodityTypes.add("瑞士卷");			
		commodityTypes.add("软面包");			
		commodityTypes.add("马卡龙");			
		commodityTypes.add("千层饼");			
		commodityTypes.add("甜甜圈");			
		commodityTypes.add("蒸三明治");			
		commodityTypes.add("铜锣烧");			
		commodityTypes.add("猪肉脯");			
		commodityTypes.add("牛肉丝");			
		commodityTypes.add("小香肠");			
		commodityTypes.add("豆干");			
		commodityTypes.add("干笋");			
		commodityTypes.add("鸭脖");			
		commodityTypes.add("开心果");			
		commodityTypes.add("锅巴");			
		commodityTypes.add("杏仁");			
		commodityTypes.add("瓜子");			
		commodityTypes.add("坚果");			
		commodityTypes.add("糖果");			
		commodityTypes.add("蜜饯");			
		commodityTypes.add("猕猴桃干");			
		commodityTypes.add("巧克力");			
		commodityTypes.add("果冻");			
		commodityTypes.add("海带丝");			
		commodityTypes.add("小鱼干");			
		commodityTypes.add("鱿鱼丝");			
		commodityTypes.add("玫瑰花茶");			
		commodityTypes.add("菊花茶");			
		commodityTypes.add("茉莉花茶");			
		commodityTypes.add("大包装");			
		commodityTypes.add("两件套");			
		commodityTypes.add("奥迪");			
		commodityTypes.add("迪奥");			
		
		List<Type> lists = new ArrayList<Type>();
		Type type1 = new Type();
//		type.setId("type" + ran + i);
		type1.setSellType("蛋糕/饼干");
		type1.setCommodityTypes(commodityTypes);
		System.out.println(type1.toString());
		lists.add(type1);
			
		Type type2 = new Type();
		type2.setSellType("熟食/肉类");
		type2.setCommodityTypes(commodityTypes);
		System.out.println(type2.toString());
		lists.add(type2);
			
		Type type3 = new Type();
		type3.setSellType("素食/卤味");
		type3.setCommodityTypes(commodityTypes);
		System.out.println(type3.toString());
		lists.add(type3);
			
		Type type4 = new Type();
		type4.setSellType("糖果/蜜饯");
		type4.setCommodityTypes(commodityTypes);
		System.out.println(type4.toString());
		lists.add(type4);
			
		Type type5 = new Type();
		type5.setSellType("巧克力");
		type5.setCommodityTypes(commodityTypes);
		System.out.println(type5.toString());
		lists.add(type5);
			
		Type type6 = new Type();
		type6.setSellType("海味/河鲜");
		type6.setCommodityTypes(commodityTypes);
		System.out.println(type6.toString());
		lists.add(type6);
			
		Type type7 = new Type();
		type7.setSellType("花茶/果茶");
		type7.setCommodityTypes(commodityTypes);
		System.out.println(type7.toString());
		lists.add(type7);
			
		Type type8 = new Type();
		type8.setSellType("品牌/礼包");
		type8.setCommodityTypes(commodityTypes);
		System.out.println(type8.toString());
		lists.add(type8);
			
			
			
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
