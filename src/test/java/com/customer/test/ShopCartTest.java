/**
 *@author : lgpeng
 *@datetime : Sep 20, 2018 4:34:20 PM
 *@descriptioin :  
 */
package com.customer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dao.CustomerDao;
import com.dto.Commodity;
import com.dto.CommodityMsg;
import com.entity.CustomerOrder;
import com.entity.ShopCart;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class ShopCartTest {
	@Autowired
	CustomerDao customerDao;
	
	@Test
	public void testInsertCart() {
		ShopCart shopCart = new ShopCart();
		shopCart.setCommodityId("124");
		shopCart.setCustomerId("123");
		shopCart.setCount(12);
		shopCart.setAmount(123);
		customerDao.insertCart(shopCart);
	}
	
	@Test
	public void updateCart() {
		customerDao.updateCart(1, 2, "124");
	}
	
	@Test
	public void insertOder() {
		List<CommodityMsg> list = new ArrayList<>();
		CommodityMsg commodityMsg = new CommodityMsg();
		CommodityMsg commodityMsg2 = new  CommodityMsg();
		commodityMsg.setCommodityId("1236");
		commodityMsg.setCommodityName("苹果");
		commodityMsg.setPrice(520d);
		commodityMsg2.setCommodityId("1237");
		commodityMsg2.setCommodityName("雪梨");
		commodityMsg2.setPrice(5200d);
		list.add(commodityMsg);
		list.add(commodityMsg2);
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setOrderid("1235");
		customerOrder.setCustomerId("123");
		customerOrder.setCommoditys(list);
		
		customerDao.insertOrder(customerOrder);
	}
	
	@Test
	public void findOrder() {
		List<CustomerOrder> list;
		list = customerDao.findOrder("果");
		
		for(CustomerOrder customerOrder : list)
			System.out.println("success to find the order " + customerOrder.getOrderid());
	}
}
