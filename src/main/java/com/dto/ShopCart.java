package com.dto;

import java.util.Date;

/**
 * @author chenchuqian
 * @date 2018年8月28日 下午10:50:44
 * @describe 购物车
 */
public class ShopCart {
	private String commodityId; //商品id
	private String name;   //商品名称
	private Integer count; //数量
	private String imgScr; //图片地址
	private Date addTime;  //添加时间
	
	public String getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getImgScr() {
		return imgScr;
	}
	public void setImgScr(String imgScr) {
		this.imgScr = imgScr;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	@Override
	public String toString() {
		return "ShopCart [commodityId=" + commodityId + ", name=" + name + ", count=" + count + ", imgScr=" + imgScr
				+ ", addTime=" + addTime + "]";
	}
}
