package com.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:21:01
 * @describe 评论信息
 */
@Document(collection="commentMsg")
public class CommentMsg implements Serializable {

	private static final long serialVersionUID = 1890475226288859219L;
	
	private String customerId;  //买家id
	private String orderId;    //订单id
	private String commodityId;  //商品id
	private String commodityName; //商品名称
	private String imgScr;      //图片地址
	private Double price;       //商品价格
	private Integer number;     //商品数量
	private String content;     //评论内容
	private Date contentTime;   //评论日期
	private String answer;      //回复评论
	private Date answerTime;    //回复日期
	private Integer state;      //评论状态
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getContentTime() {
		return contentTime;
	}
	public void setContentTime(Date contentTime) {
		this.contentTime = contentTime;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "CommodityMsg [customerId=" + customerId + "orderId=" + orderId + ", commodityId=" + commodityId + ", commodityName="
				+ commodityName + ", imgScr=" + imgScr + ", price=" + price + ", number=" + number + ", content="
				+ content + ", contentTime=" + contentTime + ", answer=" + answer + ", answerTime=" + answerTime
				+ ", state=" + state + "]";
	}
}
