package com.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenchuqian
 * @date 2018年9月6日 下午4:55:25
 * @describe 售后服务
 */
public class AfterSale implements Serializable {
	
	private static final long serialVersionUID = -6835461890468011536L;
	
	private String returnId;  //售后编号
	private Date applytime;   //申请时间
	private Date dealtime;   //处理时间
	private Integer seviceType;   //服务类型
	private Integer returnState;  //售后状态
	private String reason;  //原因
	
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
	public Date getDealtime() {
		return dealtime;
	}
	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}
	public Integer getSeviceType() {
		return seviceType;
	}
	public void setSeviceType(Integer seviceType) {
		this.seviceType = seviceType;
	}
	public Integer getReturnState() {
		return returnState;
	}
	public void setReturnState(Integer returnState) {
		this.returnState = returnState;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "AfterSale [returnId=" + returnId + ", applytime=" + applytime + ", dealtime=" + dealtime
				+ ", seviceType=" + seviceType + ", returnState=" + returnState + ", reason=" + reason + "]";
	}
}
