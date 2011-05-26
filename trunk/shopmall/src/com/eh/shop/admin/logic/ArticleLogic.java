/**
 * 
 */
package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.ArticleQry;
import com.eh.shop.entity.TbArticleCategory;
import com.eh.shop.entity.TbArticleInfo;

/**
 *
 */
public interface ArticleLogic extends IBaseLogic {
	public String saveArticle(TbArticleInfo entity);
	/**
	 * 删除品牌信息
	 * @param entity
	 * @return
	 */
	public String deleteArticle(TbArticleInfo entity);
	/**
	 * 查找品牌列表
	 * @param qry
	 * @return
	 */
	public Page findArticleList(ArticleQry qry);
	/**
	 * 查找类别信息
	 * @return
	 */
	public List findCategoryList();
	
	/**
	 * 根据URL列表查询文章内容信息
	 * @param url
	 * @return
	 */
	public TbArticleInfo findArticleByUrl(String url);
}