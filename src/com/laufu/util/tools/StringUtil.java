package com.laufu.util.tools;

import net.sf.json.JSONArray;

public class StringUtil {

	/**
	 * 处理文档提交的内容
	 * @param str
	 * @return
	 */
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("-", "&not;");
		str = str.replaceAll("'", "&apos;");
		return str;
	}
	
	/**
	 * Replace special character to Html code
	 * @param str
	 * @return
	 */
	public static String specialcharsToHtml(String str) {
		str = str.replaceAll( "&amp;","&");
		str = str.replaceAll( "&lt;","<");
		str = str.replaceAll("&gt;",">");
		str = str.replaceAll( "&quot;","\"");
		str = str.replaceAll( "&not;","-");
		str = str.replaceAll("&apos;","'");
		return str;
	}
	
	/**
	 * 返回一个JSON字符串
	 * @param o 需要转换的对象
	 * @return JSON字符串（标准格式）
	 */
	public static String getJsonObject(Object o){
		return JSONArray.fromObject(o).toString();
	}
	
	public static boolean isEmpty(String str) {
	       return str == null || str.length() == 0;
	}
}
