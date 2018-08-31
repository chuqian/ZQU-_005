package com.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dto.SendAddress;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:07:23
 * @describe 商家
 */
@Document(collection="seller")
public class Seller {
	@Id
	private String id;      //商家id
	private String name;    //商家姓名
	private String store;   //店铺名字
	private String type;    //店铺类型
	private String phone;    //手机号码
	private String identity;  //身份证号
	private Integer sex;      //性别
	private SendAddress sendAddress;    //发货地址
	private Integer score;   //信用评分
	private List<Commodity> commoditys; //在卖商品
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
	public SendAddress getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(SendAddress sendAddress) {
		this.sendAddress = sendAddress;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public List<Commodity> getCommoditys() {
		return commoditys;
	}
	public void setCommoditys(List<Commodity> commoditys) {
		this.commoditys = commoditys;
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
				+ ", identity=" + identity + ", sex=" + sex + ", sendAddress=" + sendAddress + ", score=" + score
				+ ", commoditys=" + commoditys + ", state=" + state + "]";
	}
}
