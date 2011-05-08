package com.eh.shop.front.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsCategoryRel;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbSiteCategory;
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.logic.FrontCacheLogic;
import com.eh.shop.front.vo.GoodsCategoryVo;
import com.eh.shop.front.web.qry.ProductQry;

public class CategoryCtrl extends BaseFrontCtrl {
	SiteCategoryLogic siteCategoryLogic;
	PageCategoryLogic pageCategoryLogic;
	FrontCacheLogic frontCacheLogic;
	
	/**
	 * 分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView categorya(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/category");
		Long categoryId = super.getLong(request, "categoryId", false);		
		TbSiteCategory category = this.siteCategoryLogic.get(TbSiteCategory.class, categoryId);
		List<TbSiteCategory> categoryList = this.siteCategoryLogic.findCategoryListByTreeNo(category.getTreeNo());
		StringBuffer div = new StringBuffer("<div class=\"mt\"><h2>");
		div.append(category.getCategoryName());
		div.append("</h2></div><div class=\"mc\">");
		for (int i = 1, size = categoryList.size(); i < size; i++) {
			TbSiteCategory tmp = (TbSiteCategory)categoryList.get(i);
			//如果相等，则做循环
			if(tmp.getParent().getCategoryId().longValue()==category.getCategoryId().longValue()){
				div.append("<div class=\"item current\"><h3><b></b><a href=\"http://www.360buy.com/products/670-671-000.html\">");
				div.append(tmp.getCategoryName());
				div.append("</a></h3><ul>");
				this.loopCategory(categoryList, category.getCategoryId(), div);
				div.append("</ul></div>");
			}
		}
		div.append("</div>");
		mav.addObject("categoryList", div.toString());		
		findGoodList(request, categoryId);//分类
		return mav;
	}
	
	/**
	 * 分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView categoryb(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/category");
		Long categoryId = super.getLong(request, "categoryId", false);
		TbSiteCategory category = this.siteCategoryLogic.get(TbSiteCategory.class, categoryId);
		List<TbSiteCategory> categoryList = this.siteCategoryLogic.findCategoryListByTreeNo(category.getTreeNo());
		StringBuffer div = new StringBuffer("<div class=\"mt\"><h2>");
		div.append(category.getCategoryName());
		div.append("</h2></div><div class=\"mc\">");
		for (int i = 1, size = categoryList.size(); i < size; i++) {
			TbSiteCategory tmp = (TbSiteCategory)categoryList.get(i);
			//如果相等，则做循环
			if(tmp.getParent().getCategoryId().longValue()==category.getCategoryId().longValue()){
				div.append("<div class=\"item current\"><h3><b></b><a href=\"http://www.360buy.com/products/670-671-000.html\">");
				div.append(tmp.getCategoryName());
				div.append("</a></h3><ul>");
				this.loopCategory(categoryList, category.getCategoryId(), div);
				div.append("</ul></div>");
			}
		}
		div.append("</div>");
		mav.addObject("categoryList", div.toString());
		findGoodList(request, categoryId);//分类
		return mav;
	}
	
	/**
	 * 产品列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView products(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/products");
		Long categoryId = super.getLong(request, "categoryId", false);
		ProductQry qry = new ProductQry();
		qry.setCategoryId(categoryId);
		Page page = this.siteCategoryLogic.findFrontGoodsList(qry);
		List data = page.getResult();
		if(data!=null){
			List<GoodsShort> productList = new ArrayList();
			for (int i = 0, size = data.size(); i < size; i++) {
				TbGoodsCategoryRel rel = (TbGoodsCategoryRel)data.get(i);
				productList.add(this.frontCacheLogic.findGoodsShort(rel.getGoodsId(),false));
			}
			mav.addObject("productList", productList);
		}
		mav.addObject("page", page);
			
		return mav;
	}
	
	private void loopCategory(List<TbSiteCategory> categoryList,Long category,StringBuffer div){
		for (int i = 1, size = categoryList.size(); i < size; i++) {
			TbSiteCategory tmp = (TbSiteCategory)categoryList.get(i);
			if(tmp.getParent().getCategoryId().longValue()==category.longValue()){
				div.append("<li><a href=\"http://www.360buy.com/products/670-671-672-0-0-0-0-0-0-0-1-1-1.html\">");
				div.append(tmp.getCategoryName());
				div.append("</a></li>");
			}
		}
	}
	
	/**
	 * 查找商品列表
	 * @param request
	 */
	private void findGoodList(HttpServletRequest request,Long siteCategoryId){
		List<TbPageCategory> categoryList = pageCategoryLogic.findPageCategoryByType(siteCategoryId);
		List categoryGoodsList = new ArrayList();
		for(int i = 0,len = categoryList.size();i<len;i++){
			GoodsCategoryVo vo = new GoodsCategoryVo();
			vo.setCategoryName(categoryList.get(i).getCategoryName());
			vo.setGoodsList(findGoodsByCategory(categoryList.get(i).getCategoryId(),Long.valueOf(8)));
			categoryGoodsList.add(vo);
		}		
		request.setAttribute("categoryGoodsList", categoryGoodsList);
	}
	
	/**
	 * 查找商品列表by pageCategory
	 * @param categoryId
	 * @param showNum
	 * @return
	 */
	private List findGoodsByCategory(Long categoryId,Long showNum){
		List<TbGoodsInfo> goodsList = this.pageCategoryLogic.findGoodsByPageCategory(categoryId);
		return goodsList;
	}

	public SiteCategoryLogic getSiteCategoryLogic() {
		return siteCategoryLogic;
	}

	public void setSiteCategoryLogic(SiteCategoryLogic siteCategoryLogic) {
		this.siteCategoryLogic = siteCategoryLogic;
	}

	public PageCategoryLogic getPageCategoryLogic() {
		return pageCategoryLogic;
	}

	public void setPageCategoryLogic(PageCategoryLogic pageCategoryLogic) {
		this.pageCategoryLogic = pageCategoryLogic;
	}

	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}

	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}
	
	
}
