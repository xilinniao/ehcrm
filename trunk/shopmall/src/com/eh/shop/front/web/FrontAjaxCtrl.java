/**
 * 
 */
package com.eh.shop.front.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.base.util.VelocityUtils;
import com.eh.shop.admin.logic.GoodsLogic;

/**
 * 公共AJAX处理函数
 *
 */
public class FrontAjaxCtrl extends BaseCtrl {
	GoodsLogic goodsLogic;
	
	public ModelAndView ajaxProduct(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String productId = super.getString(request, "productId", true);
		List productList = goodsLogic.findGoodsForPrice(productId);
		Map data = new HashMap();
		data.put("productList", productList);
		renderJson(response, VelocityUtils.render("shop-front-goods-list",data));
		//renderJson(response,JSONArray.fromObject(productList).toString());
		return null;
	}
	
	/**
	 * 判断用户名是否已经注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView ajaxChkUserExist(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return null;
	}

	/**
	 * @return the goodsLogic
	 */
	public GoodsLogic getGoodsLogic() {
		return goodsLogic;
	}

	/**
	 * @param goodsLogic the goodsLogic to set
	 */
	public void setGoodsLogic(GoodsLogic goodsLogic) {
		this.goodsLogic = goodsLogic;
	}
	
	
}
