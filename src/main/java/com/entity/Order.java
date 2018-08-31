package com.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午11:12:45
 * @describe 订单
 */
@Document(collection="order")
public class Order {
	@Id
	private String id;          //订单id
	private String customerId;  //买家id
	private List<Commodity> commoditys;  //订单商品
	private Date orderTime;     //订单生成日期
	private Integer state;      //状态
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<Commodity> getCommoditys() {
		return commoditys;
	}
	public void setCommoditys(List<Commodity> commoditys) {
		this.commoditys = commoditys;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", commoditys=" + commoditys + ", orderTime="
				+ orderTime + ", state=" + state + "]";
	}
}
