package com.eh.shop.entity;

import com.eh.base.entity.TbAttachment;


/**
 * TbGoodsAttach entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsImages  implements java.io.Serializable {


    // Fields    

     private Long recId;
     private TbGoodsInfo goodsInfo;
     private TbAttachment attachment;
     private Long relType;
     private Long orderNum;


    // Constructors

    /** default constructor */
    public TbGoodsImages() {
    }

    
    /** full constructor */
    public TbGoodsImages(TbGoodsInfo goodsInfo, TbAttachment attachment, Long relType, Long orderNum) {
        this.goodsInfo = goodsInfo;
        this.attachment = attachment;
        this.relType = relType;
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

    public TbAttachment getAttachment() {
        return this.attachment;
    }
    
    public void setAttachment(TbAttachment attachment) {
        this.attachment = attachment;
    }

    public Long getRelType() {
        return this.relType;
    }
    
    public void setRelType(Long relType) {
        this.relType = relType;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
   








}