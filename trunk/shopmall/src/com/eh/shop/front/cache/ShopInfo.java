package com.eh.shop.front.cache;

import java.io.Serializable;
import java.util.Date;

public class ShopInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9009020881514617043L;
	
	private String shopName;
    private String shopDesc;
    private String keyword;
    private String idNo;
    private String shopAddr;
    private String linkerMan;
    private String linkerMobile;
    private String linkTel;
    private String email;    
    private Long imgLogo;
    private Long imgoAd;
    private Date foundDate;
    
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
	public Date getFoundDate() {
		return foundDate;
	}
	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}
}
