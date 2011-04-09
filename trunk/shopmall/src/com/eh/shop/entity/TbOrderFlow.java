package com.eh.shop.entity;

import java.util.Date;


/**
 * TbOrderFlow entity. @author MyEclipse Persistence Tools
 */

public class TbOrderFlow  implements java.io.Serializable {


    // Fields    

     private Long flowId;
     private TbOrderMain order;
     private String flowNote;
     private Date flowTime;
     private Long userId;


    // Constructors

    /** default constructor */
    public TbOrderFlow() {
    }

    
    /** full constructor */
    public TbOrderFlow(TbOrderMain order, String flowNote, Date flowTime, Long userId) {
        this.order = order;
        this.flowNote = flowNote;
        this.flowTime = flowTime;
        this.userId = userId;
    }

   
    // Property accessors

    public Long getFlowId() {
        return this.flowId;
    }
    
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public TbOrderMain getOrder() {
        return this.order;
    }
    
    public void setOrder(TbOrderMain order) {
        this.order = order;
    }

    public String getFlowNote() {
        return this.flowNote;
    }
    
    public void setFlowNote(String flowNote) {
        this.flowNote = flowNote;
    }

    public Date getFlowTime() {
        return this.flowTime;
    }
    
    public void setFlowTime(Date flowTime) {
        this.flowTime = flowTime;
    }

    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
   








}