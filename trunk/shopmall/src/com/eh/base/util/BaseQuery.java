package com.eh.base.util;

import java.io.IOException;

import com.eh.base.vo.UserInfo;
/**
 * 
 * @author jcrm
 *
 */
public class BaseQuery {
	/**
	 * dataStart是否设置
	 */
	private boolean bDataStart = false;
	/**
	 * SESSION 对象
	 */
	private UserInfo userInfo;
	/**
	 * 页码
	 */
	private int pageNo = 1;
	/**
	 * 页大小
	 */
	private int pageSize = 20;
	/**
	 * 记录
	 */
	private int dataStart = 0;

	public int getPageNo() {		
		return pageNo;
	}
	
	/**
	 * 获取datatables的PageNo
	 * @return
	 */
	public int getDataTablesPageNo(){
		return this.dataStart/this.pageSize+1;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;		
	}	

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public int getDataStart() {
		return dataStart;
	}

	public void setDataStart(int dataStart) {
		this.dataStart = dataStart;
	}	

	/**
	 * 获取查询对象16进制值
	 * 
	 * @return
	 */
	public String getQryHex() {
		try {
			this.setUserInfo(null);
			// 只序列化String long Date 类型
			byte b[] = ObjectUtil.saveToXML(this);
			StringBuffer sb = new StringBuffer();
			sb = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				String s = Integer.toHexString(b[i]);
				if (s.length() < 2)
					sb.append("0");
				else if (s.length() > 2)
					s = s.substring(s.length() - 2);
				sb.append(s);
			}

			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 获取查询对象
	 * @param <T>
	 * @param qryClass
	 * @param qryHex
	 * @return
	 * @throws IOException
	 */
	public <T> T getQryFromHex(Class<T> qryClass,String qryHex) throws IOException{
		int pageNoSwap = this.pageNo;
		int pageSizeSwap = this.pageSize;
		BaseQuery qry = (BaseQuery)ObjectUtil.getObjectFromPara(qryHex);
		qry.setPageNo(pageNoSwap);
		qry.setPageSize(pageSizeSwap);
		return (T)qry;
	}
}
