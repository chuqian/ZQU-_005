package com.common;

public class SystemConst {

	public enum StoreType{
		phone("1", "手机"),
		oldBook("2", "二手书"),
		snacks("3", "零食"),
		food("4", "食品"),
		clothing("5", "服装");
		
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
}
