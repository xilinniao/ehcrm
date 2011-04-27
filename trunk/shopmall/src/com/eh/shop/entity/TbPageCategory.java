package com.eh.shop.entity;



/**
 * TbPageCategory entity. @author MyEclipse Persistence Tools
 */

public class TbPageCategory  implements java.io.Serializable {


    // Fields    

     private Long categoryId;
     private TbShopInfo shopInfo;
     private TbSiteCategory siteCategory;
     private String categoryName;
     private Long goodsCnt;
     private Long orderNum;


    // Constructors

    /** default constructor */
    public TbPageCategory() {
    }

    
    /** full constructor */
    public TbPageCategory(TbShopInfo shopInfo, TbSiteCategory siteCategory, String categoryName, Long goodsCnt, Long orderNum) {
        this.shopInfo = shopInfo;
        this.siteCategory = siteCategory;
        this.categoryName = categoryName;
        this.goodsCnt = goodsCnt;
        this.orderNum = orderNum;
    }

   
    // Property accessors

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public TbShopInfo getShopInfo() {
        return this.shopInfo;
    }
    
    public void setShopInfo(TbShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public TbSiteCategory getSiteCategory() {
        return this.siteCategory;
    }
    
    public void setSiteCategory(TbSiteCategory siteCategory) {
        this.siteCategory = siteCategory;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getGoodsCnt() {
        return this.goodsCnt;
    }
    
    public void setGoodsCnt(Long goodsCnt) {
        this.goodsCnt = goodsCnt;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
   








}