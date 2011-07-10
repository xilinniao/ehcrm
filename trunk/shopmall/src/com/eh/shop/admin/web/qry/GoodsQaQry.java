package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class GoodsQaQry extends BaseQuery {
	/**
	 * 客户
	 */
	private Long custId;
	/**
	 * 店铺
	 */
	private Long shopId;
	/**
	 * 问题
	 */
	private String question;
	/**
	 * 商品
	 */
	private Long goodsId;
	
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
}