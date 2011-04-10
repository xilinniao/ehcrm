package com.eh.shop.admin.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.admin.web.qry.OrderQry;
import com.eh.shop.entity.TbOrderFlow;
import com.eh.shop.entity.TbOrderMain;

public class OrderCtrl extends BaseShopAdminCtrl {
	OrderLogic orderLogic = null;
	
	/**
	 * 订单分四种状态
	 * 0 已下订单
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
	 * 处理该订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/edit");
		Long orderId = super.getLong(request, "orderId", false);
		TbOrderMain main = this.orderLogic.get(TbOrderMain.class, orderId);
		List goodsList = this.orderLogic.findOrderGoodsList(main);
		List flowList = this.orderLogic.findOrderFlowList(main);
		mav.addObject("goodsList", goodsList);
		mav.addObject("flowList", flowList);
		mav.addObject("order", main);
		return mav;
	}
	
	/**
	 * 店铺取消订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onCancel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long orderId = super.getLong(request, "orderId", false);
		TbOrderMain main = this.orderLogic.get(TbOrderMain.class, orderId);
		if(super.isYourShop(main.getShopInfo(),userInfo)){
			String reason = super.getString(request, "reason", false);
			main.setOrderStatus(Constants.ORDER_STATUS_CANCEL_SHOP);
			TbOrderFlow flow = new TbOrderFlow();
			flow.setFlowTime(new Date());
			flow.setUserId(userInfo.getUser().getUserId());
			flow.setFlowNote("店铺主动取消订单，取消原因："+reason);
			flow.setOrder(main);
			this.orderLogic.saveOrderAndFlow(main, flow);			
			ModelAndView mav = new ModelAndView(SUCCESS_URL);
			mav.addObject("redirectUrl", "orders.xhtml?method=list");
			return mav;
		}else{
			super.addErrors(request, "非法操作，没有找到指定的商品信息");
			return new ModelAndView(REDIRECT_URL);
		}
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
