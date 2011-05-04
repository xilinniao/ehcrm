/**
 * 
 */
package com.eh.shop.front.cache;

import com.eh.base.util.FormateUtil;

/**
 * 最精简的商品类
 * 
 * @author zhoucl
 * 
 */
public class GoodsShort {
	/**
	 * 商品ID
	 */
	Long goodId;
	/**
	 * 商品名称
	 */
	String name;
	/**
	 * 子商品名称
	 */
	String subName;
	/**
	 * 商品价格
	 */
	Double price;
	/**
	 * 这后价格
	 */
	Double discountPrice;	
	/**
	 * 团片URL
	 */
	String imageUrl;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getGoodId() {
		return goodId;
	}

	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * 全名
	 * @return
	 */
	public String getFullName(){
		return this.name+this.subName;
	}
	
	public String getPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.price);
	}

	public String getDiscountPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice);
	}
}
