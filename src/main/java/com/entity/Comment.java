package com.entity;

import java.util.Date;

/**
 * @author liangjiahong
 * @date 2018年8月26日上午12:51:56
 * @describe 评论类
 */
public class Comment {
	private String id;     //评论id
	private String text;   //评论内容
	private Date date;     //评论日期
	private String answer; //回复评论
	private String coustomerId;//评论的顾客Id
	private String commodityId;//商品Id
	private String state;  //评论状态，是否屏蔽
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCoustomerId() {
		return coustomerId;
	}
	public void setCoustomerId(String coustomerId) {
		this.coustomerId = coustomerId;
	}
	public String getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
