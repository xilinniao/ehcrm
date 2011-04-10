package com.eh.shop.entity;



/**
 * TbPageCategory entity. @author MyEclipse Persistence Tools
 */

public class TbPageCategory  implements java.io.Serializable {


    // Fields    

     private Long categoryId;
     private TbShopInfo shopInfo;
     private TbGoodsCategory pageType;
     private String categoryName;
     private Long goodsCnt;
     private Long orderNum;


    // Constructors

    /** default constructor */
    public TbPageCategory() {
    }

    
    /** full constructor */
    public TbPageCategory(TbShopInfo shopInfo, TbGoodsCategory pageType, String categoryName, Long goodsCnt, Long orderNum) {
        this.shopInfo = shopInfo;
        this.pageType = pageType;
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

    public TbGoodsCategory getPageType() {
        return this.pageType;
    }
    
    public void setPageType(TbGoodsCategory pageType) {
        this.pageType = pageType;
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