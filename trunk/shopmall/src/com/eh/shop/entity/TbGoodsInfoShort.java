package com.eh.shop.entity;



/**
 * TbGoodsInfoShort entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsInfoShort  implements java.io.Serializable {


    // Fields    

     private Long goodsId;
     private Long shopId;
     private Long categoryId;
     private Long brandId;
     private String goodsName;
     private Double originalPrice;
     private Double discountPrice;
     private Long leavesCount;
     private String imageUrl;
     private Long cnt;//数量


    // Constructors

    /** default constructor */
    public TbGoodsInfoShort() {
    }

    
    /** full constructor */
    public TbGoodsInfoShort(Long shopId, Long categoryId, Long brandId, String goodsName, Double originalPrice, Double discountPrice, Long leavesCount, String imageUrl) {
        this.shopId = shopId;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.goodsName = goodsName;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.leavesCount = leavesCount;
        this.imageUrl = imageUrl;
    }

   
    // Property accessors

    public Long getGoodsId() {
        return this.goodsId;
    }
    
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getShopId() {
        return this.shopId;
    }
    
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return this.brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getGoodsName() {
        return this.goodsName;
    }
    
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getOriginalPrice() {
        return this.originalPrice;
    }
    
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getDiscountPrice() {
        return this.discountPrice;
    }
    
    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Long getLeavesCount() {
        return this.leavesCount;
    }
    
    public void setLeavesCount(Long leavesCount) {
        this.leavesCount = leavesCount;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
}