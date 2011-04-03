package com.eh.shop.entity;

import java.util.Date;


/**
 * TbOrderMain entity. @author MyEclipse Persistence Tools
 */

public class TbOrderMain  implements java.io.Serializable {


    // Fields    

     private Long orderId;
     private TbCustInfo custInfo;
     private TbShopInfo shopInfo;
     private String orderNo;
     private String revicedName;
     private String revicedAddr;
     private String revicedMobile;
     private String revicedTel;
     private String revicedEmail;
     private String orderRemark;
     private Double orderMoney;
     private Double fareFee;
     private Long usesScore;
     private Long orderStatus;
     private Date orderTime;


    // Constructors

    /** default constructor */
    public TbOrderMain() {
    }

    
    /** full constructor */
    public TbOrderMain(TbCustInfo custInfo, TbShopInfo shopInfo, String orderNo, String revicedName, String revicedAddr, String revicedMobile, String revicedTel, String revicedEmail, String orderRemark, Double orderMoney, Double fareFee, Long usesScore, Long orderStatus, Date orderTime) {
        this.custInfo = custInfo;
        this.shopInfo = shopInfo;
        this.orderNo = orderNo;
        this.revicedName = revicedName;
        this.revicedAddr = revicedAddr;
        this.revicedMobile = revicedMobile;
        this.revicedTel = revicedTel;
        this.revicedEmail = revicedEmail;
        this.orderRemark = orderRemark;
        this.orderMoney = orderMoney;
        this.fareFee = fareFee;
        this.usesScore = usesScore;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }

   
    // Property accessors

    public Long getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public TbCustInfo getCustInfo() {
        return this.custInfo;
    }
    
    public void setCustInfo(TbCustInfo custInfo) {
        this.custInfo = custInfo;
    }

    public TbShopInfo getShopInfo() {
        return this.shopInfo;
    }
    
    public void setShopInfo(TbShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public String getOrderNo() {
        return this.orderNo;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getOrderRemark() {
        return this.orderRemark;
    }
    
    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Double getOrderMoney() {
        return this.orderMoney;
    }
    
    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Double getFareFee() {
        return this.fareFee;
    }
    
    public void setFareFee(Double fareFee) {
        this.fareFee = fareFee;
    }

    public Long getUsesScore() {
        return this.usesScore;
    }
    
    public void setUsesScore(Long usesScore) {
        this.usesScore = usesScore;
    }

    public Long getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return this.orderTime;
    }
    
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
   








}