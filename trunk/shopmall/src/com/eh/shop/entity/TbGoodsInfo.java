package com.eh.shop.entity;

import java.util.Date;


/**
 * TbGoodsInfo entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsInfo  implements java.io.Serializable {


    // Fields    

     private Long goodsId;
     private TbShopInfo shopInfo;
     private TbGoodsCategory category;
     private TbSiteCategory siteCategory;
     private TbBrandInfo brandInfo;
     private TbPageCategory pageCategory;
     private String goodsName;
     private String keyWord;
     private String goodNo;
     private Double weight;
     private Double marketPrice;
     private Double discountPrice;
     private String goodsDesc;
     private Long leavesCount;
     private String imageUrl;
     private String jdUrl;
     private Long createUser;
     private Date createTime;


    // Constructors

    /** default constructor */
    public TbGoodsInfo() {
    }

    
    /** full constructor */
    public TbGoodsInfo(TbShopInfo shopInfo, TbGoodsCategory category, TbSiteCategory siteCategory, TbBrandInfo brandInfo, TbPageCategory pageCategory, String goodsName, String keyWord, String goodNo, Double weight, Double marketPrice, Double discountPrice, String goodsDesc, Long leavesCount, String imageUrl, String jdUrl, Long createUser, Date createTime) {
        this.shopInfo = shopInfo;
        this.category = category;
        this.siteCategory = siteCategory;
        this.brandInfo = brandInfo;
        this.pageCategory = pageCategory;
        this.goodsName = goodsName;
        this.keyWord = keyWord;
        this.goodNo = goodNo;
        this.weight = weight;
        this.marketPrice = marketPrice;
        this.discountPrice = discountPrice;
        this.goodsDesc = goodsDesc;
        this.leavesCount = leavesCount;
        this.imageUrl = imageUrl;
        this.jdUrl = jdUrl;
        this.createUser = createUser;
        this.createTime = createTime;
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

    public TbSiteCategory getSiteCategory() {
        return this.siteCategory;
    }
    
    public void setSiteCategory(TbSiteCategory siteCategory) {
        this.siteCategory = siteCategory;
    }

    public TbBrandInfo getBrandInfo() {
        return this.brandInfo;
    }
    
    public void setBrandInfo(TbBrandInfo brandInfo) {
        this.brandInfo = brandInfo;
    }

    public TbPageCategory getPageCategory() {
        return this.pageCategory;
    }
    
    public void setPageCategory(TbPageCategory pageCategory) {
        this.pageCategory = pageCategory;
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

    public Double getWeight() {
        return this.weight;
    }
    
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getMarketPrice() {
        return this.marketPrice;
    }
    
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
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

    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJdUrl() {
        return this.jdUrl;
    }
    
    public void setJdUrl(String jdUrl) {
        this.jdUrl = jdUrl;
    }

    public Long getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
   








}