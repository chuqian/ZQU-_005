package com.entity;

/**
 * @author chenchuqian
 * @date 2018年9月6日 上午10:11:02
 * @describe 入驻物流公司
 */
public class LogisticsCompany {
	private String id;          //公司编号
	private String companyName; //公司名称
	private String phone;      //公司联系电话
	private String address;    //公司地址
	private String startTime;  //合作起始时间
	private Integer cooperationTime;  //合作时长(年)
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getCooperationTime() {
		return cooperationTime;
	}
	public void setCooperationTime(Integer cooperationTime) {
		this.cooperationTime = cooperationTime;
	}
	
}
