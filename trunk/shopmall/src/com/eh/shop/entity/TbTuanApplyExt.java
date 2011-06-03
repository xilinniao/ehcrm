package com.eh.shop.entity;



/**
 * TbTuanApplyExt entity. @author MyEclipse Persistence Tools
 */

public class TbTuanApplyExt  implements java.io.Serializable {


    // Fields    

     private Long extId;
     private TbTuanApply apply;
     private String rules;
     private String topicContent;


    // Constructors

    /** default constructor */
    public TbTuanApplyExt() {
    }

    
    /** full constructor */
    public TbTuanApplyExt(TbTuanApply apply, String rules, String topicContent) {
        this.apply = apply;
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

    public TbTuanApply getApply() {
        return this.apply;
    }
    
    public void setApply(TbTuanApply apply) {
        this.apply = apply;
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