package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class ShopIndexCategoryQry extends BaseQuery {
	/**
	 * 分类名称
	 */
	String name;

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
