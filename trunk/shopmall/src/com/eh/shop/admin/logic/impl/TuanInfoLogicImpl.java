package com.eh.shop.admin.logic.impl;

import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.TuanInfoLogic;
import com.eh.shop.admin.web.qry.TuanInfoQry;
import com.eh.shop.entity.TbTuanInfo;

public class TuanInfoLogicImpl extends BaseLogic implements TuanInfoLogic {

	public String saveTuanInfo(TbTuanInfo entity) {
		if(entity.getTuanId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setTuanId(null);
		}
		super.save(entity);
		return null;
	}

	public String deleteTuanInfo(TbTuanInfo entity) {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.TuanInfoInfoLogic#findTuanInfoList(com.eh.shop.admin.web.qry.TuanInfoInfoQry)
	 */
	public Page findPage(TuanInfoQry qry) {
		Criteria criteria = baseDao.createCriteria(TbTuanInfo.class);
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
}