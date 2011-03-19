/**
 * 
 */
package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.PageCategoryQry;
import com.eh.shop.entity.TbPageCategory;

/**
 *
 */
public interface PageCategoryLogic extends IBaseLogic {
	public String savePageCategory(TbPageCategory entity);
	/**
	 * 删除品牌信息
	 * @param entity
	 * @return
	 */
	public String deletePageCategory(TbPageCategory entity);
	/**
	 * 查找品牌列表
	 * @param qry
	 * @return
	 */
	public Page findPageCategoryList(PageCategoryQry qry);
	
	public List findPageTypeList(Long shopId);
	/**
	 * 查找所有页面分类信息
	 * @return
	 */
	public List findAllPageCategoryList(Long shopId);
}
