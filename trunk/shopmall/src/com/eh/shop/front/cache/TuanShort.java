package com.eh.shop.front.cache;

import java.io.Serializable;

import com.eh.base.util.FormateUtil;

public class TuanShort implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1269543225224428571L;
	
	private Long tuanId;
	private String topicName;
	private Double price;
	private Double discountPrice;
	private String imageUrl;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getTuanId() {
		return tuanId;
	}

	public void setTuanId(Long tuanId) {
		this.tuanId = tuanId;
	}

	public String getPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.price);
	}

	public String getDiscountPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice);
	}
	/**
	 * 获取折扣信息
	 * @return
	 */
	public String getDiscountRate(){
		return FormateUtil.getInstance().formateDouble(this.discountPrice/this.price);
	}

}
