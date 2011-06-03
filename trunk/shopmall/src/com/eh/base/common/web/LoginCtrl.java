package com.eh.base.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.common.logic.LoginLogic;
import com.eh.base.controller.BaseCtrl;
import com.eh.base.entity.TbMenuInfo;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.exception.BusinessException;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.entity.TbShopInfo;
/**
 * 登录操作类
 * @author jcrm
 *
 */
public class LoginCtrl extends BaseCtrl {
	LoginLogic loginLogic;
	/**
	 * 商店LOGIC
	 */
	ShopLogic shopLogic;
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String userCode = getString(request, "userCode", false);
		String password = getString(request, "password", false);
		
		UserInfo userInfo = loginLogic.checkUser(userCode.toUpperCase(), password);
		if("OK".equals(userInfo.getCheckResult())){
			mav.setViewName("/jsp/admin/index");
			userInfo.setCheckResult(null);
			//获取菜单操作
			List menuList = this.loginLogic.findUserMenuList(userInfo.getUser().getUserId());
			this.setIsLeaf(menuList);
			
			//判断是否需要移除根节点
			/*boolean removeRoot = false;
			for(int i =0,size = menuList.size();i<size;i++){
				TbMenuInfo tmp = (TbMenuInfo)menuList.get(i);
				if(tmp.getTreeNo().length()==9){
					removeRoot = true;
				}
			}*/
			
			menuList.remove(0);
			
			StringBuffer treeXml = new StringBuffer("");
			TbMenuInfo rootMenu = (TbMenuInfo)menuList.get(0);
			treeXml.append("<ul class=\"sf-menu\">");
			makeMenu(menuList,rootMenu.getMenuId(), rootMenu.getMenuId(), treeXml, 1);
			treeXml.append("</ul>");
			userInfo.setMenuStr(treeXml.toString());
			//获取店铺对象
			TbShopInfo shopInfo = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
			userInfo.setShopInfo(shopInfo);
			getSession(request).setAttribute(Constants.SESSION_NAME,userInfo);
		}else{
			mav.setViewName("/index");
			mav.addObject("error", userInfo.getCheckResult());
		}
		return mav;
	}
	
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/index");
		request.getSession().invalidate();
		return mav;
	}
	
	private void setIsLeaf(List menuList){
		TbMenuInfo menu = null;
		for (int i = 0, len = menuList.size(); i < len; i++){
			menu = (TbMenuInfo)menuList.get(i);
			menu.setIsLeaf(hasChild(menuList, menu.getMenuId())?Long.valueOf(1):Long.valueOf(0));
		}
	}
	
	private boolean hasChild(List menuList,Long menuId){
		boolean result = true;
		TbMenuInfo menu = null;
		for (int i = 0, len = menuList.size(); i < len; i++){
			menu = (TbMenuInfo)menuList.get(i);
			if(menuId.longValue()==menu.getParent().getMenuId().longValue()){
				result=false;
				break;
			}
		}
		return result;
	}
	
	private int makeMenu(List menuList,Long menuId,Long rootMenuId,StringBuffer xml,int loopTimes)throws BusinessException{
		if(loopTimes>=1000){
			throw new BusinessException("菜单数据存在死循环，请调整菜单数据");
		}
		TbMenuInfo menu = null;
		for (int i = 0, len = menuList.size(); i < len; i++){
			menu = (TbMenuInfo)menuList.get(i);		
			if(menu.getMenuId().longValue()==rootMenuId.longValue()){
				continue;
			}
			if(menu.getParent().getMenuId().longValue()==menuId.longValue()){				
				xml.append("<li id=\"id_");
				xml.append(menu.getMenuId());
				xml.append("\">");
				
				if(!menu.isLeaf()){
					xml.append("<a>");
					xml.append(menu.getMenuName());
					xml.append("</a>\r\n");
				}else{
					xml.append("<a href=\"");
					xml.append(Constants.APP_PATH);
					xml.append(menu.getMenuUrl());
					xml.append("\" target=\"mainFrame\">");
					xml.append(menu.getMenuName());
					xml.append("</a>");
				}
				
				if(!menu.isLeaf()){
					xml.append("<ul>\r\n");
				}
				loopTimes = this.makeMenu(menuList, menu.getMenuId(), rootMenuId, xml, loopTimes);
				if(!menu.isLeaf()){
					xml.append("</ul>\r\n");
				}
				xml.append("</li>\r\n");
			}
		}		
		return loopTimes;
	}
	
	
	/**
	 * 首页上部
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView top(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/top");
		UserInfo userInfo = super.getUserInfo(request);
		return mav;
	}
	
	/**
	 * 首页主框架
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return null;
	}

	public LoginLogic getLoginLogic() {
		return loginLogic;
	}

	public void setLoginLogic(LoginLogic loginLogic) {
		this.loginLogic = loginLogic;
	}

	/**
	 * @return the shopLogic
	 */
	public ShopLogic getShopLogic() {
		return shopLogic;
	}

	/**
	 * @param shopLogic the shopLogic to set
	 */
	public void setShopLogic(ShopLogic shopLogic) {
		this.shopLogic = shopLogic;
	}
	
	
}
