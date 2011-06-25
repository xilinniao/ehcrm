package com.eh.base.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eh.base.entity.CodeName;

public class Constants {
	public final static String DATE_FORMAT = "yyyy-MM-dd";
	public static final String SPLIT_CHARS = "\\$\\$\\$";
	public static final String SESSION_NAME = "userinfo";
	/**
	 * 导入参数列表
	 */
	public static final Map<String,List<CodeName>> params = new HashMap<String,List<CodeName>>();
	public static final String pageSizeHtml = "<label>每页显示</label><select name=\"pageSize\" id=\"pageSize\" class=\"formSelectPageSize\"><option value=\"2\">2</option><option value=\"10\">10</option><option value=\"20\">20</option><option value=\"50\">50</option><option value=\"100\">100</option></select>";
	
	public static final String SESSION_NAME_FRONT = "frontcust";//前台用户登录名
	public static final String LOGIN_USERNAME_COOKIE_NAME_FRONT = "memberUsername";//前台登录用户cookie名称
	public static final String AUTO_LOGIN_COOKIE_NAME_FRONT = "autoLoginUUID";//自动登录前台处理
	
	public static String FILE_UPLOAD_PATH = "";
	
	public static String APP_PATH = "";
	
	public static String UPLOAD_IMAGE_DIR = "";// 图片文件上传目录
	public static String UPLOAD_MEDIA_DIR = "";// 媒体文件上传目录
	public static String UPLOAD_FILE_DIR = "";// 其它文件上传目录
	
	public static Long YES = Long.valueOf(1);
	public static Long NO = Long.valueOf(0);
	
	public static String YES_STR = "1";
	public static String NO_STR = "0";
	
	public static final String SHOP_ROLE = "SHOP_ROLE";
	public static final String SHOP_DEPT = "SHOP_DEPT";
	
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
	
	/**
	 * 订单状态 0、正常订单   1、客户主动取消  2、店铺取消订单 3、系统自动接收订单  4、店铺已接收  5、订单送货中  9、订单已完成
	 */
	public final static String ORDER_STATUS_NORMAL = "0";
	public final static String ORDER_STATUS_CANCEL_CUST = "1";
	public final static String ORDER_STATUS_CANCEL_SHOP = "2";
	public final static String ORDER_STATUS_SYS_AUTO = "3";
	public final static String ORDER_STATUS_SHOP_CHECK = "4";
	public final static String ORDER_STATUS_SHOP_SEND = "5";
	public final static String ORDER_STATUS_SHOP_FINISH = "9";
	
	public final static String ATTACHMENT_GOODS = "goods";//附件类型：商品附件
	
	public final static Long GOODS_ATTACHMENT_TYPE = Long.valueOf(1);// 商品附件类型（图片）
}
