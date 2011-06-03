package com.eh.shop.entity;



/**
 * TbTuanInfoExt entity. @author MyEclipse Persistence Tools
 */

public class TbTuanInfoExt  implements java.io.Serializable {


    // Fields    

     private Long extId;
     private TbTuanInfo info;
     private String rules;
     private String topicContent;


    // Constructors

    /** default constructor */
    public TbTuanInfoExt() {
    }

    
    /** full constructor */
    public TbTuanInfoExt(TbTuanInfo info, String rules, String topicContent) {
        this.info = info;
        this.rules = rules;
        this.topicContent = topicContent;
    }

   
    // Property accessors

    public Long getExtId() {
        return this.extId;
    }
    
    public void setExtId(Long extId) {
        this.extId = extId;
    }

    public TbTuanInfo getInfo() {
        return this.info;
    }
    
    public void setInfo(TbTuanInfo info) {
        this.info = info;
    }

    public String getRules() {
        return this.rules;
    }
    
    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getTopicContent() {
        return this.topicContent;
    }
    
    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }
   








}