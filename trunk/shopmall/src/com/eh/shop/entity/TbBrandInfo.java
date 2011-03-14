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
     private Long ordernum;
     private String url;


    // Constructors

    /** default constructor */
    public TbBrandInfo() {
    }

    
    /** full constructor */
    public TbBrandInfo(TbShopInfo shopInfo, String introduction, String logo, String name, Long ordernum, String url) {
        this.shopInfo = shopInfo;
        this.introduction = introduction;
        this.logo = logo;
        this.name = name;
        this.ordernum = ordernum;
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

    public Long getOrdernum() {
        return this.ordernum;
    }
    
    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
   








}