package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.base.util.Constants;
import com.eh.shop.front.vo.CustInfo;
/**
 * 前台控制类
 *
 */
public class BaseFrontCtrl extends BaseCtrl {
	protected HttpSession getSessionC(HttpServletRequest request){
		HttpSession session = request.getSession();
		return session;
	}
	
	protected CustInfo getCustInfo(HttpServletRequest request){
		HttpSession session = this.getSessionC(request);
		if(session!=null){
			return (CustInfo)session.getAttribute(Constants.SESSION_NAME_FRONT);
		}else{
			return null;
		}
	}
	
	protected ModelAndView gotoLogin(HttpServletRequest request){
		return new ModelAndView("redirect:/front/common/login.html");
	}
	
	/**
	 * 前台缓存
	 */
	private Cache frontCache;

	public Cache getFrontCache() {
		return frontCache;
	}

	public void setFrontCache(Cache frontCache) {
		this.frontCache = frontCache;
	}
}