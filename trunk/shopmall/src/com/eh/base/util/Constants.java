package com.eh.base.util;

public class Constants {
	public final static String DATE_FORMAT = "yyyy-MM-dd";
	public static final String SPLIT_CHARS = "\\$\\$\\$";
	public static final String SESSION_NAME = "userinfo";	
	
	public static final String SESSION_NAME_FRONT = "frontcust";//前台用户登录名
	public static final String LOGIN_USERNAME_COOKIE_NAME_FRONT = "memberUsername";//前台登录用户cookie名称
	public static final String AUTO_LOGIN_COOKIE_NAME_FRONT = "autoLoginUUID";//自动登录前台处理
	
	public static String FILE_UPLOAD_PATH = "";
	
	public static String APP_PATH = "";
	
	public static String UPLOAD_IMAGE_DIR = "";// 图片文件上传目录
	public static String UPLOAD_MEDIA_DIR = "";// 媒体文件上传目录
	public static String UPLOAD_FILE_DIR = "";// 其它文件上传目录
	
	public static Long YES = Long.valueOf(0);
	public static Long NO = Long.valueOf(1);	
	/**
	 * MD5码前缀，为防止在线密码破解
	 */
	public final static String CRYPT_MD_PREFIX = "@F$5)6D!e7";
	
	// 水印位置（无、左上、右上、居中、左下、右下）
	public enum WatermarkPosition {
		no, topLeft, topRight, center, bottomLeft, bottomRight
	}
	
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
	
	/**
	 * 系统店铺
	 */
	public final static Long SYSTEM_SHOP = Long.valueOf(1);
	
	public final static Long ORDER_STATUS_CANCEL_CUST = Long.valueOf(0);//客户主动取消订单
	public final static Long ORDER_STATUS_CANCEL_SHOP = Long.valueOf(1);//店铺取消订单
	public final static Long ORDER_STATUS_CUST_INPUT = Long.valueOf(2);//已下单
	public final static Long ORDER_STATUS_SHOP_CHECK = Long.valueOf(3);//店铺已确认订单
	public final static Long ORDER_STATUS_SHOP_SEND = Long.valueOf(4);//店铺已送货
	public final static Long ORDER_STATUS_SHOP_FINISH = Long.valueOf(9);//订单已完成
	
	public final static String ATTACHMENT_GOODS = "goods";//附件类型：商品附件
	
	public final static Long GOODS_ATTACHMENT_TYPE = Long.valueOf(1);// 商品附件类型（图片）
}
