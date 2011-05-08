/**
 * 
 */
package com.eh.shop.front.cache;

import java.io.Serializable;

import com.eh.base.util.FormateUtil;

/**
 * 最精简的商品类
 * 
 * @author zhoucl
 * 
 */
public class GoodsShort implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8261299700560270229L;
	/**
	 * 商品ID,此字段为子商品ID
	 */
	Long goodsId;
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
	 * 图片URL 50*50
	 */
	String imageA;
	/**
	 * 图片URL 100*100
	 */
	String imageB;
	/**
	 * 图片URL 130*130
	 */
	String imageC;
	/**
	 * 图片URL 160*160
	 */
	String imageD;
	/**
	 * 图片URL 350*350
	 */
	String imageE;
	
	String imageF;
	/**
	 * 冗余属性，在CACHE中不会发生
	 */
	Long cnt;
	
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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getImageA() {
		return imageA;
	}

	public void setImageA(String imageA) {
		this.imageA = imageA;
	}

	public String getImageB() {
		return imageB;
	}

	public void setImageB(String imageB) {
		this.imageB = imageB;
	}

	public String getImageC() {
		return imageC;
	}

	public void setImageC(String imageC) {
		this.imageC = imageC;
	}

	public String getImageD() {
		return imageD;
	}

	public void setImageD(String imageD) {
		this.imageD = imageD;
	}

	public String getImageE() {
		return imageE;
	}

	public void setImageE(String imageE) {
		this.imageE = imageE;
	}
	
	public String getImageF() {
		return imageF;
	}

	public void setImageF(String imageF) {
		this.imageF = imageF;
	}
	
	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
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
