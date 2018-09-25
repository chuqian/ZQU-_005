package com.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author chenchuqian
 * @date 2018年8月24日 下午11:31:45
 * @describe 商品类
 */
public class Commodity implements Serializable {

	private static final long serialVersionUID = 798355473319608062L;
	
	private String id;       //商品id
	private String name;     //商品名称
	private Double price;    //商品价格
	private Integer saledNum; //销量
	private Integer score;   //综合评分
	private Integer stock;   //库存
	private String[] imgSrc;  //图片
	private Integer isShelf; //是否上架
	private Date shelfTime;  //上架时间
	private Integer formwork;   //运费
	private String commodityType;  //商品类型
	private Integer collectedNum;    //收藏数量
	private List<Comment> comments;  //商品有关评论
	private String description; //商品描述
	@JSONField(name="_id")
	public String getId() {
		return id;
	}
	@JSONField(name="_id")
	public void setId(String id) {
		this.id = id;
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
	public Integer getSaledNum() {
		return saledNum;
	}
	public void setSaledNum(Integer saledNum) {
		this.saledNum = saledNum;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String[] getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String[] imgSrc) {
		this.imgSrc = imgSrc;
	}
	public Integer getIsShelf() {
		return isShelf;
	}
	public void setIsShelf(Integer isShelf) {
		this.isShelf = isShelf;
	}
	public Date getShelfTime() {
		return shelfTime;
	}
	public void setShelfTime(Date shelfTime) {
		this.shelfTime = shelfTime;
	}
	public Integer getCollectedNum() {
		return collectedNum;
	}
	public void setCollectedNum(Integer collectedNum) {
		this.collectedNum = collectedNum;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Integer getFormwork() {
		return formwork;
	}
	public void setFormwork(Integer formwork) {
		this.formwork = formwork;
	}
	public String getCommodityType() {
		return commodityType;
	}
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", price=" + price + ", saledNum=" + saledNum + ", score="
				+ score + ", stock=" + stock + ", imgSrc=" + Arrays.toString(imgSrc) + ", isShelf=" + isShelf
				+ ", shelfTime=" + shelfTime + ", formwork=" + formwork + ", commodityType=" + commodityType
				+ ", collectedNum=" + collectedNum + ", comments=" + comments + ", description=" + description + "]";
	}
	
}
