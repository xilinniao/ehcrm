package com.eh.shop.admin.web;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseTreeCtrl;
import com.eh.base.util.Constants;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.GoodsCategoryLogic;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbPageGoodsRel;
import com.eh.shop.entity.TbShopInfo;

public class GoodsCategoryCtrl extends BaseTreeCtrl{
	GoodsCategoryLogic goodsCategoryLogic;
	/**
	 * 商店LOGIC
	 */
	ShopLogic shopLogic;
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_category/index");
		TbGoodsCategory rootCategory = this.goodsCategoryLogic.getRootCategory(userInfo.getShopInfo().getShopId());
		if(rootCategory==null){
			rootCategory = this.goodsCategoryLogic.saveRootCategory(userInfo.getShopInfo()); 
		}
		//查找顶层节点
		List categoryList = this.goodsCategoryLogic.findFirstLevelCategory(userInfo.getShopInfo().getShopId());
		mav.addObject("categoryList", categoryList);
		mav.addObject("root", rootCategory);
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		//设置ROOT根节点信息
		TbGoodsCategory rootGoodscat = this.goodsCategoryLogic.getRootCategory(userInfo.getShopInfo().getShopId());
		super.rootId = rootGoodscat.getCategoryId();
		super.rootTreeName = rootGoodscat.getCategoryName();
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		return goodsCategoryLogic.findGoodscatTree(rootGoodscat.getTreeNo(),shop.getShopId());
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editGoodscat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbGoodsCategory entity = goodsCategoryLogic.get(TbGoodsCategory.class, goodscatId);
		super.renderJson(response, FreeMarkerUtil.process("shop.admin.goodscat.entity.ftl", entity));
		return null;
	}
	
	public ModelAndView onEditGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		TbGoodsCategory entity = null;
		if(goodscatId.longValue()!=Long.valueOf(-99)){
			entity = goodsCategoryLogic.get(TbGoodsCategory.class, goodscatId);
		}else{
			entity = new TbGoodsCategory();
		}
		super.bindObject(request, entity);
		Long parentGoodscatId = super.getLong(request, "parentGoodscatId", false);
		TbGoodsCategory parentGoodscat = goodsCategoryLogic.load(TbGoodsCategory.class, parentGoodscatId);
		entity.setParent(parentGoodscat);
		entity.setShopInfo(shop);
		if(goodscatId.longValue()!=parentGoodscatId.longValue()){
			goodsCategoryLogic.saveGoodscatInfo(entity);
			super.renderText(response, "OK");
		}else{
			super.renderText(response, "上级分类选择不正确");
		}
		return null;
	}
	
	/**
	 * 选择商品分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		return new ModelAndView("/jsp/shop/admin/goods_category/tree");
	}
	
	/**
	 * 新增商品分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_category/add");
		List categoryList = this.goodsCategoryLogic.findFirstLevelCategory(userInfo.getShopInfo().getShopId());
		mav.addObject("categoryList", categoryList);
		return mav;
	}
	
	/**
	 * 删除商品分类资源
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodscatId = super.getLong(request, "categoryId", false);		
		String result = this.goodsCategoryLogic.deleteGoodscatInfo(goodscatId);
		super.renderText(response, result);
		return null;
	}


	/**
	 * @return the goodsCategoryLogic
	 */
	public GoodsCategoryLogic getGoodsCategoryLogic() {
		return goodsCategoryLogic;
	}

	/**
	 * @param goodsCategoryLogic the goodsCategoryLogic to set
	 */
	public void setGoodsCategoryLogic(GoodsCategoryLogic goodsCategoryLogic) {
		this.goodsCategoryLogic = goodsCategoryLogic;
	}

	/**
	 * @return the shopLogic
	 */
	public ShopLogic getShopLogic() {
		return shopLogic;
	}

	/**
	 * @param shopLogic the shopLogic to set
	 */
	public void setShopLogic(ShopLogic shopLogic) {
		this.shopLogic = shopLogic;
	}
}
