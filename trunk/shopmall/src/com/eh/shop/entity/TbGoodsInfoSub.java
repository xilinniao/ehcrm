package com.eh.shop.entity;



/**
 * TbGoodsInfoSub entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsInfoSub  implements java.io.Serializable {


    // Fields    

     private Long goodsSubId;
     private TbGoodsInfo goods;
     private String goodsSubName;
     private String goodsSubNo;
     private Double marketPrice;
     private Double discountPrice;
     private Long leavesCount;
     private Long dataStatus;


    // Constructors

    /** default constructor */
    public TbGoodsInfoSub() {
    }

    
    /** full constructor */
    public TbGoodsInfoSub(TbGoodsInfo goods, String goodsSubName, String goodsSubNo, Double marketPrice, Double discountPrice, Long leavesCount, Long dataStatus) {
        this.goods = goods;
        this.goodsSubName = goodsSubName;
        this.goodsSubNo = goodsSubNo;
        this.marketPrice = marketPrice;
        this.discountPrice = discountPrice;
        this.leavesCount = leavesCount;
        this.dataStatus = dataStatus;
    }

   
    // Property accessors

    public Long getGoodsSubId() {
        return this.goodsSubId;
    }
    
    public void setGoodsSubId(Long goodsSubId) {
        this.goodsSubId = goodsSubId;
    }

    public TbGoodsInfo getGoods() {
        return this.goods;
    }
    
    public void setGoods(TbGoodsInfo goods) {
        this.goods = goods;
    }

    public String getGoodsSubName() {
        return this.goodsSubName;
    }
    
    public void setGoodsSubName(String goodsSubName) {
        this.goodsSubName = goodsSubName;
    }

    public String getGoodsSubNo() {
        return this.goodsSubNo;
    }
    
    public void setGoodsSubNo(String goodsSubNo) {
        this.goodsSubNo = goodsSubNo;
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

    public Long getLeavesCount() {
        return this.leavesCount;
    }
    
    public void setLeavesCount(Long leavesCount) {
        this.leavesCount = leavesCount;
    }

    public Long getDataStatus() {
        return this.dataStatus;
    }
    
    public void setDataStatus(Long dataStatus) {
        this.dataStatus = dataStatus;
    }
   








}