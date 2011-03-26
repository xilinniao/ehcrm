package com.eh.shop.front.vo;

import java.util.List;

public class GoodsCategoryVo {
	/**
	 * 类别
	 */
	String categoryName;
	/**
	 * 商品列表
	 */
	List goodsList;
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the goodsList
	 */
	public List getGoodsList() {
		return goodsList;
	}
	/**
	 * @param goodsList the goodsList to set
	 */
	public void setGoodsList(List goodsList) {
		this.goodsList = goodsList;
	}
	
}
