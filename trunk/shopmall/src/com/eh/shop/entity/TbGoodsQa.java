package com.eh.shop.entity;

import java.util.Date;

import com.eh.base.util.DateUtil;
import com.eh.base.util.FormateUtil;

public class TbGoodsQa implements java.io.Serializable {
	/**
	 * pk
	 * 
	 **/
	Long recId;
	/**
	 * 客户信息
	 */
	private TbCustInfo custInfo;
	/**
	 * 店铺信息
	 */
    private TbShopInfo shopInfo;
    /**
     * 商品信息
     */
    private TbGoodsInfo goods;
	/**
	 * 是否发布
	 **/
	String isPublish;
	/**
	 * 咨询内容
	 **/
	String question;
	/**
	 * 店铺回答
	 **/
	String answer;
	/**
	 * 提问时间
	 **/
	Date createTime;
	/**
	 * 回答时间
	 **/
	Date answerTime;

	public Long getRecId() {
		return this.recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public TbCustInfo getCustInfo() {
		return custInfo;
	}

	public void setCustInfo(TbCustInfo custInfo) {
		this.custInfo = custInfo;
	}

	public TbShopInfo getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(TbShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}

	public TbGoodsInfo getGoods() {
		return goods;
	}

	public void setGoods(TbGoodsInfo goods) {
		this.goods = goods;
	}

	public String getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAnswerTime() {
		return this.answerTime;
	}

	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}

	public String getCreateTimeStr() {
		return DateUtil.getInstance().formateDate(this.createTime);
	}

	public String getAnswerTimeStr() {
		return DateUtil.getInstance().formateDate(this.answerTime);
	}
	
	public String getIsPublishStr(){
		return FormateUtil.getInstance().getNameByCode("g_yes_no", this.isPublish.toString());
	}
}