package com.eh.shop.front.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.cache.ShopInfo;
import com.eh.shop.front.logic.FrontCacheLogic;

public class ShopCtrl extends BaseFrontCtrl {
	FrontCacheLogic frontCacheLogic;
	GoodsLogic goodsLogic;
	/**
	 * 商铺首页
	 */
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shop/index");
		
		Long shopId = super.getLong(request, "shopId", false);
		ShopInfo shop = frontCacheLogic.findShopInfo(shopId, false);
		mav.addObject("shop", shop);
		GoodsInfoQry qry = new GoodsInfoQry();
		super.bindObject(request, qry);
		qry.setPageSize(20);
		Page page = goodsLogic.findFrontGoodsList(qry);
		List data = page.getResult();
		if(data!=null){
			List<GoodsShort> productList = new ArrayList();
			for (int i = 0, size = data.size(); i < size; i++) {
				productList.add(this.frontCacheLogic.findGoodsShort((Long)data.get(i),false));
			}
			mav.addObject("productList", productList);
		}
		mav.addObject("page", page);
		mav.addObject("qry", qry);
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

	public GoodsLogic getGoodsLogic() {
		return goodsLogic;
	}

	public void setGoodsLogic(GoodsLogic goodsLogic) {
		this.goodsLogic = goodsLogic;
	}


	
}
