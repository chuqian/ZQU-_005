package com.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author liangjiahong
 * @date 2018年9月21日 上午11:24:58
 * @describe （买家）订单商品信息
 */
@Document(collection="commodityMsg")
public class CommodityMsg implements Serializable {

	private static final long serialVersionUID = 1890475226288859219L;
	
	private String commodityId;  //商品id
	private String commodityName; //商品名称
	private String imgScr;      //图片地址
	private Double price;       //商品价格
	private Integer number;     //商品数量

	public String getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getImgScr() {
		return imgScr;
	}
	public void setImgScr(String imgScr) {
		this.imgScr = imgScr;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CommodityMsg [" + "commodityId=" + commodityId + ", commodityName="
				+ commodityName + ", imgScr=" + imgScr + ", price=" + price + ", number=" + number + ", content="
				+ "]";
	}
}
