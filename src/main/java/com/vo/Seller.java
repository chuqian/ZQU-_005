package com.vo;

/**
 * @author chenchuqian
 * @date 2018年8月24日 下午11:32:31
 * @describe 商家类
 */
public class Seller {
	private String id;      //商家id
	private String name;    //商家姓名
	private String store;   //店铺名字
	private Address address; //发货地址
	private String type;    //店铺类型
	private Integer score;   //信用评分
	private String[] commoditys; //在卖商品
	private String phone;    //手机号码
	private String identity;  //省份证号
	private Integer sex;      //性别
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String[] getCommoditys() {
		return commoditys;
	}
	public void setCommoditys(String[] commoditys) {
		this.commoditys = commoditys;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
