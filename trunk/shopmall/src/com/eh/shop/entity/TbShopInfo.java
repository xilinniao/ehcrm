package com.eh.shop.entity;

import java.util.Date;

import com.eh.base.entity.TbUserInfo;
import com.eh.base.util.DateUtil;

/**
 * TbShopInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbShopInfo implements java.io.Serializable {

	// Fields

	private Long shopId;
	private TbShopInfo parent;
	private String shopName;
	private String shopDesc;
	private String keyword;
	private String idNo;
	private String pubNote;
	private String shopAddr;
	private String linkerMan;
	private String linkerMobile;
	private String linkTel;
	private String linkqq;
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
	public TbShopInfo(String shopName, String shopDesc) {
		this.shopName = shopName;
		this.shopDesc = shopDesc;
	}

	/** full constructor */
	public TbShopInfo(TbShopInfo parent, String shopName, String shopDesc,
			String keyword, String idNo, String pubNote, String shopAddr,
			String linkerMan, String linkerMobile, String linkTel,
			String email, TbUserInfo admin, Long imgLogo, Long imgoAd,
			Date foundDate, Date modiDate) {
		this.parent = parent;
		this.shopName = shopName;
		this.shopDesc = shopDesc;
		this.keyword = keyword;
		this.idNo = idNo;
		this.pubNote = pubNote;
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

	public TbShopInfo getParent() {
		return this.parent;
	}

	public void setParent(TbShopInfo parent) {
		this.parent = parent;
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

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getPubNote() {
		return this.pubNote;
	}

	public void setPubNote(String pubNote) {
		this.pubNote = pubNote;
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

	public String getLinkqq() {
		return linkqq;
	}

	public void setLinkqq(String linkqq) {
		this.linkqq = linkqq;
	}

	public String getFoundDateStr() {
		return DateUtil.getInstance().formateDate(this.foundDate,
				DateUtil.DF_YYYY_MM_DD_HH_MM);
	}

	public String getModiDateStr() {
		return DateUtil.getInstance().formateDate(this.modiDate,
				DateUtil.DF_YYYY_MM_DD_HH_MM);
	}

}