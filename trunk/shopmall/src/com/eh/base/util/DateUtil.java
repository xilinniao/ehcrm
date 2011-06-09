/**
 * 
 */
package com.eh.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateUtil {
	public static final SimpleDateFormat DF_YYYY_MM_DD = new SimpleDateFormat(
			"yyyy-MM-dd");
	public static final SimpleDateFormat DF_YYYYMMDD = new SimpleDateFormat(
			"yyyyMMdd");
	public static final SimpleDateFormat DF_YYMMDD = new SimpleDateFormat(
	"yyMMdd");
	public static final SimpleDateFormat DF_YYYY_MM_DD_CHN = new SimpleDateFormat(
			"yyyy年MM月dd日");
	public static final SimpleDateFormat DF_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat DF_YYYY_MM_DD_HH_MM = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat DF_YYYY_MM = new SimpleDateFormat(
			"yyyy-MM");
	public static final SimpleDateFormat DF_YYYYMM = new SimpleDateFormat(
			"yyyyMM");
	public static final SimpleDateFormat DF_YYYY_MM_CHN = new SimpleDateFormat(
			"yyyy年MM月");
	public static final SimpleDateFormat DF_YYYYMMDDHHMM = new SimpleDateFormat(
	"yyyyMMddHH24mmss");
	
	

	private static DateUtil instance;

	public static DateUtil getInstance() {
		if (instance == null) {
			instance = new DateUtil();
		}
		return instance;
	}

	public String formateDate(Date date) {
		return this.formateDate(date, DF_YYYY_MM_DD);
	}

	/**
	 * 按指定的格式进行日期格式化
	 * 
	 * @param value
	 * @param formate
	 * @return
	 */
	public String formateDate(Date date, SimpleDateFormat formate) {
		if (date == null) {
			return "";
		} else {
			return formate.format(date);
		}
	}
	/**
	 * 将STRING转换成DATE
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public Date parseDate(String date) throws ParseException {
		if (StringUtils.isNotBlank(date)) {
			return DF_YYYY_MM_DD.parse(date);
		} else {
			return null;
		}
	}

	/**
	 * 日期
	 * 
	 * @param value
	 * @param amount
	 * @return
	 */
	public Date addDays(Date date, int amount) {
		if (date == null) {
			return null;
		} else {
			return DateUtils.addDays(date, amount);
		}
	}

	/**
	 * 加月
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public Date addMonths(Date date, int amount) {
		if (date == null) {
			return null;
		} else {
			return DateUtils.addMonths(date, amount);
		}
	}

	/**
	 * 转换java.util.date-->java.sql.date
	 * 
	 * @param d
	 * @return
	 */
	public java.sql.Date convertUtilDate(Date d) {
		return new java.sql.Date(d.getTime());
	}

	/**
	 * 比较两个日期大小
	 * 
	 * @param da
	 * @param db
	 * @return -1: da < db 0 : da = db 1 : da > db -9: 同时为空
	 */
	public int compareDate(Date da, Date db) {
		if (da == null && db == null) {
			return -9;
		} else if (da != null && db == null) {
			return 1;
		} else if (da == null && db != null) {
			return -1;
		} else {
			Calendar ca = Calendar.getInstance();
			ca.setTime(da);
			Calendar cb = Calendar.getInstance();
			cb.setTime(db);
			return compareDate(ca, cb);
		}
	}

	/**
	 * 
	 * @param ca
	 * @param cb
	 * @return
	 */
	private int compareDate(Calendar ca, Calendar cb) {
		if (ca.before(cb)) {
			return -1;
		} else if (ca.after(cb)) {
			return 1;
		} else if (ca.equals(cb)) {
			return 0;
		} else {
			// 不会发生，忽略
			return -9;
		}
	}
}