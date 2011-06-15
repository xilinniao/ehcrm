package com.eh.shop.admin.logic.impl;

import java.util.Date;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.GoodsQaLogic;
import com.eh.shop.admin.web.qry.GoodsQaQry;
import com.eh.shop.entity.TbCustInfo;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsQa;
import com.eh.shop.front.vo.CustInfo;

public class GoodsQaLogicImpl extends BaseLogic implements GoodsQaLogic {
	/**
	 * 保存商品问答信息
	 */
	public String saveGoodsQa(TbGoodsQa entity) {
		if(entity.getRecId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setRecId(null);
		}
		super.save(entity);
		return null;
	}
	
	/**
	 * 增加咨询内容
	 */
	public String addGoodsQa(CustInfo cust, String question, Long goodsId) {
		TbCustInfo custInfo = super.baseDao.get(TbCustInfo.class, cust.getCustId());
		TbGoodsInfo goods = super.baseDao.get(TbGoodsInfo.class, goodsId);
		TbGoodsQa qa = new TbGoodsQa();
		qa.setQuestion(question);
		qa.setCreateTime(new Date());
		qa.setIsPublish(Constants.NO);
		qa.setCustInfo(custInfo);
		qa.setGoods(goods);
		qa.setShopInfo(goods.getShopInfo());
		super.save(qa);
		return null;
	}
	
	public Page findPage(GoodsQaQry qry) {
		Criteria criteria = super.baseDao.createCriteria(TbGoodsQa.class);
		criteria.createAlias("custInfo", "c");
		CriteriaUtil.addEq(criteria, "c.custId", qry.getCustId());		
		return super.baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
	
	
}