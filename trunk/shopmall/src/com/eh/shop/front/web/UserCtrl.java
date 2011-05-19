package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.admin.web.qry.OrderQry;
import com.eh.shop.front.vo.CustInfo;

/**
 * 用户中心
 * @author zhoucl
 *
 */
public class UserCtrl extends BaseFrontCtrl {
	/**
	 * 订单LOGIC
	 */
	OrderLogic orderLogic = null;
	/**
	 * 用户中心
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/user/user_index");
	}
	
	/**
	 * 订单列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView orderList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/user/order_list");
		CustInfo custInfo = super.getCustInfo(request);
		OrderQry qry = new OrderQry();
		super.bindObject(request, qry);
		//qry.setPageSize(20);
		qry.setCustId(custInfo.getCustId());
		Page page = this.orderLogic.findUserOrderList(qry);
		mav.addObject("page", page);
		return mav;
	}
	
	/**
	 * 团购
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView tuanList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/user/user_index");
	}
	

	/**
	 * @return the orderLogic
	 */
	public OrderLogic getOrderLogic() {
		return orderLogic;
	}

	/**
	 * @param orderLogic the orderLogic to set
	 */
	public void setOrderLogic(OrderLogic orderLogic) {
		this.orderLogic = orderLogic;
	}
}
