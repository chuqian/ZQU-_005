package com.vo;

/**
 * @author chenchuqian
 * @date 2018年8月24日 下午11:30:42
 * @describe 地址类
 */
public class Address {
	private String province;  //省份
	private String city;      //直辖市
	private String county;    //县/区
	private String detail;    //详细地址
	
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
}
