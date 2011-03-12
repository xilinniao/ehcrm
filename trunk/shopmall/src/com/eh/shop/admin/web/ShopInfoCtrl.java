/**
 * 
 */
package com.eh.shop.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.entity.TbShopInfo;

/**
 * 管理店铺信息
 * @author zhoucl
 *
 */
public class ShopInfoCtrl extends BaseCtrl {
	/**
	 * 商店LOGIC
	 */
	ShopLogic shopLogic;
	
	/**
	 * 修改店铺信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editShop(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/shop/editShop");
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		if(shop==null){
			mav = new ModelAndView(super.SHOW_MSG_JSP);
			mav.addObject(super.SHOW_MSG_ATTR, "你没有属于自己的店铺");
			return mav;
		}else{
			mav.addObject("shop", shop);
		}
		return mav;
	}
	
	/**
	 * 修改店铺信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onEditShop(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/editShop");
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		if(shop==null){
			mav = new ModelAndView(super.SHOW_MSG_JSP);
			mav.addObject(super.SHOW_MSG_ATTR, "你没有属于自己的店铺");
			return mav;
		}else{
			super.bindObject(request, shop);
			this.shopLogic.save(shop);
			mav.addObject(super.SHOW_MSG_ATTR, "保存成功");
		}
		return mav;
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
