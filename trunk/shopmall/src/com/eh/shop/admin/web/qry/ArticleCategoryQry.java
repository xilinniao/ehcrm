package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class ArticleCategoryQry extends BaseQuery {
	String categoryName;

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
}
