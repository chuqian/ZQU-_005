package com.util;

/**
 * @author liangjiahong
 * @date 2018年9月19日 下午4:15:16
 * @describe 条件查询的bean
 */
public class ConditionBeanUnit {
	private String key;
	private String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ConditionBeanUnit [key=" + key + ", value=" + value + "]";
	}
}
