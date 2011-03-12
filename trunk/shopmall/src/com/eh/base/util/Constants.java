package com.eh.base.util;

public class Constants {
	public final static String DATE_FORMAT = "yyyy-MM-dd";
	public static final String SPLIT_CHARS = "\\$\\$\\$";
	public static final String SESSION_NAME = "userinfo";	
	
	public static String FILE_UPLOAD_PATH = "";
	
	public static String UPLOAD_IMAGE_DIR = "";// 图片文件上传目录
	public static String UPLOAD_MEDIA_DIR = "";// 媒体文件上传目录
	public static String UPLOAD_FILE_DIR = "";// 其它文件上传目录
	
	public static Long YES = Long.valueOf(0);
	public static Long NO = Long.valueOf(1);
	
	public final static Long ADD_PK_ID = Long.valueOf(-99);
	/**
	 * 机构顶层节点ID
	 */
	public static Long ROOT_DEPT_ID = Long.valueOf(1);
	
	/**
	 * 数据查看权限--可查看所有数据
	 */
	public final static Long DATA_PRIV_ALL = Long.valueOf(51);
	/**
	 * 数据查看权限--查看本身和本机构以下数据
	 */
	public final static Long DATA_PRIV_SELF_AND_BLEW = Long.valueOf(52);
	/**
	 * 数据查看权限--只能查看本机构数据
	 */
	public final static Long DATA_PRIV_SELF = Long.valueOf(53);
}
