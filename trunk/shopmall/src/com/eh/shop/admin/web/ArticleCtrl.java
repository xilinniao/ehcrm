/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.util.VelocityUtils;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.ArticleLogic;
import com.eh.shop.admin.web.qry.ArticleQry;
import com.eh.shop.entity.TbArticleCategory;
import com.eh.shop.entity.TbArticleInfo;
/**
 * 控制类
 *
 */
public class ArticleCtrl extends BaseShopAdminCtrl {
	ArticleLogic articleLogic = null;
	/**
	 * 首页
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/article/index");
		List categoryList = articleLogic.findCategoryList();
		mav.addObject("categoryList", categoryList);
		
		ArticleQry qry = new ArticleQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = this. articleLogic.findArticleList(qry);
		mav.addObject("page", page);
		return mav;
	}
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ArticleQry qry = new ArticleQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = this. articleLogic.findArticleList(qry);
		Map data = super.getParameterMap(request);
		data.put("page", page);
		renderJson(response, VelocityUtils.render("shop-admin-article-info-list",data));		
		return null;
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/article/edit");
		TbArticleInfo entity = new TbArticleInfo();
		entity.setArticleId(Constants.ADD_PK_ID);
		mav.addObject("entity", entity);
		List categoryList = articleLogic.findCategoryList();
		mav.addObject("categoryList", categoryList);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/article/edit");
		Long articleId = super.getLong(request, "articleId", false);
		// 修改操作
		TbArticleInfo entity = this. articleLogic.get(TbArticleInfo.class, articleId);
		mav.addObject("entity", entity);
		List categoryList = articleLogic.findCategoryList();
		mav.addObject("categoryList", categoryList);
		return mav;
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long articleId = super.getLong(request, "articleId", false);
		Long categoryId = super.getLong(request, "categoryId", false);
		TbArticleCategory category = this.articleLogic.get(TbArticleCategory.class, categoryId);
		
		if(articleId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbArticleInfo entity = new TbArticleInfo();
			super.bindObject(request,entity);
			entity.setCategory(category);
			this. articleLogic.saveArticle(entity);
		}else{
			//修改操作
			TbArticleInfo entity = this.articleLogic.get(TbArticleInfo.class, articleId);
			if(entity!=null){
				super.bindObject(request, entity);
				entity.setCategory(category);
				this. articleLogic.saveArticle(entity);
			}else{
				super.addErrors(request, "非法操作，没有找到指定的文章");
			}
		}
		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " article.xhtml?method=index");
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
		Long articleId = super.getLong(request, "articleId", false);
		TbArticleInfo entity = this. articleLogic.get(TbArticleInfo.class, articleId);
		if(entity!=null){
			String result = this. articleLogic.deleteArticle(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作，找不到相应文章");
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " article.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the articleLogic
	 */
	public ArticleLogic getArticleLogic() {
		return articleLogic;
	}

	/**
	 * @param articleLogic the articleLogic to set
	 */
	public void setArticleLogic(ArticleLogic articleLogic) {
		this.articleLogic = articleLogic;
	}
}
