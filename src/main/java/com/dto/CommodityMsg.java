package com.dto;

import java.util.Date;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:21:01
 * @describe 订单商品信息,关联到订单中的某个商品
 */
public class CommodityMsg {
	private String commodityId;  //商品id
	private String commodityName; //商品名称
	private String imgScr;      //图片地址
	private String content;     //评论内容
	private Date contentTime;   //评论日期
	private String answer;      //回复评论
	private Date answerTime;    //回复日期
	private Integer state;      //评论状态
	
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
	
	@Override
	public String toString() {
		return "CommodityMsg [commodityId=" + commodityId + ", commodityName=" + commodityName + ", imgScr=" + imgScr
				+ ", content=" + content + ", contentTime=" + contentTime + ", answer=" + answer + ", answerTime="
				+ answerTime + ", state=" + state + "]";
	}
}
