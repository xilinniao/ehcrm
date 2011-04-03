package com.eh.shop.entity;

import java.util.Date;


/**
 * TbCustInfo entity. @author MyEclipse Persistence Tools
 */

public class TbCustInfo  implements java.io.Serializable {


    // Fields    

     private Long custId;
     private String custCode;
     private String custPwd;
     private String custName;
     private String email;
     private Long custLevel;
     private String custMobile;
     private String custTel;
     private String custAddr;
     private Long custScore;
     private Date lastLoginTime;
     private Date createTime;


    // Constructors

    /** default constructor */
    public TbCustInfo() {
    }

    
    /** full constructor */
    public TbCustInfo(String custCode, String custPwd, String custName, String email, Long custLevel, String custMobile, String custTel, String custAddr, Long custScore, Date lastLoginTime, Date createTime) {
        this.custCode = custCode;
        this.custPwd = custPwd;
        this.custName = custName;
        this.email = email;
        this.custLevel = custLevel;
        this.custMobile = custMobile;
        this.custTel = custTel;
        this.custAddr = custAddr;
        this.custScore = custScore;
        this.lastLoginTime = lastLoginTime;
        this.createTime = createTime;
    }

   
    // Property accessors

    public Long getCustId() {
        return this.custId;
    }
    
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustCode() {
        return this.custCode;
    }
    
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustPwd() {
        return this.custPwd;
    }
    
    public void setCustPwd(String custPwd) {
        this.custPwd = custPwd;
    }

    public String getCustName() {
        return this.custName;
    }
    
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCustLevel() {
        return this.custLevel;
    }
    
    public void setCustLevel(Long custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustMobile() {
        return this.custMobile;
    }
    
    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getCustTel() {
        return this.custTel;
    }
    
    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public String getCustAddr() {
        return this.custAddr;
    }
    
    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public Long getCustScore() {
        return this.custScore;
    }
    
    public void setCustScore(Long custScore) {
        this.custScore = custScore;
    }

    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }
    
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
   








}