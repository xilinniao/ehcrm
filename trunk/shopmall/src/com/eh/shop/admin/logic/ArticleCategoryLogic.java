/**
 * 
 */
package com.eh.shop.admin.logic;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.ArticleCategoryQry;
import com.eh.shop.entity.TbArticleCategory;

/**
 *
 */
public interface ArticleCategoryLogic extends IBaseLogic {
	public String saveArticleCategory(TbArticleCategory entity);
	/**
	 * 删除品牌信息
	 * @param entity
	 * @return
	 */
	public String deleteArticleCategory(TbArticleCategory entity);
	/**
	 * 查找品牌列表
	 * @param qry
	 * @return
	 */
	public Page findArticleCategoryList(ArticleCategoryQry qry);
}
