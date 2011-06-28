package com.eh.shop.entity;

import java.util.Date;

import com.eh.base.entity.TbAttachment;
import com.eh.base.util.DateUtil;
import com.eh.base.util.FormateUtil;

/**
 * TbGoodsInfo entity. @author MyEclipse Persistence Tools
 */

public class TbGoodsInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6344241108762878073L;

	private Long goodsId;
	private Long defaultGoodsSub;// 默认第一个子商品信息
	private TbShopInfo shopInfo;
	private TbGoodsCategory category;
	private TbSiteCategory siteCategory;
	private TbBrandInfo brandInfo;
	private TbIndexCategory indexCategory;
	private String goodsName;
	private String keyWord;
	private String goodNo;
	private Double weight;
	private Double marketPrice;
	private Double discountPrice;
	private Long leavesCount;
	private TbAttachment faceImage;
	private String jdUrl;
	private Long createUser;
	private Date createTime;
	private Long isRecommend;
	private Long orderNum;
	private TbGoodsExtend ext;

	// Constructors

	/** default constructor */
	public TbGoodsInfo() {
	}

	/** full constructor */
	public TbGoodsInfo(TbShopInfo shopInfo, TbGoodsCategory category,
			TbSiteCategory siteCategory, TbBrandInfo brandInfo,
			TbIndexCategory indexCategory, String goodsName, String keyWord,
			String goodNo, Double weight, Double marketPrice,
			Double discountPrice, Long leavesCount, TbAttachment faceImage,
			String jdUrl, Long createUser, Date createTime, TbGoodsExtend ext) {
		this.shopInfo = shopInfo;
		this.category = category;
		this.siteCategory = siteCategory;
		this.brandInfo = brandInfo;
		this.indexCategory = indexCategory;
		this.goodsName = goodsName;
		this.keyWord = keyWord;
		this.goodNo = goodNo;
		this.weight = weight;
		this.marketPrice = marketPrice;
		this.discountPrice = discountPrice;
		this.leavesCount = leavesCount;
		this.faceImage = faceImage;
		this.jdUrl = jdUrl;
		this.createUser = createUser;
		this.createTime = createTime;
		this.ext = ext;
	}

	// Property accessors

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public TbShopInfo getShopInfo() {
		return this.shopInfo;
	}

	public void setShopInfo(TbShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}

	public TbGoodsCategory getCategory() {
		return this.category;
	}

	public void setCategory(TbGoodsCategory category) {
		this.category = category;
	}

	public TbSiteCategory getSiteCategory() {
		return this.siteCategory;
	}

	public void setSiteCategory(TbSiteCategory siteCategory) {
		this.siteCategory = siteCategory;
	}

	public TbBrandInfo getBrandInfo() {
		return this.brandInfo;
	}

	public void setBrandInfo(TbBrandInfo brandInfo) {
		this.brandInfo = brandInfo;
	}

	public TbIndexCategory getIndexCategory() {
		return this.indexCategory;
	}

	public void setIndexCategory(TbIndexCategory indexCategory) {
		this.indexCategory = indexCategory;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getGoodNo() {
		return this.goodNo;
	}

	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Long getLeavesCount() {
		return this.leavesCount;
	}

	public void setLeavesCount(Long leavesCount) {
		this.leavesCount = leavesCount;
	}

	public TbAttachment getFaceImage() {
		return this.faceImage;
	}

	public void setFaceImage(TbAttachment faceImage) {
		this.faceImage = faceImage;
	}

	public String getJdUrl() {
		return this.jdUrl;
	}

	public void setJdUrl(String jdUrl) {
		this.jdUrl = jdUrl;
	}

	public Long getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public TbGoodsExtend getExt() {
		return this.ext;
	}

	public void setExt(TbGoodsExtend ext) {
		this.ext = ext;
	}

	public Long getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Long isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Long getDefaultGoodsSub() {
		return defaultGoodsSub;
	}

	public void setDefaultGoodsSub(Long defaultGoodsSub) {
		this.defaultGoodsSub = defaultGoodsSub;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public String getWeightStr() {
		return FormateUtil.getInstance().formateDouble(this.weight);
	}

	public String getMarketPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.marketPrice);
	}

	public String getDiscountPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice);
	}

	public String getCreateTimeStr() {
		return DateUtil.getInstance().formateDate(this.createTime);
	}

}