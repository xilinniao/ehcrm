package com.eh.shop.entity;



/**
 * TbGoodsCategoryRel entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsCategoryRel  implements java.io.Serializable {


    // Fields    

     private Long recId;
     private Long categoryId;
     private Long goodsId;
     private Long orderNum;
     
      


    // Constructors

    /** default constructor */
    public TbGoodsCategoryRel() {
    }

    
    /** full constructor */
    public TbGoodsCategoryRel(Long categoryId, Long goodsId, Long orderNum) {
        this.categoryId = categoryId;
        this.goodsId = goodsId;
        this.orderNum = orderNum;
    }

   
    // Property accessors

    public Long getRecId() {
        return this.recId;
    }
    
    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }
    
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
   








}