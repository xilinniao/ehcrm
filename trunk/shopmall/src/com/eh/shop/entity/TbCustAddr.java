package com.eh.shop.entity;

import java.util.Date;


/**
 * TbCustAddr entity. @author MyEclipse Persistence Tools
 */

public class TbCustAddr  implements java.io.Serializable {


    // Fields    

     private Long addrId;
     private Long custId;
     private String revicedName;
     private String revicedAddr;
     private String revicedMobile;
     private String revicedTel;
     private String revicedEmail;
     private Date updateTime;


    // Constructors

    /** default constructor */
    public TbCustAddr() {
    }

    
    /** full constructor */
    public TbCustAddr(Long custId, String revicedName, String revicedAddr, String revicedMobile, String revicedTel, String revicedEmail, Date updateTime) {
        this.custId = custId;
        this.revicedName = revicedName;
        this.revicedAddr = revicedAddr;
        this.revicedMobile = revicedMobile;
        this.revicedTel = revicedTel;
        this.revicedEmail = revicedEmail;
        this.updateTime = updateTime;
    }

   
    // Property accessors

    public Long getAddrId() {
        return this.addrId;
    }
    
    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    public Long getCustId() {
        return this.custId;
    }
    
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getRevicedName() {
        return this.revicedName;
    }
    
    public void setRevicedName(String revicedName) {
        this.revicedName = revicedName;
    }

    public String getRevicedAddr() {
        return this.revicedAddr;
    }
    
    public void setRevicedAddr(String revicedAddr) {
        this.revicedAddr = revicedAddr;
    }

    public String getRevicedMobile() {
        return this.revicedMobile;
    }
    
    public void setRevicedMobile(String revicedMobile) {
        this.revicedMobile = revicedMobile;
    }

    public String getRevicedTel() {
        return this.revicedTel;
    }
    
    public void setRevicedTel(String revicedTel) {
        this.revicedTel = revicedTel;
    }

    public String getRevicedEmail() {
        return this.revicedEmail;
    }
    
    public void setRevicedEmail(String revicedEmail) {
        this.revicedEmail = revicedEmail;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
   








}