package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.shop.front.cache.GoodsDetail;
import com.eh.shop.front.cache.ShopInfo;
import com.eh.shop.front.logic.FrontCacheLogic;

/**
 * 产品CTRL
 * @author zhoucl
 *
 */
public class ProductCtrl extends BaseFrontCtrl {
	FrontCacheLogic frontCacheLogic;
	
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/product");
		Long productId = super.getLong(request, "productId", true);
		GoodsDetail product =frontCacheLogic.findGoodsDetail(productId,false);
		ShopInfo shopInfo = frontCacheLogic.findShopInfo(product.getShopId(),false);
		mav.addObject("product", product);
		mav.addObject("shopInfo", shopInfo);
		return mav;
	}

	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}

	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}
	
	
}