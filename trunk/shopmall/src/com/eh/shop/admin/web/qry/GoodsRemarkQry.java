package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class GoodsRemarkQry extends BaseQuery {
		/**
		 * 客户名称
		 **/
		String custName;		
		/**
		 * 所属商品
		 **/
		Long goodsId;		
	
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
	
}