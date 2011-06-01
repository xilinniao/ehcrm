package com.eh.shop.entity;

import java.util.Date;

import com.eh.base.util.DateUtil;
import com.eh.base.util.FormateUtil;

public class TbTuanApply implements java.io.Serializable {
		/**
		 * pk
		 * 团购记录ID
		 **/
		Long applyId;
		/**
		 * 店铺名称
		 **/
		Long shopId;
		/**
		 * 团购图片
		 **/
		Long faceImageId;
		/**
		 * 团购名称
		 **/
		String topicName;
		/**
		 * 团购开始日期
		 **/
		Date beginDate;
		/**
		 * 团购结束日期
		 **/
		Date endDate;
		/**
		 * 价格
		 **/
		Double price;
		/**
		 * 折扣价格
		 **/
		Double discountPrice;
		/**
		 * 最大团购数量
		 **/
		Long maxQty;
		/**
		 * 当前数量
		 **/
		Long currQty;
		/**
		 * 创建人
		 **/
		Long createUser;
		/**
		 * 创建时间
		 **/
		Date createTime;
	
		public Long getApplyId(){
			return this.applyId;
		}		
		public void setApplyId(Long applyId){
			this.applyId = applyId;
		}
		public Long getShopId(){
			return this.shopId;
		}		
		public void setShopId(Long shopId){
			this.shopId = shopId;
		}
		public Long getFaceImageId(){
			return this.faceImageId;
		}		
		public void setFaceImageId(Long faceImageId){
			this.faceImageId = faceImageId;
		}
		public String getTopicName(){
			return this.topicName;
		}		
		public void setTopicName(String topicName){
			this.topicName = topicName;
		}
		public Date getBeginDate(){
			return this.beginDate;
		}		
		public void setBeginDate(Date beginDate){
			this.beginDate = beginDate;
		}
		public Date getEndDate(){
			return this.endDate;
		}		
		public void setEndDate(Date endDate){
			this.endDate = endDate;
		}
		public Double getPrice(){
			return this.price;
		}		
		public void setPrice(Double price){
			this.price = price;
		}
		public Double getDiscountPrice(){
			return this.discountPrice;
		}		
		public void setDiscountPrice(Double discountPrice){
			this.discountPrice = discountPrice;
		}
		public Long getMaxQty(){
			return this.maxQty;
		}		
		public void setMaxQty(Long maxQty){
			this.maxQty = maxQty;
		}
		public Long getCurrQty(){
			return this.currQty;
		}		
		public void setCurrQty(Long currQty){
			this.currQty = currQty;
		}
		public Long getCreateUser(){
			return this.createUser;
		}		
		public void setCreateUser(Long createUser){
			this.createUser = createUser;
		}
		public Date getCreateTime(){
			return this.createTime;
		}		
		public void setCreateTime(Date createTime){
			this.createTime = createTime;
		}
	
		public String getBeginDateStr(){
			return DateUtil.getInstance().formateDate(this.beginDate);
		}
		public String getEndDateStr(){
			return DateUtil.getInstance().formateDate(this.endDate);
		}
		public String getPriceStr(){
			return FormateUtil.getInstance().formateDouble(this.price);
		}
		public String getDiscountPriceStr(){
			return FormateUtil.getInstance().formateDouble(this.discountPrice);
		}
		public String getCreateTimeStr(){
			return DateUtil.getInstance().formateDate(this.createTime);
		}
}