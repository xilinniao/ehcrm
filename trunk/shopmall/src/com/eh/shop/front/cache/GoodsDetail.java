package com.eh.shop.front.cache;

import java.util.List;

import com.eh.base.util.FormateUtil;

/**
 * 商品详细信息
 * 
 * @author zhoucl
 * 
 */
public class GoodsDetail extends GoodsShort {
	/**
	 * 商品名称
	 */
	String name;
	/**
	 * 商品价格
	 */
	Double price;
	/**
	 * 这后价格
	 */
	Double discountPrice;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.price);
	}

	public String getDiscountPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice);
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
}
