package com.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.dto.Commodity;
import com.dto.ContactAddress;
import com.dto.SellerOrder;
/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:07:23
 * @describe 商家
 */
@Component
@Document(collection="seller")
public class Seller implements Serializable {
	
	private static final long serialVersionUID = 4775191795545980995L;
	
	@Id
	private String id;      //商家id
	private String name;    //商家姓名
	private String store;   //店铺名字
	private String type;    //店铺类型
	private String phone;    //手机号码
	private String identity;  //身份证号
	private Integer sex;      //性别
	private String info;      //店铺简介
	private ContactAddress contactAddress; //联系地址
	private String storeImg;  //店铺标志
	private List<Commodity> commoditys; //店铺商品
	private List<SellerOrder> sellerOrders; //商家订单
	private Integer state;    //商家状态
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public ContactAddress getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(ContactAddress contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getStoreImg() {
		return storeImg;
	}
	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}
	public List<Commodity> getCommoditys() {
		return commoditys;
	}
	public void setCommoditys(List<Commodity> commoditys) {
		this.commoditys = commoditys;
	}
	public List<SellerOrder> getSellerOrders() {
		return sellerOrders;
	}
	public void setSellerOrders(List<SellerOrder> sellerOrders) {
		this.sellerOrders = sellerOrders;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", store=" + store + ", type=" + type + ", phone=" + phone
				+ ", identity=" + identity + ", sex=" + sex + ", info=" + info + ", contactAddress=" + contactAddress
				+ ", storeImg=" + storeImg + ", commoditys=" + commoditys + ", sellerOrders=" + sellerOrders
				+ ", state=" + state + "]";
	}
	
}