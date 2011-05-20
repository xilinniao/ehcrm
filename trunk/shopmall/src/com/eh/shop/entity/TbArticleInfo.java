package com.eh.shop.entity;

import java.util.Date;


/**
 * TbArticleInfo entity. @author MyEclipse Persistence Tools
 */

public class TbArticleInfo  implements java.io.Serializable {


    // Fields    

     private Long articleId;
     private TbArticleCategory category;
     private String title;
     private String content;
     private Long isPublic;
     private Long isTop;
     private Long isRecommend;
     private Long orderNum;
     private String metaKeyWord;
     private String metaDesc;
     private Date createTime;
     private Long createUser;
     private Date modifyTime;
     private Long modifyUser;


    // Constructors

    /** default constructor */
    public TbArticleInfo() {
    }

    
    /** full constructor */
    public TbArticleInfo(TbArticleCategory category, String title, String content, Long isPublic, Long isTop, Long isRecommend, Long orderNum, String metaKeyWord, String metaDesc, Date createTime, Long createUser, Date modifyTime, Long modifyUser) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.isPublic = isPublic;
        this.isTop = isTop;
        this.isRecommend = isRecommend;
        this.orderNum = orderNum;
        this.metaKeyWord = metaKeyWord;
        this.metaDesc = metaDesc;
        this.createTime = createTime;
        this.createUser = createUser;
        this.modifyTime = modifyTime;
        this.modifyUser = modifyUser;
    }

   
    // Property accessors

    public Long getArticleId() {
        return this.articleId;
    }
    
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public TbArticleCategory getCategory() {
        return this.category;
    }
    
    public void setCategory(TbArticleCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Long getIsPublic() {
        return this.isPublic;
    }
    
    public void setIsPublic(Long isPublic) {
        this.isPublic = isPublic;
    }

    public Long getIsTop() {
        return this.isTop;
    }
    
    public void setIsTop(Long isTop) {
        this.isTop = isTop;
    }

    public Long getIsRecommend() {
        return this.isRecommend;
    }
    
    public void setIsRecommend(Long isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
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

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }
    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyUser() {
        return this.modifyUser;
    }
    
    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }
   








}