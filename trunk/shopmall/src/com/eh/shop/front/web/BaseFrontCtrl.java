package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.eh.base.controller.BaseCtrl;
import com.eh.shop.front.vo.CustInfo;
/**
 * 前台控制类
 *
 */
public class BaseFrontCtrl extends BaseCtrl {
	protected HttpSession getCustSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return session;
	}

	public CustInfo getCustInfo(HttpServletRequest request){
		HttpSession session = this.getCustSession(request);
		return null;
	}
	
	
}