package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class BrandInfoQry extends BaseQuery {
	/**
	 * 品牌名称
	 */
	private String name;
	/**
	 * 店铺ID
	 */
	private Long shopId;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	
}
