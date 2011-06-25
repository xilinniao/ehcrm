/**
 * 
 */
package com.eh.base.entity;

/**
 * 编号和名称
 */
public class CodeName {
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CodeName(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
