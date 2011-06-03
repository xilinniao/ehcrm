package com.eh.shop.admin.logic;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.TuanInfoQry;
import com.eh.shop.entity.TbTuanInfo;

/**
 *
 */
public interface TuanInfoLogic extends IBaseLogic {
	public String saveTuanInfo(TbTuanInfo entity);
	/**
	 * 删除品牌信息
	 * @param entity
	 * @return
	 */
	public String deleteTuanInfo(TbTuanInfo entity);
	/**
	 * 查找品牌列表
	 * @param qry
	 * @return
	 */
	public Page findPage(TuanInfoQry qry);
}