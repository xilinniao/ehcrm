package com.eh.base.entity;

public class TbParamItem implements java.io.Serializable {
	/**
	 * pk 序列号
	 **/
	Long itemId;
	/**
	 * 类别编码
	 **/
	String kindCode;
	/**
	 * 指标编码
	 **/
	String itemCode;
	/**
	 * 指标名称
	 **/
	String itemName;
	/**
	 * 排序号
	 **/
	Long orderNum;
	/**
	 * 数据状态 0不可以用 1可用
	 **/
	Long dataStatus;

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getKindCode() {
		return this.kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Long getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(Long dataStatus) {
		this.dataStatus = dataStatus;
	}

}