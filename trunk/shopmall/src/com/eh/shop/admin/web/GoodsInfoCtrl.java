/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.Date;
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
import com.eh.shop.admin.logic.BrandInfoLogic;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbBrandInfo;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbSiteCategory;

/**
 * 商品管理
 * 
 * @author zhoucl
 * 
 */
public class GoodsInfoCtrl extends BaseShopAdminCtrl {
	GoodsLogic goodsLogic;
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
	public ModelAndView goodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/list");
		GoodsInfoQry qry = new GoodsInfoQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		if (StringUtils.isBlank(qry.getTreeNo())) {
			TbGoodsCategory category = this.goodsLogic.load(TbGoodsCategory.class, qry.getCategoryId());
			qry.setTreeNo(category.getTreeNo());
		}
		Page page = goodsLogic.findGoodsList(qry);
		mav.addObject("page",page);
		return mav;
	}

	/**
	 * 新增商品信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/edit");
		TbGoodsInfo info = new TbGoodsInfo();
		info.setGoodsId(Constants.ADD_PK_ID);
		mav.addObject("info", info);
		List pageCategoryList = pageCategoryLogic.findAllPageCategoryList(userInfo.getShopInfo().getShopId());
		mav.addObject("pageCategoryList", pageCategoryList);
		
		//品牌列表
		/*List brandList = this.brandInfoLogic.findAllBrandListByShop(userInfo.getShopInfo().getShopId());
		mav.addObject("brandList", brandList);*/
		return mav;
	}

	/**
	 * 添加商品
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/edit");
		Long goodsId = super.getLong(request, "goodsId", false);
		//修改操作
		TbGoodsInfo info = this.goodsLogic.get(TbGoodsInfo.class, goodsId);
		if(info!=null){
			// 获取图片列表
			List imageList = this.goodsLogic.findImageList(goodsId);
			mav.addObject("imageList", imageList);
			mav.addObject("info", info);
			List pageCategoryList = pageCategoryLogic.findAllPageCategoryList(userInfo.getShopInfo().getShopId());
			mav.addObject("pageCategoryList", pageCategoryList);
			return mav;
		}else{
			//设置错误信息
			super.addErrors(request, "非法操作，没有找到指定的商品信息");
			return new ModelAndView(REDIRECT_URL);
		}
	}

	public ModelAndView onEditGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodsId = super.getLong(request, "goodsId", false);
		Long categoryId = super.getLong(request, "categoryId", false);
		Long siteCategoryId = super.getLong(request, "siteCategoryId", true);//网站分类
		Long brandId = super.getLong(request, "brandId", true);//品牌
		Long pageCategoryId = super.getLong(request, "pageCategoryId", true);
		TbBrandInfo brandInfo = null;
		TbPageCategory pageCategory = null;
		TbSiteCategory siteCategory = null;
		if(brandId!=null){
			brandInfo = this.goodsLogic.get(TbBrandInfo.class, brandId);
		}
		if(pageCategoryId!=null){
			pageCategory = this.goodsLogic.get(TbPageCategory.class, pageCategoryId);
		}
		if(siteCategoryId!=null){
			siteCategory = this.goodsLogic.get(TbSiteCategory.class, siteCategoryId);
		}
		TbGoodsCategory category = this.goodsLogic.get(TbGoodsCategory.class,categoryId);
		if (goodsId.longValue() == Constants.ADD_PK_ID.longValue()) {
			// 新增操作
			TbGoodsInfo info = new TbGoodsInfo();
			super.bindObject(request, info);
			info.setCategory(category);
			info.setShopInfo(userInfo.getShopInfo());
			info.setBrandInfo(brandInfo);
			info.setPageCategory(pageCategory);
			info.setCreateUser(userInfo.getUser().getUserId());
			info.setCreateTime(new Date());
			this.goodsLogic.saveGoodsInfo(info,siteCategory);
		}else{
			//修改操作
			TbGoodsInfo info = this.goodsLogic.get(TbGoodsInfo.class, goodsId);
			if(info!=null&&super.isYourShop(info.getShopInfo(), userInfo)){
				super.bindObject(request, info);
				info.setCategory(category);
				info.setBrandInfo(brandInfo);
				info.setPageCategory(pageCategory);
				this.goodsLogic.saveGoodsInfo(info,siteCategory);
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
	public ModelAndView deleteGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
	
	

}
