package com.enumm;

public enum ReturnState {
	success(1, "成功"),
	fail(0, "失败");
	
	private final int value;
	private final String desc;
	private ReturnState(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public int getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}
