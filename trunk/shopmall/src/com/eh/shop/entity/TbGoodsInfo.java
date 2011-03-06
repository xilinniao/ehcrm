package com.eh.shop.entity;



/**
 * TbGoodsInfo entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsInfo  implements java.io.Serializable {


    // Fields    

     private Long goodsId;
     private TbShopInfo shopInfo;
     private TbGoodsCategory category;
     private String goodsName;
     private String keyWord;
     private String goodNo;
     private Double originalPrice;
     private Double discountPrice;
     private String goodsDesc;
     private Long leavesCount;


    // Constructors

    /** default constructor */
    public TbGoodsInfo() {
    }

    
    /** full constructor */
    public TbGoodsInfo(TbShopInfo shopInfo, TbGoodsCategory category, String goodsName, String keyWord, String goodNo, Double originalPrice, Double discountPrice, String goodsDesc, Long leavesCount) {
        this.shopInfo = shopInfo;
        this.category = category;
        this.goodsName = goodsName;
        this.keyWord = keyWord;
        this.goodNo = goodNo;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.goodsDesc = goodsDesc;
        this.leavesCount = leavesCount;
    }

   
    // Property accessors

    public Long getGoodsId() {
        return this.goodsId;
    }
    
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public TbShopInfo getShopInfo() {
        return this.shopInfo;
    }
    
    public void setShopInfo(TbShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public TbGoodsCategory getCategory() {
        return this.category;
    }
    
    public void setCategory(TbGoodsCategory category) {
        this.category = category;
    }

    public String getGoodsName() {
        return this.goodsName;
    }
    
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getKeyWord() {
        return this.keyWord;
    }
    
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getGoodNo() {
        return this.goodNo;
    }
    
    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
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

    public String getGoodsDesc() {
        return this.goodsDesc;
    }
    
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Long getLeavesCount() {
        return this.leavesCount;
    }
    
    public void setLeavesCount(Long leavesCount) {
        this.leavesCount = leavesCount;
    }
   








}