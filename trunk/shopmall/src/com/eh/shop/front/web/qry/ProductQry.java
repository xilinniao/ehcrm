package com.eh.shop.front.web.qry;

import com.eh.base.util.BaseQuery;

public class ProductQry extends BaseQuery {
	Long categoryId;//分类
	String order;//排序
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
}
