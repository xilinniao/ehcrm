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
import com.eh.shop.admin.logic.BrandInfoLogic;
import com.eh.shop.admin.logic.GoodsCategoryLogic;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbBrandInfo;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsInfoSub;
import com.eh.shop.entity.TbIndexCategory;
import com.eh.shop.entity.TbSiteCategory;

/**
 * 商品管理
 * 
 * @author zhoucl
 * 
 */
public class GoodsInfoCtrl extends BaseShopAdminCtrl {
	GoodsLogic goodsLogic;
	GoodsCategoryLogic goodsCategoryLogic;
	PageCategoryLogic pageCategoryLogic = null;
	BrandInfoLogic brandInfoLogic = null;

	/**
	 * 商品管理首页
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/index");
		return mav;
	}
	
	/**
	 * 商品类别
	 */
	public ModelAndView category(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/category");
		return mav;
	}
	
	/**
	 * 商品类别
	 */
	public ModelAndView middle(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/common/middle");
		return mav;
	}

	/**
	 * 商品列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goodsList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/list");
		GoodsInfoQry qry = new GoodsInfoQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		if (StringUtils.isBlank(qry.getTreeNo())&& qry.getCategoryId()!=null) {
			TbGoodsCategory category = this.goodsLogic.load(TbGoodsCategory.class, qry.getCategoryId());
			qry.setTreeNo(category.getTreeNo());
		}
		Page page = goodsLogic.findGoodsList(qry);
		mav.addObject("page",page);
		mav.addObject("qry", qry);
		return mav;
	}
	
	/**
	 * 商品列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goodsListForPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/page_category/goodsList");
		GoodsInfoQry qry = new GoodsInfoQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		if (StringUtils.isBlank(qry.getTreeNo())&& qry.getCategoryId()!=null) {
			TbSiteCategory category = this.goodsLogic.load(TbSiteCategory.class, qry.getCategoryId());
			qry.setTreeNo(category.getTreeNo());
		}
		Page page = goodsLogic.findGoodsListForPage(qry);
		mav.addObject("page",page);
		mav.addObject("qry", qry);
		return mav;
	}

	/**
	 * 新增商品信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/edit");
		TbGoodsInfo info = new TbGoodsInfo();
		info.setGoodsId(Constants.ADD_PK_ID);
		mav.addObject("info", info);
		
		//首页分类
		List pageCategoryList = pageCategoryLogic.findAllPageCategoryList(userInfo.getShopInfo().getShopId());
		mav.addObject("pageCategoryList", pageCategoryList);
		
		//所属分类
		List categoryList = this.goodsCategoryLogic.findShopCategory(userInfo.getShopInfo().getShopId());
		mav.addObject("categoryList", categoryList);
		
		//品牌列表
		List brandList = this.brandInfoLogic.findAllBrandListByShop(userInfo.getShopInfo().getShopId());
		mav.addObject("brandList", brandList);
		
		List subList = new ArrayList();
		TbGoodsInfoSub sub = new TbGoodsInfoSub();
		sub.setGoodsSubName("默认规格");
		subList.add(sub);
		mav.addObject("subList", subList);
		return mav;
	}

	/**
	 * 添加商品
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editGoods(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/edit");
		//判断商品分类是否添加，如果没有添加，则提示需要添加商品分类
		
		Long goodsId = super.getLong(request, "goodsId", false);
		//修改操作
		TbGoodsInfo info = this.goodsLogic.get(TbGoodsInfo.class, goodsId);
		if(info!=null){
			// 获取图片列表
			List imageList = this.goodsLogic.findImageList(goodsId);
			mav.addObject("imageList", imageList);
			
			//首页分类
			List pageCategoryList = pageCategoryLogic.findAllPageCategoryList(userInfo.getShopInfo().getShopId());
			mav.addObject("pageCategoryList", pageCategoryList);
			
			//所属分类
			List categoryList = this.goodsCategoryLogic.findShopCategory(userInfo.getShopInfo().getShopId());
			mav.addObject("categoryList", categoryList);
			
			//品牌列表
			List brandList = this.brandInfoLogic.findAllBrandListByShop(userInfo.getShopInfo().getShopId());
			mav.addObject("brandList", brandList);
			
			//子商品信息
			List subList = this.goodsLogic.findGoodSubList(goodsId);
			mav.addObject("subList", subList);
			
			mav.addObject("info", info);
			return mav;
		}else{
			//设置错误信息
			super.addErrors(request, "非法操作，没有找到指定的商品信息");
			return new ModelAndView(REDIRECT_URL);
		}
	}

	public ModelAndView onEditGoods(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodsId = super.getLong(request, "goodsId", false);
		Long categoryId = super.getLong(request, "categoryId", false);
		Long siteCategoryId = super.getLong(request, "siteCategoryId", true);//网站分类
		Long brandId = super.getLong(request, "brandId", true);//品牌
		Long pageCategoryId = super.getLong(request, "pageCategoryId", true);
		TbBrandInfo brandInfo = null;
		TbIndexCategory pageCategory = null;
		TbSiteCategory siteCategory = null;
		if(brandId!=null){
			brandInfo = this.goodsLogic.get(TbBrandInfo.class, brandId);
		}
		if(pageCategoryId!=null){
			pageCategory = this.goodsLogic.get(TbIndexCategory.class, pageCategoryId);
		}
		if(siteCategoryId!=null){
			siteCategory = this.goodsLogic.get(TbSiteCategory.class, siteCategoryId);
		}
		TbGoodsCategory category = this.goodsLogic.get(TbGoodsCategory.class,categoryId);
		
		String[] subId = super.getStrings(request, "sub_id", true);
		String[] subName = super.getStrings(request, "goodsSubName", true);//货号名称
		//String[] subNo = super.getStrings(request, "subNo", true);//货号
		String[] marketPrice = super.getStrings(request, "marketPrice", true);//市场价
		String[] discountPrice = super.getStrings(request, "discountPrice", true);//折扣价
		String[] leavesCount = super.getStrings(request, "leavesCount", true);//数量
		
		//图片信息
		Long[] imageIds = super.getLongs(request, "imagesId", true);		
		
		TbGoodsInfoSub[] subs = new TbGoodsInfoSub[subName.length];
		for(int i = 0, len = subName.length ; i < len ; i++){
			subs[i] = new TbGoodsInfoSub();
			subs[i].setMarketPrice(Double.parseDouble(marketPrice[i]));
			subs[i].setDiscountPrice(Double.parseDouble(discountPrice[i]));
			subs[i].setGoodsSubName(subName[i]);
			if(StringUtils.isNotBlank(subId[i])){
				subs[i].setGoodsSubId(Long.valueOf(subId[i]));
			}
			subs[i].setLeavesCount(Long.parseLong(leavesCount[i]));
		}
		
		if (goodsId.longValue() == Constants.ADD_PK_ID.longValue()) {
			// 新增操作
			TbGoodsInfo info = new TbGoodsInfo();
			super.bindObject(request, info);
			info.setCategory(category);
			info.setShopInfo(userInfo.getShopInfo());
			info.setBrandInfo(brandInfo);
			info.setIndexCategory(pageCategory);
			info.setCreateUser(userInfo.getUser().getUserId());
			info.setCreateTime(new Date());
			this.goodsLogic.saveGoodsInfo(info,siteCategory,subs,imageIds);
		}else{
			//修改操作
			TbGoodsInfo info = this.goodsLogic.get(TbGoodsInfo.class, goodsId);
			if(info!=null&&super.isYourShop(info.getShopInfo(), userInfo)){
				super.bindObject(request, info);
				info.setCategory(category);
				info.setBrandInfo(brandInfo);
				info.setIndexCategory(pageCategory);
				this.goodsLogic.saveGoodsInfo(info,siteCategory,subs,imageIds);
			}else{
				super.addErrors(request, "非法操作，没有找到指定的商品信息");
			}
		}
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", "goodsInfo.xhtml?method=goodsList");
		return mav;
	}

	/**
	 * 删除商品信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteGoods(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return null;
	}

	/**
	 * @return the goodsLogic
	 */
	public GoodsLogic getGoodsLogic() {
		return goodsLogic;
	}

	/**
	 * @param goodsLogic
	 *            the goodsLogic to set
	 */
	public void setGoodsLogic(GoodsLogic goodsLogic) {
		this.goodsLogic = goodsLogic;
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

	/**
	 * @return the brandInfoLogic
	 */
	public BrandInfoLogic getBrandInfoLogic() {
		return brandInfoLogic;
	}

	/**
	 * @param brandInfoLogic the brandInfoLogic to set
	 */
	public void setBrandInfoLogic(BrandInfoLogic brandInfoLogic) {
		this.brandInfoLogic = brandInfoLogic;
	}

	public GoodsCategoryLogic getGoodsCategoryLogic() {
		return goodsCategoryLogic;
	}

	public void setGoodsCategoryLogic(GoodsCategoryLogic goodsCategoryLogic) {
		this.goodsCategoryLogic = goodsCategoryLogic;
	}
	
	

}
