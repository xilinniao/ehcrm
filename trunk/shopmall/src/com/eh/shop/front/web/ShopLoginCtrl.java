/**
 * 
 */
package com.eh.shop.front.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.common.logic.LoginLogic;
import com.eh.base.entity.TbUserInfo;
import com.eh.base.util.Constants;
import com.eh.base.util.CryptUtil;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.admin.web.BaseShopAdminCtrl;
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.front.vo.ShopRegVo;

/**
 * 店铺登录和用户注册处理类
 */
public class ShopLoginCtrl extends BaseShopAdminCtrl {
	ShopLogic shopLogic;
	LoginLogic loginLogic;	
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
		if(captcha==null){
			super.addErrors(request, "验证码不正确，请重新输入验证码");
		}else if(!captcha.isCorrect(StringUtils.trim(authcode))){
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
			mav.addObject("reg", reg);
			return mav;
		}else{			
			ModelAndView mav = new ModelAndView("/jsp/shop/front/shop_reg_success");//返回成功页面
			mav.addObject("reg", reg);
			return mav;
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
	
	/**
	 * 客户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/admin/login");
	}
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String userCode = getString(request, "loginname", false);
		String password = getString(request, "loginpwd", false);
		
		UserInfo userInfo = loginLogic.checkUser(userCode.toUpperCase(), password);
		if("OK".equals(userInfo.getCheckResult())){
			mav.setViewName("/jsp/shop/admin/index");
			//获取店铺对象
			TbShopInfo shopInfo = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
			userInfo.setShopInfo(shopInfo);
			getSession(request).setAttribute(Constants.SESSION_NAME,userInfo);
			
		}else{
			mav.setViewName("/jsp/shop/admin/login");
			mav.addObject("error", userInfo.getCheckResult());
		}
		return mav;
	}
	
	/**
	 * 更改密码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView changepwd(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/admin/user/changepwd");
	}
	
	public ModelAndView onChangepwd(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		String oldPwd = super.getString(request, "oldPwd", false);
		
		UserInfo dbUser = loginLogic.checkUser(userInfo.getUser().getUserCode().toUpperCase(), oldPwd);
		if(!"OK".equals(dbUser.getCheckResult())){
			super.renderJsonError(response, "原密码不正确,请重新输入！");
		}else{
			String newPwd = super.getString(request, "newPwd", false);
			String userName = super.getString(request, "userName", false);
			TbUserInfo db = loginLogic.get(TbUserInfo.class, dbUser.getUser().getUserId());
			db.setUserName(userName);
			db.setLoginPwd(CryptUtil.md5(Constants.CRYPT_MD_PREFIX+newPwd));
			this.loginLogic.save(db);
			super.renderJsonSuccess(response, "密码修改成功！");
		}
		return null;
	}
	
	/**
	 * 顶部
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView top(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/top");
		return mav;
	}
	
	/**
	 * 菜单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView menu(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/menu");
		return mav;
	}
	/**
	 * 中间箭头
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView middle(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/admin/middle");
	}
	
	/**
	 * 主界面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/main");
		return mav;
	}
	/**
	 * 退出登录界面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onLogout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/logout");
		return mav;
	}	
	
	public ShopLogic getShopLogic() {
		return shopLogic;
	}
	public void setShopLogic(ShopLogic shopLogic) {
		this.shopLogic = shopLogic;
	}

	public LoginLogic getLoginLogic() {
		return loginLogic;
	}

	public void setLoginLogic(LoginLogic loginLogic) {
		this.loginLogic = loginLogic;
	}
	
	
	
	

	
	
}
