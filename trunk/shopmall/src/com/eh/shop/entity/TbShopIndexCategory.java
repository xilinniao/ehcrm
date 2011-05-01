package com.eh.shop.entity;



/**
 * TbShopIndexCategory entity. @author MyEclipse Persistence Tools
 */

public class TbShopIndexCategory  implements java.io.Serializable {


    // Fields    

     private Long categoryId;
     private TbShopInfo shopInfo;
     private String categoryName;
     private Long goodsCnt;
     private Long orderNum;
     private Long showNum;
     private Long isShow;


    // Constructors

    /** default constructor */
    public TbShopIndexCategory() {
    }

    
    /** full constructor */
    public TbShopIndexCategory(TbShopInfo shopInfo, String categoryName, Long goodsCnt, Long orderNum, Long showNum, Long isShow) {
        this.shopInfo = shopInfo;
        this.categoryName = categoryName;
        this.goodsCnt = goodsCnt;
        this.orderNum = orderNum;
        this.showNum = showNum;
        this.isShow = isShow;
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

    public Long getShowNum() {
        return this.showNum;
    }
    
    public void setShowNum(Long showNum) {
        this.showNum = showNum;
    }

    public Long getIsShow() {
        return this.isShow;
    }
    
    public void setIsShow(Long isShow) {
        this.isShow = isShow;
    }
   








}