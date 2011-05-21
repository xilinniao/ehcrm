/**
 * 
 */
package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 帮助中心
 */
public class HelpCtrl extends BaseFrontCtrl {
	/**
	 * 帮助中心主页
	 */
	@Override
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return super.index(request, response);
	}
	
	/**
	 * 主题
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView topic(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return super.index(request, response);
	}
}
