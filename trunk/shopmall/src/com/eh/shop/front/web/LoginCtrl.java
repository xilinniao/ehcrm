/**
 * 
 */
package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.shop.entity.TbCustInfo;

/**
 * 登录和用户注册处理类
 */
public class LoginCtrl extends BaseCtrl {
	/**
	 * 客户注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView custreg(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		return new ModelAndView("/jsp/shop/front/cust_reg");
	}
	
	public ModelAndView onCustreg(HttpServletRequest request,HttpServletResponse response) throws Exception {
		TbCustInfo custInfo = new TbCustInfo();
		super.bindObject(request, custInfo);		
		return new ModelAndView("/jsp/shop/front/cust_reg_success");
	}
	
	/**
	 * 客户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		return new ModelAndView("/jsp/shop/front/login");
	}
	public ModelAndView onLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return null;
	}
}
