package com.laufu.util.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

	public static final String DATE_YYYYMMDD = "yyyy-MM-dd";
	public static final String DATE_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:SS";
	
	private static SimpleDateFormat dateFormat;
	
	/**
	 * 日期格式
	 * @param date
	 * @return
	 */
	public static String getString(Date date){
		dateFormat =  new SimpleDateFormat(DATE_YYYYMMDD);
		return dateFormat.format(date);
	}
	/**
	 * 时间日期格式
	 * @param date
	 * @return
	 */
	public static String getStringTime(Date date){
		dateFormat =  new SimpleDateFormat(DATE_YYYYMMDD_HHMMSS);
		return dateFormat.format(date);
	}
	
//	public static void main(String[] args) {
//		dateFormat =  new SimpleDateFormat(DATE_YYYYMMDD);
//		dateFormat.setDateFormatSymbols(DateFormatSymbols.getInstance());
//		System.out.println(dateFormat.format(new Date()));
//		System.out.println(DateFormatSymbols.getInstance().getLocalPatternChars());
//	}
}
