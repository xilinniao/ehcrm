/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.admin.web.qry.PageCategoryQry;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbPageGoodsRel;
import com.eh.shop.entity.TbSiteCategory;

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
	 * 商品类别
	 */
	public ModelAndView category(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/category");
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/list");
		PageCategoryQry qry = new PageCategoryQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = this.pageCategoryLogic.findPageCategoryList(qry);
		mav.addObject("page", page);
		mav.addObject("qry", qry);
		TbSiteCategory siteCategory = this.pageCategoryLogic.get(TbSiteCategory.class, qry.getCategoryId());
		mav.addObject("siteCategory", siteCategory);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/edit");
		TbPageCategory entity = new TbPageCategory();
		entity.setCategoryId(Constants.ADD_PK_ID);
		Long siteCategoryId = super.getLong(request, "siteCategoryId", false);
		TbSiteCategory siteCategory = this.pageCategoryLogic.get(TbSiteCategory.class, siteCategoryId);
		entity.setSiteCategory(siteCategory);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/edit");
		Long categoryId = super.getLong(request, "categoryId", false);
		// 修改操作
		TbPageCategory entity = this.pageCategoryLogic.get(TbPageCategory.class, categoryId);
		if(true){
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
		Long siteCategoryId = super.getLong(request, "siteCategoryId", false);
		TbSiteCategory siteCategory = this.pageCategoryLogic.get(TbSiteCategory.class, siteCategoryId);
		
		if(categoryId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbPageCategory entity = new TbPageCategory();
			super.bindObject(request,entity);
			entity.setSiteCategory(siteCategory);
			this.pageCategoryLogic.savePageCategory(entity);
		}else{
			//修改操作
			TbPageCategory entity = this.pageCategoryLogic.get(TbPageCategory.class, categoryId);
			if(true){
				super.bindObject(request, entity);
				entity.setSiteCategory(siteCategory);
				this.pageCategoryLogic.savePageCategory(entity);
			}else{
				super.addErrors(request, "非法操作，没有权限操作");
			}
		}
		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", "pageCategory.xhtml?method=list&categoryId="+siteCategoryId);
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
		TbPageCategory entity = this.pageCategoryLogic.get(TbPageCategory.class, categoryId);
		if(true){
			String result = this.pageCategoryLogic.deletePageCategory(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作，没有找到指定的品牌");
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", "pageCategory.xhtml?method=index");
		return mav;
	}
	
	/**
	 * 商品列表信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView pageGoodsList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/pageGoodsList");
		Long categoryId = super.getLong(request, "pageId", false);
		List goodsList = this.pageCategoryLogic.findGoodsByPageCategory(categoryId);
		mav.addObject("goodsList", goodsList);
		return mav;
	}
	
	public ModelAndView onAddPageGoods(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long categoryId = super.getLong(request, "pageId", false);//分类ID
		Long[] goodsIds = super.getLongs(request, "goodsId", false);
		
		if(goodsIds!=null){
			List<TbPageGoodsRel> rels = new ArrayList<TbPageGoodsRel>();
			TbPageCategory pageCategory = this.pageCategoryLogic.get(TbPageCategory.class, categoryId);
			Long maxOrderNum = this.pageCategoryLogic.findMaxPageCategoryOrderNumber(categoryId);
			if(maxOrderNum==null){
				maxOrderNum = Long.valueOf(0);
			}
			List<TbGoodsInfo> goodsList = this.pageCategoryLogic.findGoodsByPageCategory(categoryId);
			for(Long goodsId:goodsIds){
				if(!this.checkGoodsInPage(goodsId, goodsList)){
					TbPageGoodsRel rel = new TbPageGoodsRel();
					rel.setCreateTime(new Date());
					rel.setCreateUser(userInfo.getUser().getUserId());
					rel.setGoodsInfo(this.pageCategoryLogic.get(TbGoodsInfo.class, goodsId));
					rel.setPageCategory(pageCategory);
					rel.setOrderNum(maxOrderNum++);
					rels.add(rel);
				}
			}
			this.pageCategoryLogic.addGoodsToPage(rels);
		}
		super.renderText(response, "OK");
		return null;
	}
	
	private boolean checkGoodsInPage(Long goodsId,List<TbGoodsInfo> goodsList){
		boolean hasIt = false;
		for(TbGoodsInfo next:goodsList){
			if(next.getGoodsId().longValue()==goodsId.longValue()){
				hasIt = true;
				break;
			}
		}
		return hasIt;
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
