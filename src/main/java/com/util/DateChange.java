package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/**
 * @author liangjiahong
 * @date 2018年9月5日 上午9:14:25
 * @describe 日期类型转换
 */
public class DateChange {
	
	/**
	 * Date类型转String类型
	 * @param date
	 * @return
	 */
	public static String DateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String str = format.format(date);
		return str;
	}
	
	/**
	 * MongoDB日期的String类型转Date类型（主要用于测试）
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date IOSStringToDate(String strDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		formatter.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
		Date strtodate = formatter.parse(strDate);
		return strtodate;
	}
	
}
