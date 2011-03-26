package com.eh.shop.entity;



/**
 * TbPageGoodsRel entity. @author MyEclipse Persistence Tools
 */

public class TbPageGoodsRel  implements java.io.Serializable {


    // Fields    

     private Long recId;
     private TbGoodsInfo goodsInfo;
     private TbPageCategory pageCategory;
     private Long orderNum;


    // Constructors

    /** default constructor */
    public TbPageGoodsRel() {
    }

    
    /** full constructor */
    public TbPageGoodsRel(TbGoodsInfo goodsInfo, TbPageCategory pageCategory, Long orderNum) {
        this.goodsInfo = goodsInfo;
        this.pageCategory = pageCategory;
        this.orderNum = orderNum;
    }

   
    // Property accessors

    public Long getRecId() {
        return this.recId;
    }
    
    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public TbGoodsInfo getGoodsInfo() {
        return this.goodsInfo;
    }
    
    public void setGoodsInfo(TbGoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public TbPageCategory getPageCategory() {
        return this.pageCategory;
    }
    
    public void setPageCategory(TbPageCategory pageCategory) {
        this.pageCategory = pageCategory;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
   








}