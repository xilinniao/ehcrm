package com.eh.shop.admin.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.util.ObjectUtil;
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
	 * 3系统自动接收的订单
	 */
	public ModelAndView checkList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/checkList");
		
		OrderQry qry = null;
		String qryHex = super.getQryHex(request);
		
		if(StringUtils.isNotBlank(qryHex)){
			qry = (OrderQry)ObjectUtil.getObjectFromPara(qryHex);
		}else{
			qry = new OrderQry();
			super.bindObject(request, qry);	
			if(StringUtils.isBlank(qry.getOrderStatus())){
				qry.setOrderStatus("0,3");//正常或系统代为接收的订单
			}
		}
		qry.setShopId(userInfo.getShopInfo().getShopId());
		
		Page page = this.orderLogic.findOrderList(qry);
		mav.addObject("qry", qry);
		mav.addObject("page", page);
		return mav;
	}
	
	
	
	/**
	 * 确认订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView check(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/check");
		Long orderId = super.getLong(request, "orderId", false);
		TbOrderMain main = this.orderLogic.get(TbOrderMain.class, orderId);
		List goodsList = this.orderLogic.findOrderGoodsList(main);
		List flowList = this.orderLogic.findOrderFlowList(main);
		mav.addObject("goodsList", goodsList);
		mav.addObject("flowList", flowList);
		mav.addObject("order", main);
		mav.addObject("qryHex",super.getQryHex(request));
		return mav;
	}
	
	/**
	 * 确认订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onCheck(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long orderId = super.getLong(request, "orderId", false);
		TbOrderMain main = this.orderLogic.get(TbOrderMain.class, orderId);
		if(super.isYourShop(main.getShopInfo(), userInfo)){	
			if(main.isCanCheck()){
				main.setOrderStatus(Constants.ORDER_STATUS_SHOP_CHECK);
				TbOrderFlow flow = new TbOrderFlow();
				flow.setFlowTime(new Date());
				flow.setUserId(userInfo.getUser().getUserId());
				flow.setFlowNote(super.getString(request, "note", true));
				this.orderLogic.saveOrderAndFlow(main, flow);
			}else{
				super.addErrors(request, "该订单已经被确认，请勿重复确认！");
			}
		}else{
			super.addErrors(request, "该订单不是您的订单！");
			
		}
		
		ModelAndView mav = new ModelAndView(hasErrors(request)?ERROR_URL:SUCCESS_URL);
		super.addParam(request, "qryHex", super.getQryHex(request));
		mav.addObject("redirectUrl", " orders.xhtml?method=checkList");
		return mav;
	}
	
	/**
	 * 订单分四种状态
	 * 0 已下订单
	 * 3系统自动接收的订单
	 */
	public ModelAndView sendList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/sendList");
		
		OrderQry qry = null;
		String qryHex = super.getQryHex(request);
		
		if(StringUtils.isNotBlank(qryHex)){
			qry = (OrderQry)ObjectUtil.getObjectFromPara(qryHex);
		}else{
			qry = new OrderQry();
			super.bindObject(request, qry);	
			if(StringUtils.isBlank(qry.getOrderStatus())){
				qry.setOrderStatus("4");//正常或系统代为接收的订单
			}
		}
		qry.setShopId(userInfo.getShopInfo().getShopId());
		
		Page page = this.orderLogic.findOrderList(qry);
		mav.addObject("qry", qry);
		mav.addObject("page", page);
		return mav;
	}
	
	/**
	 * 确认订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView send(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/send");
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
	 * 确认订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onSend(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long orderId = super.getLong(request, "orderId", false);
		TbOrderMain main = this.orderLogic.get(TbOrderMain.class, orderId);
		if(super.isYourShop(main.getShopInfo(), userInfo)){	
			if(main.isCanSend()){
				main.setOrderStatus(Constants.ORDER_STATUS_SHOP_SEND);
				TbOrderFlow flow = new TbOrderFlow();
				flow.setFlowTime(new Date());
				flow.setUserId(userInfo.getUser().getUserId());
				String sendName = super.getString(request, "sendName", false);
				String sendTel = super.getString(request, "sendTel", false);
				String note = super.getString(request, "note", true);
				StringBuffer n = new StringBuffer(note);
				n.append(",送货人[");
				n.append(sendName);
				n.append("],联系电话[");
				n.append(sendTel);
				n.append("]");
				flow.setFlowNote(n.toString());
				this.orderLogic.saveOrderAndFlow(main, flow);
			}else{
				super.addErrors(request, "该订单已经被确认，请勿重复确认！");
			}
		}else{
			super.addErrors(request, "该订单不处于发货状态，不能进行发货！");
			
		}
		
		ModelAndView mav = new ModelAndView(hasErrors(request)?ERROR_URL:SUCCESS_URL);
		super.addParam(request, "qryHex", super.getQryHex(request));
		mav.addObject("redirectUrl", " orders.xhtml?method=sendList");
		return mav;
	}
	
	/**
	 * 订单分四种状态
	 * 0 已下订单
	 * 3系统自动接收的订单
	 */
	public ModelAndView finishList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/finishList");
		
		OrderQry qry = null;
		String qryHex = super.getQryHex(request);
		
		if(StringUtils.isNotBlank(qryHex)){
			qry = (OrderQry)ObjectUtil.getObjectFromPara(qryHex);
		}else{
			qry = new OrderQry();
			super.bindObject(request, qry);	
			if(StringUtils.isBlank(qry.getOrderStatus())){
				qry.setOrderStatus("5");
			}
		}
		qry.setShopId(userInfo.getShopInfo().getShopId());		
		Page page = this.orderLogic.findOrderList(qry);
		mav.addObject("qry", qry);
		mav.addObject("page", page);
		return mav;
	}
	
	/**
	 * 确认订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView finish(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/order/finish");
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
	 * 完成的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onFinish(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long orderId = super.getLong(request, "orderId", false);
		TbOrderMain main = this.orderLogic.get(TbOrderMain.class, orderId);
		if(super.isYourShop(main.getShopInfo(), userInfo)){	
			if(main.isCanFinish()){
				main.setOrderStatus(Constants.ORDER_STATUS_SHOP_FINISH);
				TbOrderFlow flow = new TbOrderFlow();
				flow.setFlowTime(new Date());
				flow.setUserId(userInfo.getUser().getUserId());
				flow.setFlowNote(super.getString(request, "note", true));
				this.orderLogic.saveOrderAndFlow(main, flow);
			}else{
				super.addErrors(request, "该订单已结束！");
			}
		}else{
			super.addErrors(request, "该订单不属于待完成，不能进行完成操作！");
			
		}
		
		ModelAndView mav = new ModelAndView(hasErrors(request)?ERROR_URL:SUCCESS_URL);
		super.addParam(request, "qryHex", super.getQryHex(request));
		mav.addObject("redirectUrl", " orders.xhtml?method=finishList");
		return mav;
	}
	
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
