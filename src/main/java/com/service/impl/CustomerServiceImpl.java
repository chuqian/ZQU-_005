package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CustomerDao;
import com.dao.UserDao;
import com.dto.GetAddress;
import com.entity.Collect;
import com.entity.CommentMsg;
import com.entity.Customer;
import com.entity.CustomerOrder;
import com.entity.ShopCart;
import com.entity.User;
import com.service.CustomerService;
import com.util.MD5;

/**
 *@author : 李国鹏
 *@datetime : Sep 6, 2018 4:57:12 PM
 *@descriptioin :  买家 CustomerService 实现类
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private CustomerDao customerDao;
	
	
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	@Override
	public String getReturnView(String function) {
		if(function.equals("personalInfo"))
			return "/person/information";
		else if(function.equals("personalSafe"))
			return "/person/safety";
		else if(function.equals("personalAddress"))
			return "/person/address";
		else if(function.equals("personalOrder"))
			return "/person/order";
		else if(function.equals("personalChange"))
			return "/person/change";
		else if(function.equals("personalBill"))
			return "/person/billlist";
		else if(function.equals("personalCollection"))
			return "/person/collection";
		else if(function.equals("personalComment"))
			return "/person/comment";
		else if(function.equals("personalNews"))
			return "/person/news";
		else if(function.equals("personalPassword"))
			return "/person/password";
		else if(function.equals("personalSetpay"))
			return "/person/setpay";
		else if(function.equals("personalBindphone"))
			return "/person/bindphone";
		else if(function.equals("personalEmail"))
			return "/person/email";
		else if(function.equals("personalIdcard"))
			return "/person/idcard";
		
		return "";
	}

	@Override
	public boolean validatePassword(HttpServletRequest request, String password) {
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		String uuid = customer.getId();
		User user = userDao.findById(uuid);
		
		if(MD5.encode(password, uuid).equals(user.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCustomer(String userName, String nickName, String customerId) {
		if(customerDao.findByNickName(nickName) != null)
			return false;
		else 
			customerDao.updateCustomer(userName, nickName, customerId);
		
		return true;
	}
	
	@Override
	public void alterCustomer(String field, String customerId, String alterType) {
		if(alterType.equals("email"))
			customerDao.alterEmail(field, customerId);
		else if(alterType.equals("phone"))
			customerDao.alterPhone(field, customerId);
		else 
			userDao.updatePassword(customerId, MD5.encode(field, customerId));
	}
	
	@Override
	public void updateCart(int count, double amount, String commodityId, String customerId) {
		customerDao.updateCart(count, amount, commodityId, customerId);
	}
	
	@Override
	public void insertCart(ShopCart shopCart, String customerId, String commodityId) {
		if(customerDao.isExistCart(customerId, commodityId) != null) 
			customerDao.updateCart(shopCart.getCount(), shopCart.getAmount(), commodityId, customerId);
		else	
			customerDao.insertCart(shopCart);
	}
	
	@Override
	public List<ShopCart> findAllCart(String customerId, String filed, String lastId, int recordCount, int findType) {
		return customerDao.findAllCart(customerId, lastId, recordCount, findType);
	}
	
	@Override
	public List<ShopCart> findCartByFuzzy(String customerId, String filed, String value, String lastId, int recordCount, int findType) {
		return customerDao.findCartByFuzzy(customerId, value, lastId, recordCount, findType);
	}
	
	@Override
	public void deleteCart(String customerId, String commodityId) {
		customerDao.deleteCart(customerId, commodityId);
	}
	
	@Override
	public void insertOrder(CustomerOrder order) {
		customerDao.insertOrder(order);
	}
	
	@Override
	public CustomerOrder findOneOrder(String orderId) {
		return customerDao.findOneOrder(orderId);
	}

	@Override
	public List<CustomerOrder> findAllOrder(String customerId, String idFiled, String firstId, String sortFiled, int recordCount, int findType) {
		if(firstId == null)
			firstId = "\0";
		
		return customerDao.findAllOrder(customerId, idFiled, firstId, sortFiled, recordCount, findType);
	}
	
	@Override
	public List<CustomerOrder> findOrderByFuzzy(String customerId, String filed, String value, String lastId, int recordCount, int findType) {
		return customerDao.findOrderByFuzzy(customerId, value, lastId, recordCount, findType);
	}
	
	@Override
	public void deleteOrder(String orderId) {
		customerDao.deleteOrder(orderId);
	}
	
	@Override
	public void updateOrder(String orderId) {
		Date dealTime = new Date();
		customerDao.updateOrder(dealTime, orderId);
	}
	
	@Override
	public List<GetAddress> getAddresses(String customerId) {
		List<Customer> list = null;
		list = customerDao.getAddresses(customerId);
		
		if(list.size() != 0)
			return list.get(0).getAddress();
		
		return null;
	}
	
	@Override
	public void insertAddress(GetAddress address, String customerId) {
		address.setAddressId(UUID.randomUUID().toString());
		address.setIsDefault(0);
		address.setPostalNumber("00000");
		System.out.println("insertAddress the customerId is " + customerId );
		customerDao.insertAddress(address, customerId);
	}
	
	@Override
	public void deleteAddress(String addressId, String customerId) {
		customerDao.deleteAddress(addressId, customerId);
	}
	
	@Override
	public void updateAddress(GetAddress address, String customerId) {
		customerDao.updateAddress(address, customerId);
	}
	
	@Override
	public void insertCollection(Collect collection, String customerId, String filed, String commodityId) {
		if(customerDao.isExistCollection(customerId, commodityId) == null)
			customerDao.insertCollection(collection);
	}
	
	@Override
	public void deleteCollection(String customerId, String commodityId) {
		customerDao.deleteCollection(customerId, commodityId);
	}
	
	@Override
	public List<Collect> findCollection(String customerId, String filed, String lastId, int recordCount, int findType) {
		return customerDao.findCollection(customerId, lastId, recordCount, findType);
	}
	
	@Override
	public List<CustomerOrder> getAfterSale(String customerId, String filed, String lastId, int recordCount, int findType) {
		return customerDao.getAfterSale(customerId, lastId, recordCount, findType);
	}
	
	@Override
	public void insertCommentMsg(CommentMsg commentMsg) {
		customerDao.insertCommentMsg(commentMsg);
	}
	
	@Override
	public void deleteCommentMsg(String orderId) {
		customerDao.deleteCommentMsg(orderId);
	}
	
	@Override
	public List<CommentMsg> findCommentMsg(String customerId, String filed, String lastId, int recordCount, int findType) {
		return customerDao.findCommentMsg(customerId,"", lastId, recordCount, findType);
	}
}
