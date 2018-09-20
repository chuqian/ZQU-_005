package com.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午5:10:34
 * @describe 收藏夹
 */
@Document(collection="collect")
public class Collect implements Serializable {
	private static final long serialVersionUID = 1591853709545597979L;
	
	private String customerId;  //买家id
	private String commodityId; //商品id
	private String name;       //商品名称
	private Double price;      //商品价格
	private String imgScr;     //图片地址
	private Date datetime;     //添加时间
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImgScr() {
		return imgScr;
	}
	public void setImgScr(String imgScr) {
		this.imgScr = imgScr;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Collect [customerId=" + customerId + ", commodityId=" + commodityId + ", name=" + name + ", price="
				+ price + ", imgScr=" + imgScr + ", datetime=" + datetime + "]";
	}
}
