/**
 * 
 */
package com.eh.shop.front.web;

import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.util.Constants;
import com.eh.base.util.CookieUtils;
import com.eh.shop.admin.logic.CustInfoLogic;
import com.eh.shop.entity.TbCustInfo;
import com.eh.shop.front.vo.CustInfo;

/**
 * 登录和用户注册处理类
 */
public class LoginCtrl extends BaseFrontCtrl {
	CustInfoLogic custInfoLogic;
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
		//判断验证码是否正确
		HttpSession session = super.getSession(request);
	    Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
	    String authcode = super.getString(request, "authcode", false);
	    TbCustInfo custInfo = new TbCustInfo();
		super.bindObject(request, custInfo);
	    if(!captcha.isCorrect(StringUtils.trim(authcode))){
	    	super.addErrors(request, "验证码不正确，请重新输入验证码");
	    }else{			
			String result = this.custInfoLogic.saveRegInfo(custInfo);
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
	    }
		
		//是否存在ERROR
		if(super.hasErrors(request)){
			ModelAndView mav = new ModelAndView("/jsp/shop/front/cust_reg");//返回注册页面
			mav.addObject("custInfo", custInfo);
			return mav;
		}else{
			//模拟一次登陆			
			session.setAttribute(Constants.SESSION_NAME_FRONT, custInfo);		
			//写cookie资料
			Cookie loginMemberUsernameCookie = new Cookie(Constants.LOGIN_USERNAME_COOKIE_NAME_FRONT,URLEncoder.encode(custInfo.getCustCode(),"utf-8"));
			loginMemberUsernameCookie.setPath("/");
			response.addCookie(loginMemberUsernameCookie);
			
			return new ModelAndView("/jsp/shop/front/cust_reg_success");//返回成功页面
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
		String custCode = super.getString(request, "custCode", true);
		boolean isExist = this.custInfoLogic.custExists(custCode);
		super.renderText(response, !isExist);
		return null;
	}
	
	/**
	 * 客户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo custInfo = this.getCustInfo(request);
		if(custInfo!=null){
			//返回用户中心
			return new ModelAndView("redirect:/front/user.xhtml");
		}else{
			//
		}
		return new ModelAndView("/jsp/shop/front/login");
	}
	public ModelAndView onLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String custCode = super.getString(request, "loginname", false);
		String pwd = super.getString(request, "loginpwd", false);
		TbCustInfo ci = this.custInfoLogic.loginCheck(custCode, pwd);
		if(ci!=null){
			CustInfo cust = new CustInfo();
			cust.setCustId(ci.getCustId());
			cust.setCustCode(ci.getCustCode());
			cust.setCustName(ci.getCustName());
			cust.setLastLoginTime(ci.getLastLoginTime());
			//修改最后登录时间
			ci.setLastLoginTime(new Date());
			this.custInfoLogic.save(ci);
			HttpSession session = super.getSessionC(request);
			session.setAttribute(Constants.SESSION_NAME_FRONT, cust);			
			//写cookie资料
			Cookie loginMemberUsernameCookie = new Cookie(Constants.LOGIN_USERNAME_COOKIE_NAME_FRONT,URLEncoder.encode(cust.getCustCode(),"utf-8"));
			loginMemberUsernameCookie.setPath("/");
			response.addCookie(loginMemberUsernameCookie);
			super.renderJsonSuccess(response, "登录成功");
		}else{
			super.renderJsonError(response, "用户名或密码错误");
		}
		return null;
	}
	
	/**
	 * 注销登录，同时移除COOKIE
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onLogout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		super.getSessionC(request).removeAttribute(Constants.SESSION_NAME_FRONT);
		CookieUtils.addCookie(response, 0, Constants.LOGIN_USERNAME_COOKIE_NAME_FRONT, null);
		CookieUtils.addCookie(response, 0, Constants.AUTO_LOGIN_COOKIE_NAME_FRONT, null);
		super.renderJsonSuccess(response, "退出成功");
		return null;
	}
	
	/**
	 * 变更密码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView changePwd(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/user/change_pwd");
		return mav;
	}
	
	/**
	 * 变更密码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onChangePwd(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/user/change_pwd");
		CustInfo custInfo = super.getCustInfo(request);
		if(custInfo!=null){		
			String oldpwd = super.getString(request, "oldpwd", false);		
			TbCustInfo dbcust = this.custInfoLogic.loginCheck(custInfo.getCustCode(), oldpwd);
			if(dbcust==null){
				super.addErrors(request, "原密码不正确");
			}else{
				String newPwd = super.getString(request, "newpwd", false);
				dbcust.setCustPwd(newPwd);
				dbcust.setUpdateTime(new Date());
				super.addMessage(request, "密码修改成功");
				this.custInfoLogic.saveChangePwd(dbcust);
			}
			return mav;
		}else{
			super.referer = getContextPath(request)+"/front/login.xhtml?method=changePw";
			return super.gotoLogin(request);
		}
	}
	
	
	
	

	/**
	 * @return the custInfoLogic
	 */
	public CustInfoLogic getCustInfoLogic() {
		return custInfoLogic;
	}

	/**
	 * @param custInfoLogic the custInfoLogic to set
	 */
	public void setCustInfoLogic(CustInfoLogic custInfoLogic) {
		this.custInfoLogic = custInfoLogic;
	}
	
	
}
