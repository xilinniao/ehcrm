package com.eh.shop.admin.logic;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.TuanApplyQry;
import com.eh.shop.entity.TbTuanApply;

/**
 *
 */
public interface TuanApplyLogic extends IBaseLogic {
	public String saveTuanApply(TbTuanApply entity);
	/**
	 * 删除团购信息
	 * @param entity
	 * @return
	 */
	public String deleteTuanApply(TbTuanApply entity);
	/**
	 * 查找列表
	 * @param qry
	 * @return
	 */
	public Page findPage(TuanApplyQry qry);
}