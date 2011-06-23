package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.GoodsRemarkQry;
import com.eh.shop.entity.TbGoodsRemark;

/**
 *
 */
public interface GoodsRemarkLogic extends IBaseLogic {
	public String saveGoodsRemark(TbGoodsRemark entity);
	/**
	 * 删除品牌信息
	 * @param entity
	 * @return
	 */
	public String deleteGoodsRemark(TbGoodsRemark entity);
	/**
	 * 查找品牌列表
	 * @param qry
	 * @return
	 */
	public Page findPage(GoodsRemarkQry qry);
}