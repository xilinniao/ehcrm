package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.shop.front.cache.ShopInfo;
import com.eh.shop.front.logic.FrontCacheLogic;

public class ShopCtrl extends BaseFrontCtrl {
	FrontCacheLogic frontCacheLogic;
	/**
	 * 商铺首页
	 */
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shop/index");
		
		Long shopId = super.getLong(request, "shopId", false);
		ShopInfo shop = frontCacheLogic.findShopInfo(shopId, false);
		mav.addObject("shop", shop);
		
		return mav;
	}
	
	/**
	 * 店铺介绍
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView introduce(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shop/introduce");
		
		return mav;
	}
	
	/**
	 * 信誉评价
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView credit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shop/credit");
		return mav;
	}
	
	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}
	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}
	
	
}
