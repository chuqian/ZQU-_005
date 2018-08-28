package com.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.dto.GetAddress;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午10:54:35
 * @describe 客户类
 */
@Document(collection="customer")
public class Customer {
	private String id;        //买家id
	private String member;    //会员名(唯一)
	private String nickname;  //昵称
	private String username;  //姓名
	private String phone;     //手机号
	private List<GetAddress> address;  //收货地址
	private Integer sex;      //性别
	private String email;     //邮箱
	private List<Commodity> shopCart;  //购物车
	private List<Commodity> collects;  //收藏夹
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<GetAddress> getAddress() {
		return address;
	}
	public void setAddress(List<GetAddress> address) {
		this.address = address;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Commodity> getShopCart() {
		return shopCart;
	}
	public void setShopCart(List<Commodity> shopCart) {
		this.shopCart = shopCart;
	}
	public List<Commodity> getCollects() {
		return collects;
	}
	public void setCollects(List<Commodity> collects) {
		this.collects = collects;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}