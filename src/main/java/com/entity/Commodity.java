package com.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author chenchuqian
 * @date 2018年8月24日 下午11:31:45
 * @describe 商品类
 */
@Document(collection="commodity")
public class Commodity {
	private String id;       //商品id
	private String name;     //商品名称
	private Double price;    //商品价格
	private Integer saledNum; //销量
	private Integer score;   //综合评分
	private Integer stock;   //库存
	private String[] imSrc;  //图片
	private Integer shelf;   //是否上架
	
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
	public String[] getImSrc() {
		return imSrc;
	}
	public void setImSrc(String[] imSrc) {
		this.imSrc = imSrc;
	}
	public Integer getShelf() {
		return shelf;
	}
	public void setShelf(Integer shelf) {
		this.shelf = shelf;
	}
	
}
