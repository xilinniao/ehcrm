package com.eh.shop.entity;



/**
 * TbGoodsExtend entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsExtend  implements java.io.Serializable {


    // Fields    

     private Long goodsId;
     private TbGoodsInfo goods;
     private String goodsDesc;
     private String packList;


    // Constructors

    /** default constructor */
    public TbGoodsExtend() {
    }

    
    /** full constructor */
    public TbGoodsExtend(TbGoodsInfo goods, String goodsDesc, String packList) {
        this.goods = goods;
        this.goodsDesc = goodsDesc;
        this.packList = packList;
    }

   
    // Property accessors

    public Long getGoodsId() {
        return this.goodsId;
    }
    
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public TbGoodsInfo getGoods() {
        return this.goods;
    }
    
    public void setGoods(TbGoodsInfo goods) {
        this.goods = goods;
    }

    public String getGoodsDesc() {
        return this.goodsDesc;
    }
    
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getPackList() {
        return this.packList;
    }
    
    public void setPackList(String packList) {
        this.packList = packList;
    }
   








}