package com.eh.shop.front.cache;

import java.io.Serializable;
import java.util.List;


/**
 * 商品详细信息
 * 
 * @author zhoucl
 * 
 */
public class GoodsDetail extends GoodsShort implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4687887357088971477L;
	/**
	 * 商品名称
	 */
	String name;
	/**
	 * 子商品信息
	 */
	List subGoods;
	/**
	 * 图像信息
	 */
	List imageList;
	
	private String goodsDesc;
	
	private Long leavesCount;
	/**
	 * 店铺ID
	 */
	private Long shopId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getSubGoods() {
		return subGoods;
	}

	public void setSubGoods(List subGoods) {
		this.subGoods = subGoods;
	}

	public List getImageList() {
		return imageList;
	}

	public void setImageList(List imageList) {
		this.imageList = imageList;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public Long getLeavesCount() {
		return leavesCount;
	}

	public void setLeavesCount(Long leavesCount) {
		this.leavesCount = leavesCount;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
}
