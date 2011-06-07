package com.eh.shop.entity;

import java.util.Date;

import com.eh.base.entity.TbAttachment;
import com.eh.base.util.DateUtil;
import com.eh.base.util.FormateUtil;

public class TbTuanApply implements java.io.Serializable {
	/**
	 * 序列化号
	 */
	private static final long serialVersionUID = -4407605296338278369L;
	/**
	 * pk 团购记录ID
	 */
	Long applyId;
	/**
	 * 店铺名称
	 */
	TbShopInfo shopInfo;
	/**
	 * 团购图片
	 */
	TbAttachment faceImage;
	/**
	 * 申请状态 0暂存中 1提交申请 21申请通过 20申请不通过
	 */
	Long applyStatus;
	/**
	 * 联系电话
	 */
	String linkTel;
	/**
	 * 联系QQ
	 */
	String linkQq;
	/**
	 * 审批结果
	 */
	String applyResult;
	/**
	 * 团购名称
	 */
	String topicName;
	/**
	 * 团购开始日期
	 */
	Date beginDate;
	/**
	 * 团购结束日期
	 */
	Date endDate;
	/**
	 * 价格
	 */
	Double price;
	/**
	 * 折扣价格
	 */
	Double discountPrice;
	/**
	 * 最大团购数量
	 */
	Long maxQty;
	/**
	 * 当前数量
	 */
	Long currQty;
	/**
	 * 创建人
	 */
	Long createUser;
	/**
	 * 创建时间
	 */
	Date createTime;
	/**
	 * 团购申请扩展信息
	 */
	TbTuanApplyExt ext;

	public Long getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public TbShopInfo getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(TbShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}

	public TbAttachment getFaceImage() {
		return faceImage;
	}

	public void setFaceImage(TbAttachment faceImage) {
		this.faceImage = faceImage;
	}

	public Long getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Long applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Long getMaxQty() {
		return this.maxQty;
	}

	public void setMaxQty(Long maxQty) {
		this.maxQty = maxQty;
	}

	public Long getCurrQty() {
		return this.currQty;
	}

	public void setCurrQty(Long currQty) {
		this.currQty = currQty;
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

	public TbTuanApplyExt getExt() {
		return ext;
	}

	public void setExt(TbTuanApplyExt ext) {
		this.ext = ext;
	}
	
	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getLinkQq() {
		return linkQq;
	}

	public void setLinkQq(String linkQq) {
		this.linkQq = linkQq;
	}

	public String getApplyResult() {
		return applyResult;
	}

	public void setApplyResult(String applyResult) {
		this.applyResult = applyResult;
	}

	public String getBeginDateStr() {
		return DateUtil.getInstance().formateDate(this.beginDate);
	}

	public String getEndDateStr() {
		return DateUtil.getInstance().formateDate(this.endDate);
	}

	public String getPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.price);
	}

	public String getDiscountPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice);
	}
	
	public String getPriceBlank() {
		return FormateUtil.getInstance().formateDouble(this.price,"");
	}

	public String getDiscountPriceBlank() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice,"");
	}

	public String getCreateTimeStr() {
		return DateUtil.getInstance().formateDate(this.createTime);
	}
	
	/**
	 * 获取中文描述
	 */
	public String getApplyStatusStr(){
		if(this.applyStatus==null){
			return "";
		}else if(this.applyStatus.longValue()==Long.valueOf(0)){
			return "未提交审批";
		}else if(this.applyStatus.longValue()==Long.valueOf(1)){
			return "审批中";
		}else if(this.applyStatus.longValue()==Long.valueOf(21)){
			return "审批通过";
		}else if(this.applyStatus.longValue()==Long.valueOf(20)){
			return "审批不通过";
		}else{
			return "";
		}
	}
}