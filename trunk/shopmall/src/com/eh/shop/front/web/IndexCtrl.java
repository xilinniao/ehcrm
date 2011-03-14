/**
 * 
 */
package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.eh.base.controller.BaseCtrl;

/**
 * 显示首页信息
 */
public class IndexCtrl extends BaseCtrl {
	/**
	 * 首页显示
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		/*FreeMarkerView view = new FreeMarkerView();
		view.setUrl("index.ftl");*/
		
		/*FreeMarkerView view = new FreeMarkerView();
		view.setUrl("index");*/
		return new ModelAndView("/jsp/shop/front/index");
	}	
}
