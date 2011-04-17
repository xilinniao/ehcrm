package com.eh.shop.entity;



/**
 * TbSiteCategory entity. @author MyEclipse Persistence Tools
 */

public class TbSiteCategory  implements java.io.Serializable {


    // Fields    

     private Long categoryId;
     private TbSiteCategory parent;
     private String categoryName;
     private String categoryUrl;
     private String keyWords;
     private String categoryDesc;
     private Long dataStatus;
     private Long orderNum;
     private Long showAtNav;
     private String treeNo;
     private Long isLeaf;
     private Long categoryLevel;
     private String jdUrl;


    // Constructors

    /** default constructor */
    public TbSiteCategory() {
    }

    
    /** full constructor */
    public TbSiteCategory(TbSiteCategory parent, String categoryName, String categoryUrl, String keyWords, String categoryDesc, Long dataStatus, Long orderNum, Long showAtNav, String treeNo, Long isLeaf, Long categoryLevel, String jdUrl) {
        this.parent = parent;
        this.categoryName = categoryName;
        this.categoryUrl = categoryUrl;
        this.keyWords = keyWords;
        this.categoryDesc = categoryDesc;
        this.dataStatus = dataStatus;
        this.orderNum = orderNum;
        this.showAtNav = showAtNav;
        this.treeNo = treeNo;
        this.isLeaf = isLeaf;
        this.categoryLevel = categoryLevel;
        this.jdUrl = jdUrl;
    }

   
    // Property accessors

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public TbSiteCategory getParent() {
        return this.parent;
    }
    
    public void setParent(TbSiteCategory parent) {
        this.parent = parent;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryUrl() {
        return this.categoryUrl;
    }
    
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
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

    public Long getShowAtNav() {
        return this.showAtNav;
    }
    
    public void setShowAtNav(Long showAtNav) {
        this.showAtNav = showAtNav;
    }

    public String getTreeNo() {
        return this.treeNo;
    }
    
    public void setTreeNo(String treeNo) {
        this.treeNo = treeNo;
    }

    public Long getIsLeaf() {
        return this.isLeaf;
    }
    
    public void setIsLeaf(Long isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Long getCategoryLevel() {
        return this.categoryLevel;
    }
    
    public void setCategoryLevel(Long categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public String getJdUrl() {
        return this.jdUrl;
    }
    
    public void setJdUrl(String jdUrl) {
        this.jdUrl = jdUrl;
    }
   








}