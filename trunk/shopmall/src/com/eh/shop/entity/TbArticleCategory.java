package com.eh.shop.entity;



/**
 * TbArticleCategory entity. @author MyEclipse Persistence Tools
 */

public class TbArticleCategory  implements java.io.Serializable {


    // Fields    

     private Long categoryId;
     private String categoryName;
     private String metaKeyWord;
     private String metaDesc;
     private Long orderNum;


    // Constructors

    /** default constructor */
    public TbArticleCategory() {
    }

    
    /** full constructor */
    public TbArticleCategory(String categoryName, String metaKeyWord, String metaDesc, Long orderNum) {
        this.categoryName = categoryName;
        this.metaKeyWord = metaKeyWord;
        this.metaDesc = metaDesc;
        this.orderNum = orderNum;
    }

   
    // Property accessors

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMetaKeyWord() {
        return this.metaKeyWord;
    }
    
    public void setMetaKeyWord(String metaKeyWord) {
        this.metaKeyWord = metaKeyWord;
    }

    public String getMetaDesc() {
        return this.metaDesc;
    }
    
    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
   








}