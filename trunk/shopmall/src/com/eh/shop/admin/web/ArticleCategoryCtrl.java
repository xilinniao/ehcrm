/**
 * 
 */
package com.eh.shop.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.ArticleCategoryLogic;
import com.eh.shop.admin.web.qry.ArticleCategoryQry;
import com.eh.shop.entity.TbArticleCategory;

/**
 * 控制类
 *
 */
public class ArticleCategoryCtrl extends BaseShopAdminCtrl {
	ArticleCategoryLogic articleCategoryLogic = null;
	/**
	 * 首页
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/article_category/index");
		ArticleCategoryQry qry = new ArticleCategoryQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = this.articleCategoryLogic.findArticleCategoryList(qry);
		mav.addObject("page", page);
		return mav;
	}
	
	/**
	 * 新增
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/article_category/edit");
		TbArticleCategory entity = new TbArticleCategory();
		entity.setCategoryId(Constants.ADD_PK_ID);
		mav.addObject("entity", entity);
		return mav;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/article_category/edit");
		Long categoryId = super.getLong(request, "categoryId", false);
		// 修改操作
		TbArticleCategory entity = this. articleCategoryLogic.get(TbArticleCategory.class, categoryId);
		mav.addObject("entity", entity);
		return mav;
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long categoryId = super.getLong(request, "categoryId", false);
		
		if(categoryId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbArticleCategory entity = new TbArticleCategory();
			super.bindObject(request,entity);
			this. articleCategoryLogic.saveArticleCategory(entity);
		}else{
			//修改操作
			TbArticleCategory entity = this. articleCategoryLogic.get(TbArticleCategory.class, categoryId);
			super.bindObject(request, entity);
			this. articleCategoryLogic.saveArticleCategory(entity);
		}
		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " articleCategory.xhtml?method=index");
		return mav;
	}
	
	/**
	 * 删除操作
	 * @param request 
	 * @param response  
	 * @return 
	 * @throws Exception
	 */
	public ModelAndView onDelete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long articleCategoryId = super.getLong(request, "articleCategoryId", false);
		TbArticleCategory entity = this.articleCategoryLogic.get(TbArticleCategory.class, articleCategoryId);
		String result = this. articleCategoryLogic.deleteArticleCategory(entity);
		//返回错误信息
		if(StringUtils.isNotBlank(result)){
			super.addErrors(request, result);
		}	
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " articleCategory.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the articleCategoryLogic
	 */
	public ArticleCategoryLogic getArticleCategoryLogic() {
		return articleCategoryLogic;
	}

	/**
	 * @param articleCategoryLogic the articleCategoryLogic to set
	 */
	public void setArticleCategoryLogic(ArticleCategoryLogic articleCategoryLogic) {
		this.articleCategoryLogic = articleCategoryLogic;
	}	
}
