package com.dto;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:06:12
 * @describe 发货地址
 */
public class SendAddress {
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
	
	@Override
	public String toString() {
		return "SendAddress [province=" + province + ", city=" + city + ", county=" + county + ", detail=" + detail
				+ "]";
	}
}
