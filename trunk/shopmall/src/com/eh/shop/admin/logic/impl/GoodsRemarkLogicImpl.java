package com.eh.shop.admin.logic.impl;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.GoodsRemarkLogic;
import com.eh.shop.admin.web.qry.GoodsRemarkQry;
import com.eh.shop.entity.TbGoodsRemark;

public class GoodsRemarkLogicImpl extends BaseLogic implements GoodsRemarkLogic {
	/**
	 * 保存商品评论信息
	 */
	public String saveGoodsRemark(TbGoodsRemark entity) {
		if(entity.getRecId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setRecId(null);
		}
		super.save(entity);
		return null;
	}

	public String deleteGoodsRemark(TbGoodsRemark entity) {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsRemarkInfoLogic#findGoodsRemarkList(com.eh.shop.admin.web.qry.GoodsRemarkInfoQry)
	 */
	public Page findPage(GoodsRemarkQry qry) {
		Criteria criteria = baseDao.createCriteria(TbGoodsRemark.class);
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
}