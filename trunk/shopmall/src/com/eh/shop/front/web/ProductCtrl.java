package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.shop.admin.logic.GoodsQaLogic;
import com.eh.shop.front.cache.GoodsDetail;
import com.eh.shop.front.cache.ShopInfo;
import com.eh.shop.front.logic.FrontCacheLogic;
import com.eh.shop.front.vo.CustInfo;

/**
 * 产品CTRL
 * @author zhoucl
 *
 */
public class ProductCtrl extends BaseFrontCtrl {
	FrontCacheLogic frontCacheLogic;
	/**
	 * 商品咨询
	 */
	GoodsQaLogic goodsQaLogic;
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shop/product");
		Long productId = super.getLong(request, "productId", true);
		GoodsDetail product =frontCacheLogic.findGoodsDetail(productId,false);
		ShopInfo shopInfo = frontCacheLogic.findShopInfo(product.getShopId(),false);
		mav.addObject("product", product);
		mav.addObject("shop", shopInfo);
		return mav;
	}
	
	/**
	 * 咨询信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addqa(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return null;
	}
	
	public ModelAndView onAddqa(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo cust = super.getCustInfo(request);
		Long goodsId = super.getLong(request, "goodsId", false);
		String question = super.getString(request, "question", false);
		String result = this.goodsQaLogic.addGoodsQa(cust, question, goodsId);
		super.renderJsonSuccess(response, "商品咨询信息保存成功！");
		return null;
	}
	

	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}

	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}

	public GoodsQaLogic getGoodsQaLogic() {
		return goodsQaLogic;
	}

	public void setGoodsQaLogic(GoodsQaLogic goodsQaLogic) {
		this.goodsQaLogic = goodsQaLogic;
	}
	
	
}