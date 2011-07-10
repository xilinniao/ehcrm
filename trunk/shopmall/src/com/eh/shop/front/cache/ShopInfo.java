package com.eh.shop.front.cache;

import java.io.Serializable;
import java.util.List;

import com.eh.shop.entity.TbGoodsCategory;

public class ShopInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9009020881514617043L;
	
	private Long shopId;
	private String shopName;
    private String shopDesc;
    private String keyword;
    private String idNo;
    private String shopAddr;
    private String linkerMan;
    private String linkerMobile;
    private String linkTel;
    private String linkqq;//联系QQ
    private String email;    
    private Long imgLogo;
    private Long imgoAd;
    private String foundDate;
    /**
     * 店铺公告
     */
    private String pubNote;
    List<GoodsCategory> categoryList;
    
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopDesc() {
		return shopDesc;
	}
	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getShopAddr() {
		return shopAddr;
	}
	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	public String getLinkerMan() {
		return linkerMan;
	}
	public void setLinkerMan(String linkerMan) {
		this.linkerMan = linkerMan;
	}
	public String getLinkerMobile() {
		return linkerMobile;
	}
	public void setLinkerMobile(String linkerMobile) {
		this.linkerMobile = linkerMobile;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getEmail() {
		return email;
	}	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	

	public List<GoodsCategory> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<GoodsCategory> categoryList) {
		this.categoryList = categoryList;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getImgLogo() {
		return imgLogo;
	}
	public void setImgLogo(Long imgLogo) {
		this.imgLogo = imgLogo;
	}
	public Long getImgoAd() {
		return imgoAd;
	}
	public void setImgoAd(Long imgoAd) {
		this.imgoAd = imgoAd;
	}
	public String getFoundDate() {
		return foundDate;
	}
	public void setFoundDate(String foundDate) {
		this.foundDate = foundDate;
	}
	public String getPubNote() {
		return pubNote;
	}
	public void setPubNote(String pubNote) {
		this.pubNote = pubNote;
	}
	public String getLinkqq() {
		return linkqq;
	}
	public void setLinkqq(String linkqq) {
		this.linkqq = linkqq;
	}
	
}
