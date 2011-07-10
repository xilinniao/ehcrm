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
     private int orderNum;


    // Constructors

    /** default constructor */
    public TbGoodsImages() {
    }

    
    /** full constructor */
    public TbGoodsImages(TbGoodsInfo goodsInfo, TbAttachment attachment, Long relType, int orderNum) {
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


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}










}