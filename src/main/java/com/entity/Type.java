package com.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author chenchuqian
 * @date 2018年9月6日 下午4:23:11
 * @describe 类型
 */
@Component
@Document(collection="type")
public class Type implements Serializable {

	private static final long serialVersionUID = -1141548881645144553L;

	@Id
	private String id;        //类型编号
	private String sellType;  //店铺售卖类型
	private List<String> commodityTypes;  //商品类型
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSellType() {
		return sellType;
	}
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}
	public List<String> getCommodityTypes() {
		return commodityTypes;
	}
	public void setCommodityTypes(List<String> commodityTypes) {
		this.commodityTypes = commodityTypes;
	}
	
	@Override
	public String toString() {
		return "Type [id=" + id + ", sellType=" + sellType + ", commodityTypes=" + commodityTypes + "]";
	}
}
