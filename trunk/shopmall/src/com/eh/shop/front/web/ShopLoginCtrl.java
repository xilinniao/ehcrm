/**
 * 
 */
package com.eh.shop.front.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.front.vo.ShopRegVo;

/**
 * 店铺登录和用户注册处理类
 */
public class ShopLoginCtrl extends BaseFrontCtrl {
	ShopLogic shopLogic;
	/**
	 * 客户注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView shopreg(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		return new ModelAndView("/jsp/shop/front/shop_reg");
	}
	
	public ModelAndView onShopreg(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//判断验证码是否正确
		HttpSession session = super.getSession(request);
	    Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
	    String authcode = super.getString(request, "authcode", false);
	    ShopRegVo reg = new ShopRegVo();
		super.bindObject(request, reg);
	    if(!captcha.isCorrect(StringUtils.trim(authcode))){
	    	super.addErrors(request, "验证码不正确，请重新输入验证码");
	    }else{			
			String result = this.shopLogic.saveCreateShopInfo(reg);
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
	    }
		
		//是否存在ERROR
		if(super.hasErrors(request)){
			ModelAndView mav = new ModelAndView("/jsp/shop/front/shop_reg");//返回注册页面
			mav.addObject("custInfo", reg);
			return mav;
		}else{			
			return new ModelAndView("/jsp/shop/front/shop_reg_success");//返回成功页面
		}
	}
	
	/**
	 * 判断用户是否存在
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView checkUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String userCode = super.getString(request, "userCode", true);
		boolean isExist = this.shopLogic.userExist(userCode);
		super.renderText(response, !isExist);
		return null;
	}
	
	public ShopLogic getShopLogic() {
		return shopLogic;
	}
	public void setShopLogic(ShopLogic shopLogic) {
		this.shopLogic = shopLogic;
	}
	
	
	
	

	
	
}
