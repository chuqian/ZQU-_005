package com.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.dto.Collect;
import com.dto.CustomerOrder;
import com.dto.GetAddress;
import com.dto.ShopCart;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午10:54:35
 * @describe 客户类
 */
@Component
@Document(collection="customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -5229851552703379780L;
	
	@Id
	private String id;        //买家id
	private String member;    //会员名(唯一)
	private String nickname;  //昵称
	private String username;  //姓名
	private Integer sex;      //性别
	private String phone;     //手机号
	private String email;     //邮箱
	private List<GetAddress> address;  //收货地址
	private List<ShopCart> shopCart;  //购物车
	private List<Collect> collects;  //收藏夹
	private List<CustomerOrder> orders; //订单列表
    private Integer state;    //状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<GetAddress> getAddress() {
		return address;
	}
	public void setAddress(List<GetAddress> address) {
		this.address = address;
	}
	public List<ShopCart> getShopCart() {
		return shopCart;
	}
	public void setShopCart(List<ShopCart> shopCart) {
		this.shopCart = shopCart;
	}
	public List<Collect> getCollects() {
		return collects;
	}
	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}
	public List<CustomerOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", member=" + member + ", nickname=" + nickname + ", username=" + username
				+ ", sex=" + sex + ", phone=" + phone + ", email=" + email + ", address=" + address + ", shopCart="
				+ shopCart + ", collects=" + collects + ", orders=" + orders + ", state=" + state + "]";
	}
}
