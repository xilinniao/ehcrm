package com.eh.shop.entity;

import com.eh.base.entity.TbUserInfo;
import java.util.Date;

/**
 * TbShopInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbShopInfo implements java.io.Serializable {

	// Fields

	private Long shopId;
	private String shopName;
	private String shopDesc;
	private String idNo;
	private String shopAddr;
	private String linkerMan;
	private String linkerMobile;
	private String linkTel;
	private String email;
	private TbUserInfo admin;
	private Long imgLogo;
	private Long imgoAd;
	private Date foundDate;
	private Date modiDate;

	// Constructors

	/** default constructor */
	public TbShopInfo() {
	}

	/** minimal constructor */
	public TbShopInfo(String shopName) {
		this.shopName = shopName;
	}

	/** full constructor */
	public TbShopInfo(String shopName, String shopDesc, String idNo,
			String shopAddr, String linkerMan, String linkerMobile,
			String linkTel, String email, TbUserInfo admin, Long imgLogo,
			Long imgoAd, Date foundDate, Date modiDate) {
		this.shopName = shopName;
		this.shopDesc = shopDesc;
		this.idNo = idNo;
		this.shopAddr = shopAddr;
		this.linkerMan = linkerMan;
		this.linkerMobile = linkerMobile;
		this.linkTel = linkTel;
		this.email = email;
		this.admin = admin;
		this.imgLogo = imgLogo;
		this.imgoAd = imgoAd;
		this.foundDate = foundDate;
		this.modiDate = modiDate;
	}

	// Property accessors

	public Long getShopId() {
		return this.shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDesc() {
		return this.shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getShopAddr() {
		return this.shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getLinkerMan() {
		return this.linkerMan;
	}

	public void setLinkerMan(String linkerMan) {
		this.linkerMan = linkerMan;
	}

	public String getLinkerMobile() {
		return this.linkerMobile;
	}

	public void setLinkerMobile(String linkerMobile) {
		this.linkerMobile = linkerMobile;
	}

	public String getLinkTel() {
		return this.linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TbUserInfo getAdmin() {
		return this.admin;
	}

	public void setAdmin(TbUserInfo admin) {
		this.admin = admin;
	}

	public Long getImgLogo() {
		return this.imgLogo;
	}

	public void setImgLogo(Long imgLogo) {
		this.imgLogo = imgLogo;
	}

	public Long getImgoAd() {
		return this.imgoAd;
	}

	public void setImgoAd(Long imgoAd) {
		this.imgoAd = imgoAd;
	}

	public Date getFoundDate() {
		return this.foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public Date getModiDate() {
		return this.modiDate;
	}

	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
	
	/**
	 * 系统店铺
	 */
	public final static Long SYSTEM_SHOP = Long.valueOf(1);
	
	/**
	 * 判断是否是系统店铺
	 * @return
	 */
	public boolean isSystemShop() {
		return this.shopId.longValue()==SYSTEM_SHOP.longValue();
	}

}