package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 用户中心
 * @author zhoucl
 *
 */
public class UserCtrl extends BaseFrontCtrl {
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
}
