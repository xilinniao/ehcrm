package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class TuanApplyQry extends BaseQuery {
		/**
		 * 店铺名称
		 **/
		Long shopId;		
		/**
		 * 团购名称
		 **/
		String topicName;
		/**
		 * 申请状态
		 */
		Long applyStatus;
	
		public Long getShopId(){
			return this.shopId;
		}
		public void setShopId(Long shopId){
			this.shopId = shopId;
		}
		public String getTopicName(){
			return this.topicName;
		}
		public void setTopicName(String topicName){
			this.topicName = topicName;
		}
		public Long getApplyStatus() {
			return applyStatus;
		}
		public void setApplyStatus(Long applyStatus) {
			this.applyStatus = applyStatus;
		}
	
}