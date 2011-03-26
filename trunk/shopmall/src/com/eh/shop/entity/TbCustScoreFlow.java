package com.eh.shop.entity;

import java.util.Date;


/**
 * TbCustScoreFlow entity. @author MyEclipse Persistence Tools
 */

public class TbCustScoreFlow  implements java.io.Serializable {


    // Fields    

     private Long flowId;
     private TbCustInfo custInfo;
     private Long scoreNum;
     private Long scoreType;
     private Long objId;
     private String flowRemark;
     private Date createTime;


    // Constructors

    /** default constructor */
    public TbCustScoreFlow() {
    }

    
    /** full constructor */
    public TbCustScoreFlow(TbCustInfo custInfo, Long scoreNum, Long scoreType, Long objId, String flowRemark, Date createTime) {
        this.custInfo = custInfo;
        this.scoreNum = scoreNum;
        this.scoreType = scoreType;
        this.objId = objId;
        this.flowRemark = flowRemark;
        this.createTime = createTime;
    }

   
    // Property accessors

    public Long getFlowId() {
        return this.flowId;
    }
    
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public TbCustInfo getCustInfo() {
        return this.custInfo;
    }
    
    public void setCustInfo(TbCustInfo custInfo) {
        this.custInfo = custInfo;
    }

    public Long getScoreNum() {
        return this.scoreNum;
    }
    
    public void setScoreNum(Long scoreNum) {
        this.scoreNum = scoreNum;
    }

    public Long getScoreType() {
        return this.scoreType;
    }
    
    public void setScoreType(Long scoreType) {
        this.scoreType = scoreType;
    }

    public Long getObjId() {
        return this.objId;
    }
    
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public String getFlowRemark() {
        return this.flowRemark;
    }
    
    public void setFlowRemark(String flowRemark) {
        this.flowRemark = flowRemark;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
   








}