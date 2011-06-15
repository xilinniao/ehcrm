package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

public class GoodsQaQry extends BaseQuery {
	private Long custId;
	private String question;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
}