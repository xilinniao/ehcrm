package com.eh.shop.front.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.eh.base.dao.hibernate.Page;
import com.eh.shop.admin.logic.CustAddrLogic;
import com.eh.shop.admin.logic.GoodsQaLogic;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.admin.web.qry.GoodsQaQry;
import com.eh.shop.admin.web.qry.OrderQry;
import com.eh.shop.entity.TbCustAddr;
import com.eh.shop.entity.TbCustInfo;
import com.eh.shop.entity.TbGoodsQa;
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
	 * 客户地址
	 */
	CustAddrLogic custAddrLogic;
	/**
	 * 商品咨询
	 */
	GoodsQaLogic goodsQaLogic;
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
		return new ModelAndView("/jsp/shop/front/user/tuan_list");
	}
	
	/**
	 * 地址列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addressList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/user/address_list");
		CustInfo custInfo = super.getCustInfo(request);
		List addrList = custAddrLogic.findAddrListByCustId(custInfo.getCustId());
		mav.addObject("addrList", addrList);
		return mav;
	}
	
	/**
	 * 编辑地址
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editAddress(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		Long addrId = super.getLong(request, "addrId", false);
		CustInfo custInfo = super.getCustInfo(request);
		TbCustAddr addr = this.custAddrLogic.get(TbCustAddr.class, addrId);
		if(addr!=null&&addr.getCustId().longValue()==custInfo.getCustId().longValue()){
			ModelAndView mav =  new ModelAndView("/jsp/shop/front/user/edit_address");
			mav.addObject("addr", addr);
			return mav;
		}else{
			super.addErrors(request, "非法操作");
			ModelAndView mav = new ModelAndView(FRONT_ERROR_URL);
			return mav;
		}
	}
	
	public ModelAndView onEditAddress(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Long addrId = super.getLong(request, "addrId", false);
		CustInfo custInfo = super.getCustInfo(request);
		TbCustAddr addr = this.custAddrLogic.get(TbCustAddr.class, addrId);
		if(addr!=null&&addr.getCustId().longValue()==custInfo.getCustId().longValue()){
			super.bindObject(request, addr);
			addr.setUpdateTime(new Date());
			this.custAddrLogic.save(addr);
			ModelAndView mav = new ModelAndView(new RedirectView("user.xhtml?method=addressList&msg=ok"));
			return mav;
		}else{
			ModelAndView mav = new ModelAndView(FRONT_ERROR_URL);
			super.addErrors(request, "非法操作");
			return mav;
		}
	}
	
	/**
	 * 个人资料维护
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView profile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/user/profile");
		CustInfo custInfo = super.getCustInfo(request);
		TbCustInfo dbcust = this.custAddrLogic.get(TbCustInfo.class, custInfo.getCustId());
		mav.addObject("custInfo", dbcust);
		return mav;
	}
	
	/**
	 * 保存个人资料信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onProfile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo custInfo = super.getCustInfo(request);
		
		TbCustInfo dbcust = this.custAddrLogic.get(TbCustInfo.class, custInfo.getCustId());
		super.bindObject(request, dbcust);
		dbcust.setUpdateTime(new Date());
		this.custAddrLogic.save(dbcust);
		
		ModelAndView mav = new ModelAndView(new RedirectView("user.xhtml?method=profile&msg=ok"));
		return mav;
	}
	
	/**
	 * 咨询列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView qaList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/user/qa_list");
		CustInfo custInfo = super.getCustInfo(request);
		GoodsQaQry qry = new GoodsQaQry();
		qry.setCustId(custInfo.getCustId());
		Page qaList = this.goodsQaLogic.findPage(qry);
		mav.addObject("qaList", qaList);
		return mav;
	}
	
	/**
	 * 编辑咨询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editQa(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		Long qaId = super.getLong(request, "qaId", false);
		CustInfo custInfo = super.getCustInfo(request);
		TbGoodsQa qa = this.custAddrLogic.get(TbGoodsQa.class, qaId);
		if(qa!=null&&qa.getCustInfo().getCustId().longValue()==custInfo.getCustId().longValue()){
			ModelAndView mav =  new ModelAndView("/jsp/shop/front/user/edit_qa");
			mav.addObject("qa", qa);
			return mav;
		}else{
			super.addErrors(request, "非法操作");
			ModelAndView mav = new ModelAndView(FRONT_ERROR_URL);
			return mav;
		}
	}
	
	public ModelAndView onEditQa(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Long qaId = super.getLong(request, "qaId", false);
		CustInfo custInfo = super.getCustInfo(request);
		TbGoodsQa qa = this.custAddrLogic.get(TbGoodsQa.class, qaId);
		if(qa!=null&&qa.getCustInfo().getCustId().longValue()==custInfo.getCustId().longValue()){
			super.bindObject(request, qa);
			this.custAddrLogic.save(qa);
			ModelAndView mav = new ModelAndView(new RedirectView("user.xhtml?method=qaList&msg=ok"));
			return mav;
		}else{
			ModelAndView mav = new ModelAndView(FRONT_ERROR_URL);
			super.addErrors(request, "非法操作");
			return mav;
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

	public CustAddrLogic getCustAddrLogic() {
		return custAddrLogic;
	}

	public void setCustAddrLogic(CustAddrLogic custAddrLogic) {
		this.custAddrLogic = custAddrLogic;
	}

	public GoodsQaLogic getGoodsQaLogic() {
		return goodsQaLogic;
	}

	public void setGoodsQaLogic(GoodsQaLogic goodsQaLogic) {
		this.goodsQaLogic = goodsQaLogic;
	}
	
	
}
