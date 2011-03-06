package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class GoodsInfoQry extends BaseQuery {
	/**
	 * 分类ID
	 */
	private Long categoryId;
	/**
	 * 分类编码
	 */
	private String treeNo;
	/**
	 * 商品编码
	 */
	private String goodsNo;
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the goodsNo
	 */
	public String getGoodsNo() {
		return goodsNo;
	}
	/**
	 * @param goodsNo the goodsNo to set
	 */
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * @return the treeNo
	 */
	public String getTreeNo() {
		return treeNo;
	}
	/**
	 * @param treeNo the treeNo to set
	 */
	public void setTreeNo(String treeNo) {
		this.treeNo = treeNo;
	}
	
	
}
