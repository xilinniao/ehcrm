package com.eh.base.entity;

public class TbParamKind implements java.io.Serializable {
	/**
	 * pk 分类编号
	 **/
	String kindCode;
	/**
	 * 分类名称
	 **/
	String kindName;
	/**
	 * 分类描述
	 **/
	String kindDesc;

	public String getKindCode() {
		return this.kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getKindName() {
		return this.kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getKindDesc() {
		return this.kindDesc;
	}

	public void setKindDesc(String kindDesc) {
		this.kindDesc = kindDesc;
	}

}