package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.dto.AfterSale;
import com.dto.CommodityMsg;

/**
 * @author chenchuqian
 * @date 2018年9月6日 下午5:12:16
 * @describe 买家订单
 */
@Document(collection="customerOrder")
public class CustomerOrder implements Serializable {
	
	private static final long serialVersionUID = -7181252640880362298L;
	
	private String orderid;   //订单id
	private String customerId; //买家id 
	private List<CommodityMsg> commodityMsgs;	//订单商品 	
	private Date datetime;	//生成日期
	private Double freight;	//运费
	private Double price;	//交易金额
	private Integer orderState;	//交易状态
	private Integer logisticsState;		//物流状态
	private AfterSale afterSale; //售后服务
	private String wayBillNum;	//运单号码
	private String logistics;	//物流公司
	private Date sendTime;		//发货时间
	private Date achieveTime;	//签收时间
	private String sendAddress;	//发货地址
	private String sendName;   //发货人
	private String sendPost;   //发货邮编
	private String achieveAddress; //收货地址
	private String achieveName;  //收货人
	private String achievePost;  //收货邮编
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<CommodityMsg> getCommoditys() {
		return commodityMsgs;
	}
	public void setCommoditys(List<CommodityMsg> commodityMsgs) {
		this.commodityMsgs = commodityMsgs;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getAchieveTime() {
		return achieveTime;
	}
	public void setAchieveTime(Date achieveTime) {
		this.achieveTime = achieveTime;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getSendPost() {
		return sendPost;
	}
	public void setSendPost(String sendPost) {
		this.sendPost = sendPost;
	}
	public String getAchieveAddress() {
		return achieveAddress;
	}
	public void setAchieveAddress(String achieveAddress) {
		this.achieveAddress = achieveAddress;
	}
	public String getAchieveName() {
		return achieveName;
	}
	public void setAchieveName(String achieveName) {
		this.achieveName = achieveName;
	}
	public String getAchievePost() {
		return achievePost;
	}
	public void setAchievePost(String achievePost) {
		this.achievePost = achievePost;
	}
	
	@Override
	public String toString() {
		return "CustomerOrder [orderid=" + orderid + ", customerId=" + customerId + ", commodityMsgs=" + commodityMsgs
				+ ", datetime=" + datetime + ", freight=" + freight + ", price=" + price + ", orderState=" + orderState
				+ ", logisticsState=" + logisticsState + ", afterSale=" + afterSale + ", wayBillNum=" + wayBillNum
				+ ", logistics=" + logistics + ", sendTime=" + sendTime + ", achieveTime=" + achieveTime
				+ ", sendAddress=" + sendAddress + ", sendName=" + sendName + ", sendPost=" + sendPost
				+ ", achieveAddress=" + achieveAddress + ", achieveName=" + achieveName + ", achievePost=" + achievePost
				+ "]";
	}
}
