/**
 * 
 */
package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.shop.front.logic.FrontCacheLogic;

/**
 * 帮助中心
 */
public class HelpCtrl extends BaseFrontCtrl {
	FrontCacheLogic frontCacheLogic;
	
	/**
	 * 帮助中心主页
	 */
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/help/main");
		return mav;
	}
	
	/**
	 * 主题
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView topic(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String topic = super.getString(request, "topic", false);
		
		return super.index(request, response);
	}

	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}

	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}
	
	
}
