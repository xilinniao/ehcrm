package com.eh.base.entity;

import java.util.Date;

public class TbBaseParams implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6210373676442236977L;
	/**
	 * pk KEY编号
	 */
	private Long keyId;
	/**
	 * 参数编号
	 */
	private String keyCode;
	/**
	 * 参数名称
	 */
	private String keyName;
	/**
	 * 上级编号
	 */
	private TbBaseParams parent;
	/**
	 * 系统参数
	 */
	private Long isSystem;
	/**
	 * 参数状态
	 */
	private Long keyStatus;
	/**
	 * 排序号
	 */
	private Long orderNum;
	/**
	 * 
	 */
	private String treeNo;
	/**
	 * 
	 */
	private Long createUser;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Long updateUser;
	/**
	 * 
	 */
	private Date updateDate;

	public Long getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}

	public String getKeyCode() {
		return this.keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	/**
	 * @return the parent
	 */
	public TbBaseParams getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(TbBaseParams parent) {
		this.parent = parent;
	}

	public Long getIsSystem() {
		return this.isSystem;
	}

	public void setIsSystem(Long isSystem) {
		this.isSystem = isSystem;
	}

	public Long getKeyStatus() {
		return this.keyStatus;
	}

	public void setKeyStatus(Long keyStatus) {
		this.keyStatus = keyStatus;
	}

	public Long getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public String getTreeNo() {
		return this.treeNo;
	}

	public void setTreeNo(String treeNo) {
		this.treeNo = treeNo;
	}

	public Long getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}