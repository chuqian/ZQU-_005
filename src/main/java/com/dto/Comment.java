package com.dto;

import java.util.Date;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:28:23
 * @describe 评论，关联到商品
 */
public class Comment {
	private String member;    //评论者(会员名)
	private String content;   //评论内容
	private Date contentTime; //评论日期
	private String answer;    //回复评论
	private Date answerTime;  //回复日期
	private Integer state;     //评论状态,是否屏蔽
	
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
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
	
}
