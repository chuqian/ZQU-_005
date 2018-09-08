package com.util;
/**
 * @ author : 李国鹏 
 * @ datetime : 18-8-24 上午10:52
 * @ description : 生成四位随机数字验证码
 */
public class CodeUtil {
	/**
	 * @return : 一个四位数字的验证码
	 * @description ： 随机生成一个四位数字的验证码
	 */
	public static final String generateUniqueCode(){
		return ((int)((Math.random()*10000))) + ""; 
	}
}
