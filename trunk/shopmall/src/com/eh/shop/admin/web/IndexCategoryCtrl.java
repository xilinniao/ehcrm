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
import com.eh.shop.admin.logic.IndexCategoryLogic;
import com.eh.shop.admin.web.qry.ShopIndexCategoryQry;
import com.eh.shop.entity.TbIndexCategory;

/**
 * 控制类
 *
 */
public class IndexCategoryCtrl extends BaseShopAdminCtrl {
	IndexCategoryLogic indexCategoryLogic = null;
	/**
	 * 首页
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/index_category/index");		
		ShopIndexCategoryQry qry = new ShopIndexCategoryQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = this.indexCategoryLogic.findIndexCategoryList(qry);
		mav.addObject("page", page);
		mav.addObject("qry", qry);		
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/index_category/edit");
		TbIndexCategory entity = new TbIndexCategory();
		entity.setCategoryId(Constants.ADD_PK_ID);
		entity.setIsShow(Constants.YES);
		entity.setShowNum(Long.valueOf(10));
		entity.setOrderNum(this.indexCategoryLogic.findMaxOrderNum(userInfo.getShopInfo().getShopId()));
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/index_category/edit");
		Long categoryId = super.getLong(request, "categoryId", false);
		// 修改操作
		TbIndexCategory entity = this.indexCategoryLogic.get(TbIndexCategory.class, categoryId);
		if(entity!=null&&isYourShop(entity.getShopInfo(), userInfo)){
			mav.addObject("entity", entity);
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
		
		if(categoryId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbIndexCategory entity = new TbIndexCategory();
			super.bindObject(request,entity);
			entity.setShopInfo(userInfo.getShopInfo());
			this.indexCategoryLogic.saveIndexCategory(entity);
		}else{
			//修改操作
			TbIndexCategory entity = this.indexCategoryLogic.get(TbIndexCategory.class, categoryId);
			if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
				super.bindObject(request, entity);
				this.indexCategoryLogic.saveIndexCategory(entity);
			}else{
				super.addErrors(request, "非法操作，没有找到指定的首页分类");
			}
		}
		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", "indexCategory.xhtml?method=index");
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
		TbIndexCategory entity = this.indexCategoryLogic.get(TbIndexCategory.class, categoryId);
		if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
			String result = this.indexCategoryLogic.deleteIndexCategory(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作，没有找到指定的品牌");
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", "indexCategory.xhtml?method=index");
		return mav;
	}

	public IndexCategoryLogic getIndexCategoryLogic() {
		return indexCategoryLogic;
	}

	public void setIndexCategoryLogic(IndexCategoryLogic indexCategoryLogic) {
		this.indexCategoryLogic = indexCategoryLogic;
	}

}
