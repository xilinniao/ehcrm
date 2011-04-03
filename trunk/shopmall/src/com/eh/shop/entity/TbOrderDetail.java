package com.eh.shop.entity;



/**
 * TbOrderDetail entity. @author MyEclipse Persistence Tools
 */

public class TbOrderDetail  implements java.io.Serializable {


    // Fields    

     private Long detailId;
     private TbOrderMain order;
     private TbGoodsInfo goods;
     private Double goodsPrice;
     private Long goodsCount;
     private Long goodsScore;


    // Constructors

    /** default constructor */
    public TbOrderDetail() {
    }

    
    /** full constructor */
    public TbOrderDetail(TbOrderMain order, TbGoodsInfo goods, Double goodsPrice, Long goodsCount, Long goodsScore) {
        this.order = order;
        this.goods = goods;
        this.goodsPrice = goodsPrice;
        this.goodsCount = goodsCount;
        this.goodsScore = goodsScore;
    }

   
    // Property accessors

    public Long getDetailId() {
        return this.detailId;
    }
    
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public TbOrderMain getOrder() {
        return this.order;
    }
    
    public void setOrder(TbOrderMain order) {
        this.order = order;
    }

    public TbGoodsInfo getGoods() {
        return this.goods;
    }
    
    public void setGoods(TbGoodsInfo goods) {
        this.goods = goods;
    }

    public Double getGoodsPrice() {
        return this.goodsPrice;
    }
    
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Long getGoodsCount() {
        return this.goodsCount;
    }
    
    public void setGoodsCount(Long goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Long getGoodsScore() {
        return this.goodsScore;
    }
    
    public void setGoodsScore(Long goodsScore) {
        this.goodsScore = goodsScore;
    }
   








}