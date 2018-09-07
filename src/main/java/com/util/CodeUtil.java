package com.util;

import java.util.UUID;

/**
 * @ author : 李国鹏 
 * @ datetime : 18-8-24 上午10:52
 */
public class CodeUtil {

	/**
	 * @return : 一个四位数字的验证码
	 * @description ： 随机生成一个四位数字的验证码
	 */
	public static String generateUniqueCode(){
		return ((int)((Math.random()*10000))) + ""; 
	}
}
