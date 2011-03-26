/**
 * 
 */
package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;

/**
 * @author zhoucl
 *
 */
public class OrderCtrl extends BaseCtrl {
	public ModelAndView shoppingcart(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/shopping_cart");
	}
	
	public ModelAndView checkout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/checkout");
	}
	
	/**
	 * checkout 操作
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView oncheckout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/checkout");
	}
	
	/**
	 * 订单详情
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView orderdetails(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/order_details");
	}
}
