package com.dto;

import java.io.Serializable;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:02:37
 * @describe 收货地址
 */
public class GetAddress implements Serializable {
	
	private static final long serialVersionUID = 7732988267615774295L;
	
	private String addressId; //地址Id
	private Integer isDefault;//是否默认
	private String name;      //收货人姓名
	private String phone;     //收货人手机号
	private String province;  //省份
	private String city;      //直辖市
	private String county;    //县/区
	private String detail;    //详细地址
	private String postalNumber; //邮政编码
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPostalNumber() {
		return postalNumber;
	}
	public void setPostalNumber(String postalNumber) {
		this.postalNumber = postalNumber;
	}
	
	@Override
	public String toString() {
		return "GetAddress [addressId=" + addressId + ", isDefault=" + isDefault + ", name=" + name + ", phone=" + phone
				+ ", province=" + province + ", city=" + city + ", county=" + county + ", detail=" + detail
				+ ", postalNumber=" + postalNumber + "]";
	}
}
