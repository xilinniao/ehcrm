package com.eh.shop.entity;

import com.eh.base.util.FormateUtil;

/**
 * TbOrderDetail entity. @author MyEclipse Persistence Tools
 */

public class TbOrderDetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2294405714296040162L;
	private Long detailId;
	private TbOrderMain order;
	private TbGoodsInfoSub goods;
	private String goodsName;
	private Double goodsPrice;
	private Long goodsCount;
	private Long goodsScore;

	// Constructors

	/** default constructor */
	public TbOrderDetail() {
	}

	// Property accessors

	public Long getDetailId() {
		return this.detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public TbOrderMain getOrder() {
		return this.order;
	}

	public void setOrder(TbOrderMain order) {
		this.order = order;
	}

	public TbGoodsInfoSub getGoods() {
		return goods;
	}

	public void setGoods(TbGoodsInfoSub goods) {
		this.goods = goods;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Long getGoodsCount() {
		return this.goodsCount;
	}

	public void setGoodsCount(Long goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Long getGoodsScore() {
		return this.goodsScore;
	}

	public void setGoodsScore(Long goodsScore) {
		this.goodsScore = goodsScore;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.goodsPrice);
	}
}