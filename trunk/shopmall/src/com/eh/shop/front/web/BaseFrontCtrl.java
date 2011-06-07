package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.base.util.Constants;
import com.eh.shop.front.vo.CustInfo;
/**
 * 前台控制类
 *
 */
public class BaseFrontCtrl extends BaseCtrl {
	/**
	 * 前端错误URL
	 */
	public static final String FRONT_ERROR_URL = "/jsp/shop/front/common/error";
	/**
	 * 前端成功URL
	 */
	public static final String FRONT_SUCCESS_URL = "/jsp/shop/front/common/success";
	
	/**
	 * 参考页面
	 */
	public String referer;
	
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
		if(StringUtils.isBlank(referer)){
			referer = request.getHeader("Referer");
		}
		return new ModelAndView("redirect:/front/common/login.html?ref="+referer);
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