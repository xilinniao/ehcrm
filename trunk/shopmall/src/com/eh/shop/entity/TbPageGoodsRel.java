package com.eh.shop.entity;

import java.util.Date;


/**
 * TbPageGoodsRel entity. @author MyEclipse Persistence Tools
 */

public class TbPageGoodsRel  implements java.io.Serializable {


    // Fields    

     private Long recId;
     private TbGoodsInfo goodsInfo;
     private TbPageCategory pageCategory;
     private Long orderNum;
     private Long createUser;
     private Date createTime;


    // Constructors

    /** default constructor */
    public TbPageGoodsRel() {
    }

    
    /** full constructor */
    public TbPageGoodsRel(TbGoodsInfo goodsInfo, TbPageCategory pageCategory, Long orderNum, Long createUser, Date createTime) {
        this.goodsInfo = goodsInfo;
        this.pageCategory = pageCategory;
        this.orderNum = orderNum;
        this.createUser = createUser;
        this.createTime = createTime;
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

    public Long getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
   








}