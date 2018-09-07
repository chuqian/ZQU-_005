package com.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	private String[] imSrc;  //图片
	private Integer isShelf; //是否上架
	private Date shelfTime;  //上架时间
	private Integer collectedNum;    //收藏数量
	private List<Comment> comments;  //商品有关评论
	
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
	
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", price=" + price + ", saledNum=" + saledNum + ", score="
				+ score + ", stock=" + stock + ", imSrc=" + Arrays.toString(imSrc) + ", isShelf=" + isShelf
				+ ", shelfTime=" + shelfTime + ", collectedNum=" + collectedNum + ", comments=" + comments + "]";
	}
}
