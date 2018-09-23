package com.enumm;

public enum StoreType {
	phone("phone", "手机"),
	cloth("cloth", "衣服"),
	food("food", "食品");
	
	private String value;
	private String desc;
	private StoreType(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public String getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}
