package com.eh.shop.entity;

import java.util.Date;

import com.eh.base.util.DateUtil;

public class TbGoodsRemark implements java.io.Serializable {
		/**
		 * pk
		 * 
		 **/
		Long recId;
		/**
		 * 客户编号
		 **/
		Long custId;
		/**
		 * 客户名称
		 **/
		String custName;
		/**
		 * 所属商品
		 **/
		Long goodsId;
		/**
		 * 客户评价
		 **/
		String content;
		/**
		 * 描述相符得分
		 **/
		Long descSocre;
		/**
		 * 服务相符得分
		 **/
		Long serviceScore;
		/**
		 * 发货速度得分
		 **/
		Long speedScore;
		/**
		 * 评论时间
		 **/
		Date createTime;
	
		public Long getRecId(){
			return this.recId;
		}		
		public void setRecId(Long recId){
			this.recId = recId;
		}
		public Long getCustId(){
			return this.custId;
		}		
		public void setCustId(Long custId){
			this.custId = custId;
		}
		public String getCustName(){
			return this.custName;
		}		
		public void setCustName(String custName){
			this.custName = custName;
		}
		public Long getGoodsId(){
			return this.goodsId;
		}		
		public void setGoodsId(Long goodsId){
			this.goodsId = goodsId;
		}
		public String getContent(){
			return this.content;
		}		
		public void setContent(String content){
			this.content = content;
		}
		public Long getDescSocre(){
			return this.descSocre;
		}		
		public void setDescSocre(Long descSocre){
			this.descSocre = descSocre;
		}
		public Long getServiceScore(){
			return this.serviceScore;
		}		
		public void setServiceScore(Long serviceScore){
			this.serviceScore = serviceScore;
		}
		public Long getSpeedScore(){
			return this.speedScore;
		}		
		public void setSpeedScore(Long speedScore){
			this.speedScore = speedScore;
		}
		public Date getCreateTime(){
			return this.createTime;
		}		
		public void setCreateTime(Date createTime){
			this.createTime = createTime;
		}
	
		public String getCreateTimeStr(){
			return DateUtil.getInstance().formateDate(this.createTime);
		}
}