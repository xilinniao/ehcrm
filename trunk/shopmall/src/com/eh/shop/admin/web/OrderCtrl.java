package com.eh.shop.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.admin.web.qry.OrderQry;

public class OrderCtrl extends BaseShopAdminCtrl {
	OrderLogic orderLogic = null;
	
	/**
	 * 
	 */
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/list");
		OrderQry qry = new OrderQry();
		super.bindObject(request, qry);
		Page page = this.orderLogic.findOrderList(qry);
		mav.addObject("qry", qry);
		mav.addObject("page", page);
		return mav;
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
