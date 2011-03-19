package com.eh.shop.entity;



/**
 * TbBrandInfo entity. @author MyEclipse Persistence Tools
 */

public class TbBrandInfo  implements java.io.Serializable {


    // Fields    

     private Long brandId;
     private TbShopInfo shopInfo;
     private String introduction;
     private String logo;
     private String name;
     private Long orderNum;
     private String url;


    // Constructors

    /** default constructor */
    public TbBrandInfo() {
    }

    
    /** full constructor */
    public TbBrandInfo(TbShopInfo shopInfo, String introduction, String logo, String name, Long orderNum, String url) {
        this.shopInfo = shopInfo;
        this.introduction = introduction;
        this.logo = logo;
        this.name = name;
        this.orderNum = orderNum;
        this.url = url;
    }

   
    // Property accessors

    public Long getBrandId() {
        return this.brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public TbShopInfo getShopInfo() {
        return this.shopInfo;
    }
    
    public void setShopInfo(TbShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public String getIntroduction() {
        return this.introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
   








}