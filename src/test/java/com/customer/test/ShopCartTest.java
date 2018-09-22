/**
 *@author : lgpeng
 *@datetime : Sep 20, 2018 4:34:20 PM
 *@descriptioin :  
 */
package com.customer.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dao.CustomerDao;
import com.dao.SellerDao;
import com.dto.CommodityMsg;
import com.dto.GetAddress;
import com.entity.Customer;
import com.entity.CustomerOrder;
import com.entity.Seller;
import com.entity.ShopCart;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class ShopCartTest {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	SellerDao sellerDao;

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
	public void insertOrder() {
		List<CommodityMsg> list = new ArrayList<>();
		CommodityMsg commodityMsg = new CommodityMsg();
		CommodityMsg commodityMsg2 = new  CommodityMsg();
		commodityMsg.setCommodityId("123634");
		commodityMsg.setCommodityName("苹果");
		commodityMsg.setPrice(520d);
		commodityMsg2.setCommodityId("123734");
		commodityMsg2.setCommodityName("雪梨");
		commodityMsg2.setPrice(5200d);
		list.add(commodityMsg);
		list.add(commodityMsg2);
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setOrderId("12345");
		customerOrder.setCustomerId("123");
		customerOrder.setCommoditys(list);
		customerOrder.setOrderState(1);
		
		customerDao.insertOrder(customerOrder);
	}
	
	@Test
	public void findOrder() {
		List<CustomerOrder> list;
		list = customerDao.findOrder("12345");
		
		for(CustomerOrder customerOrder : list)
			System.out.println("success to find the order " + customerOrder.getOrderId());
	}
	
	@Test
	public void deleteOrder() {
		customerDao.deleteOrder("12345");
	}
	
	@Test
	public void insertCustomer() {
		GetAddress address = new GetAddress();
		address.setAddressId("肇庆学院明智书院");
		address.setCity("广东");
		address.setName("小李");
		
		customerDao.insertAddress(address, "123");
	}
	
	@Test
	public void findAddress() {
		List<Customer> list = null;
		
		try {
			list = customerDao.getAddresses("123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(list.size() != 0)
			System.out.println("the address is " + list.get(0).getAddress().get(0).getAddressId());
	}
	
	@Test
	public void insertAddress() {
		GetAddress address = new GetAddress();
		address.setAddressId("110");
		address.setName("小张");
		address.setCity("海珠区");
		customerDao.insertAddress(address, "123");
	}
	
	@Test
	public void deleteAddress() {
		customerDao.deleteAddress("110", "123");
	}
	
	@Test
	public void updateAddress() {
		GetAddress address = new GetAddress();
		address.setAddressId("110");
		address.setName("李国鹏");
		address.setCity("广东");
		
		customerDao.updateAddress(address, "123");
	}
}
