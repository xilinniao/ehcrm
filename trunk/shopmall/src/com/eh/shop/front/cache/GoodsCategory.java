package com.eh.shop.front.cache;

import java.io.Serializable;

public class GoodsCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8195069840164120233L;
	
	private Long categoryId;
	private String categoryName;
	private String treeNo;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTreeNo() {
		return treeNo;
	}
	public void setTreeNo(String treeNo) {
		this.treeNo = treeNo;
	}
	
	public boolean isFirstLevel(){
		if(this.treeNo.length()==6){
			return true;
		}else{
			return false;
		}
	}
	
}
