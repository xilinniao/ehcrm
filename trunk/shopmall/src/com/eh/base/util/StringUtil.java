package com.eh.base.util;

import org.apache.commons.lang.StringUtils;

/**
 * 用于SQL
 * @author zhoucl
 *
 */
public class StringUtil {
	public static String getLeftLike(String value){
		StringBuffer buf = new StringBuffer("%");
		buf.append(value);
		return buf.toString();
	}
	
	public static String getRightLike(String value){
		StringBuffer buf = new StringBuffer(value);
		buf.append("%");
		return buf.toString();
	}
	
	public static String getFullLike(String value){
		StringBuffer buf = new StringBuffer("%");
		buf.append(value);
		buf.append("%");
		return buf.toString();
	}
	
	public static String nullToEmpty(String value){	
		return value==null?"":value;
	}
}
