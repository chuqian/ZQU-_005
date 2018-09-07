package com.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author chenchuqian
 * @date 2018年9月6日 下午4:28:03
 * @describe 平台商品
 */
@Component
@Document(collection="allCommodity")
public class AllCommodity implements Serializable {

	private static final long serialVersionUID = 7617597863933889758L;
	
	@Id
	private String id;           //商品id
	private String sellerId;     //商家id
	private String commodityName;  //商品名称
	private Double price;        //商品价格
	private Integer saledNum;    //销量
	private String imgSrc;		 //图片
	private String commodityType; //商品类型
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSaledNum() {
		return saledNum;
	}
	public void setSaledNum(Integer saledNum) {
		this.saledNum = saledNum;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getCommodityType() {
		return commodityType;
	}
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}
	
	@Override
	public String toString() {
		return "AllCommodity [id=" + id + ", sellerId=" + sellerId + ", commodityName=" + commodityName + ", price="
				+ price + ", saledNum=" + saledNum + ", imgSrc=" + imgSrc + ", commodityType=" + commodityType + "]";
	}
}
