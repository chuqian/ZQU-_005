package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
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
	 * String类型转Date类型
	 * @param adteTime
	 * @return
	 * @throws Exception 
	 */
	public static Date StringToDate(String adteTime) throws Exception {
	    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 分
	    Date utilDate = sdf.parse(adteTime);
		return utilDate;
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
