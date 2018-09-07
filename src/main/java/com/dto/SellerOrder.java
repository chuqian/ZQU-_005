package com.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenchuqian
 * @date 2018年9月6日 下午4:46:55
 * @describe 商家订单
 */
public class SellerOrder implements Serializable {
	private static final long serialVersionUID = 9143540159644209868L;
	
	private String orderId;  //订单id
	private String member;   //买家(会员名)
	private Double money;   //交易金额
	private Date dateTime;   //生成日期
	private Integer logisticsState;  //物流状态
	private AfterSale afterSale;   //售后服务
	private String wayBillNum;    //运单号码
	private String logistics;  //物流公司
	private Integer orderState; //交易状态
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public Integer getLogisticsState() {
		return logisticsState;
	}
	public void setLogisticsState(Integer logisticsState) {
		this.logisticsState = logisticsState;
	}
	public AfterSale getAfterSale() {
		return afterSale;
	}
	public void setAfterSale(AfterSale afterSale) {
		this.afterSale = afterSale;
	}
	public String getWayBillNum() {
		return wayBillNum;
	}
	public void setWayBillNum(String wayBillNum) {
		this.wayBillNum = wayBillNum;
	}
	public String getLogistics() {
		return logistics;
	}
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	
	@Override
	public String toString() {
		return "SellerOrder [orderId=" + orderId + ", member=" + member + ", money=" + money + ", dateTime=" + dateTime
				+ ", orderState=" + orderState + ", logisticsState=" + logisticsState + ", afterSale=" + afterSale
				+ ", wayBillNum=" + wayBillNum + ", logistics=" + logistics + "]";
	}
}
