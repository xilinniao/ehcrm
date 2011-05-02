package com.eh.shop.entity;



/**
 * TbPageCategory entity. @author MyEclipse Persistence Tools
 */

public class TbPageCategory  implements java.io.Serializable {


    // Fields    

     private Long categoryId;
     private TbSiteCategory siteCategory;
     private String categoryName;
     private Long goodsCnt;
     private Long showNum;
     private String adHtml;
     private Long orderNum;
     private Long categoryType;
     private Long isShow;


    // Constructors

    /** default constructor */
    public TbPageCategory() {
    }

    
    /** full constructor */
    public TbPageCategory(TbSiteCategory siteCategory, String categoryName, Long goodsCnt, Long showNum, String adHtml, Long orderNum, Long categoryType, Long isShow) {
        this.siteCategory = siteCategory;
        this.categoryName = categoryName;
        this.goodsCnt = goodsCnt;
        this.showNum = showNum;
        this.adHtml = adHtml;
        this.orderNum = orderNum;
        this.categoryType = categoryType;
        this.isShow = isShow;
    }

   
    // Property accessors

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public Long getShowNum() {
        return this.showNum;
    }
    
    public void setShowNum(Long showNum) {
        this.showNum = showNum;
    }

    public String getAdHtml() {
        return this.adHtml;
    }
    
    public void setAdHtml(String adHtml) {
        this.adHtml = adHtml;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Long getCategoryType() {
        return this.categoryType;
    }
    
    public void setCategoryType(Long categoryType) {
        this.categoryType = categoryType;
    }

    public Long getIsShow() {
        return this.isShow;
    }
    
    public void setIsShow(Long isShow) {
        this.isShow = isShow;
    }
   








}