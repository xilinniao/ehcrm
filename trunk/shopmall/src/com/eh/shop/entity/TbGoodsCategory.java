package com.eh.shop.entity;



/**
 * TbGoodsCategory entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsCategory  implements java.io.Serializable {


    // Fields    

     private Long categoryId;
     private TbGoodsCategory parent;
     private String categoryName;
     private TbShopInfo shopInfo;
     private String keyWords;
     private String categoryDesc;
     private Long dataStatus;
     private Long orderNum;
     private String treeNo;


    // Constructors

    /** default constructor */
    public TbGoodsCategory() {
    }

    
    /** full constructor */
    public TbGoodsCategory(TbGoodsCategory parent, String categoryName, TbShopInfo shopInfo, String keyWords, String categoryDesc, Long dataStatus, Long orderNum, String treeNo) {
        this.parent = parent;
        this.categoryName = categoryName;
        this.shopInfo = shopInfo;
        this.keyWords = keyWords;
        this.categoryDesc = categoryDesc;
        this.dataStatus = dataStatus;
        this.orderNum = orderNum;
        this.treeNo = treeNo;
    }

   
    // Property accessors

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public TbGoodsCategory getParent() {
        return this.parent;
    }
    
    public void setParent(TbGoodsCategory parent) {
        this.parent = parent;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public TbShopInfo getShopInfo() {
        return this.shopInfo;
    }
    
    public void setShopInfo(TbShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public String getKeyWords() {
        return this.keyWords;
    }
    
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getCategoryDesc() {
        return this.categoryDesc;
    }
    
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public Long getDataStatus() {
        return this.dataStatus;
    }
    
    public void setDataStatus(Long dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getTreeNo() {
        return this.treeNo;
    }
    
    public void setTreeNo(String treeNo) {
        this.treeNo = treeNo;
    }
   








}