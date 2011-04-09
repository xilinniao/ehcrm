package com.eh.shop.admin.web.qry;

import java.util.Date;

import com.eh.base.util.BaseQuery;

public class OrderQry extends BaseQuery {
	/**
	 * 订单号 
	 */
	String orderNo;
	/**
	 * 订单开始时间
	 */
	Date orderDateFrom;
	/**
	 * 订单结束时间
	 */
	Date orderDateTo;
	/**
	 * 订单状态
	 */
	Long orderStatus;
	/**
	 * 店铺ID
	 */
	Long shopId;
	/**
	 * 客户ID
	 */
	Long custId;
	
	
	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the orderDateFrom
	 */
	public Date getOrderDateFrom() {
		return orderDateFrom;
	}
	/**
	 * @param orderDateFrom the orderDateFrom to set
	 */
	public void setOrderDateFrom(Date orderDateFrom) {
		this.orderDateFrom = orderDateFrom;
	}
	/**
	 * @return the orderDateTo
	 */
	public Date getOrderDateTo() {
		return orderDateTo;
	}
	/**
	 * @param orderDateTo the orderDateTo to set
	 */
	public void setOrderDateTo(Date orderDateTo) {
		this.orderDateTo = orderDateTo;
	}
	/**
	 * @return the orderStatus
	 */
	public Long getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(Long orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the shopId
	 */
	public Long getShopId() {
		return shopId;
	}
	/**
	 * @param shopId the shopId to set
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**
	 * @return the custId
	 */
	public Long getCustId() {
		return custId;
	}
	/**
	 * @param custId the custId to set
	 */
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	
	
}
