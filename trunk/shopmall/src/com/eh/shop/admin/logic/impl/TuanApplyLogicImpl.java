package com.eh.shop.admin.logic.impl;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.TuanApplyLogic;
import com.eh.shop.admin.web.qry.TuanApplyQry;
import com.eh.shop.entity.TbTuanApply;

public class TuanApplyLogicImpl extends BaseLogic implements TuanApplyLogic {

	public String saveTuanApply(TbTuanApply entity) {
		if(entity.getApplyId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setApplyId(null);
		}
		super.save(entity);
		return null;
	}

	public String deleteTuanApply(TbTuanApply entity) {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.TuanApplyInfoLogic#findTuanApplyList(com.eh.shop.admin.web.qry.TuanApplyInfoQry)
	 */
	public Page findPage(TuanApplyQry qry) {
		Criteria criteria = baseDao.createCriteria(TbTuanApply.class);
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
}