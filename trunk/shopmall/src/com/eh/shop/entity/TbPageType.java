package com.eh.shop.entity;



/**
 * TbPageType entity. @author MyEclipse Persistence Tools
 */

public class TbPageType  implements java.io.Serializable {


    // Fields    

     private Long typeId;
     private TbShopInfo shopInfo;
     private String typeName;


    // Constructors

    /** default constructor */
    public TbPageType() {
    }

    
    /** full constructor */
    public TbPageType(TbShopInfo shopInfo, String typeName) {
        this.shopInfo = shopInfo;
        this.typeName = typeName;
    }

   
    // Property accessors

    public Long getTypeId() {
        return this.typeId;
    }
    
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public TbShopInfo getShopInfo() {
        return this.shopInfo;
    }
    
    public void setShopInfo(TbShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
   








}