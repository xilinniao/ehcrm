package com.eh.shop.entity;

import java.util.Date;


/**
 * TbGoodsCategoryRel entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsCategoryRel  implements java.io.Serializable {


    // Fields    

     private Long recId;
     private TbSiteCategory category;
     private TbGoodsInfo goods;
     private Long orderNum;
     private Long createUser;
     private Date createTime;


    // Constructors

    /** default constructor */
    public TbGoodsCategoryRel() {
    }

    
    /** full constructor */
    public TbGoodsCategoryRel(TbSiteCategory category, TbGoodsInfo goods, Long orderNum, Long createUser, Date createTime) {
        this.category = category;
        this.goods = goods;
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

    public TbSiteCategory getCategory() {
        return this.category;
    }
    
    public void setCategory(TbSiteCategory category) {
        this.category = category;
    }

    public TbGoodsInfo getGoods() {
        return this.goods;
    }
    
    public void setGoods(TbGoodsInfo goods) {
        this.goods = goods;
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