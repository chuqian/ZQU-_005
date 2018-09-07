package com.dto;

/**
 * @author chenchuqian
 * @date 2018年9月6日 上午10:17:02
 * @describe 联系地址
 */
public class ContactAddress {
	private String province;    //省份
	private String city;        //直辖市
	private String county;      //县/区
	private String  detail;	    //详细地址
	private String  postalNumber;  //邮政编号
	
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
}
