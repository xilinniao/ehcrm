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
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.admin.web.qry.PageCategoryQry;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbPageType;

/**
 * 控制类
 *
 */
public class PageCategoryCtrl extends BaseShopAdminCtrl {
	PageCategoryLogic pageCategoryLogic = null;
	/**
	 * 首页
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/index");
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
		PageCategoryQry qry = new PageCategoryQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = this. pageCategoryLogic.findPageCategoryList(qry);
		Map data = super.getParameterMap(request);
		data.put("page", page);
		renderJson(response, VelocityUtils.render("shop-admin-page-category-list",
				data));
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/edit");
		TbPageCategory entity = new TbPageCategory();
		entity.setCategoryId(Constants.ADD_PK_ID);
		mav.addObject("entity", entity);
		List pageTypeList = this.pageCategoryLogic.findPageTypeList(userInfo.getShopInfo().getShopId());
		mav.addObject("pageTypeList", pageTypeList);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/edit");
		Long categoryId = super.getLong(request, "categoryId", false);
		// 修改操作
		TbPageCategory entity = this. pageCategoryLogic.get(TbPageCategory.class, categoryId);
		if(entity!=null&&isYourShop(entity.getShopInfo(), userInfo)){
			mav.addObject("entity", entity);
			List pageTypeList = this.pageCategoryLogic.findPageTypeList(userInfo.getShopInfo().getShopId());
			mav.addObject("pageTypeList", pageTypeList);
			return mav;
		}else{
			//设置错误信息
			super.addErrors(request, "非法操作，没有找到指定的首页分类");
			return new ModelAndView(REDIRECT_URL);
		}
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long categoryId = super.getLong(request, "categoryId", false);
		Long pageTypeId = super.getLong(request, "pageType", true);
		
		TbPageType pageType = null;
		if(pageTypeId!=null){
			pageType = this.pageCategoryLogic.get(TbPageType.class, pageTypeId);
		}
		
		if(categoryId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbPageCategory entity = new TbPageCategory();
			super.bindObject(request,entity);
			entity.setShopInfo(userInfo.getShopInfo());
			entity.setPageType(pageType);
			this. pageCategoryLogic.savePageCategory(entity);
		}else{
			//修改操作
			TbPageCategory entity = this. pageCategoryLogic.get(TbPageCategory.class, categoryId);
			if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
				super.bindObject(request, entity);
				entity.setPageType(pageType);
				this.pageCategoryLogic.savePageCategory(entity);
			}else{
				super.addErrors(request, "非法操作，没有找到指定的首页分类");
			}
		}
		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " pageCategory.xhtml?method=index");
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
		Long categoryId = super.getLong(request, "categoryId", false);
		TbPageCategory entity = this. pageCategoryLogic.get(TbPageCategory.class, categoryId);
		if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
			String result = this. pageCategoryLogic.deletePageCategory(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作，没有找到指定的品牌");
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " pageCategory.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the pageCategoryLogic
	 */
	public PageCategoryLogic getPageCategoryLogic() {
		return pageCategoryLogic;
	}

	/**
	 * @param pageCategoryLogic the pageCategoryLogic to set
	 */
	public void setPageCategoryLogic(PageCategoryLogic pageCategoryLogic) {
		this.pageCategoryLogic = pageCategoryLogic;
	}
}
