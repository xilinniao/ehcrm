package com.eh.shop.admin.web;

import com.eh.base.controller.BaseCtrl;
import com.eh.base.vo.UserInfo;
import com.eh.shop.entity.TbShopInfo;

public class BaseShopAdminCtrl extends BaseCtrl {
	/**
	 * 判断是否是你所拥有的店铺
	 * 
	 * @param info
	 * @param userInfo
	 * @return
	 */
	protected boolean isYourShop(TbShopInfo info, UserInfo userInfo) {
		if (userInfo.getShopInfo() != null) {
			return info.getShopId().longValue() == userInfo.getShopInfo().getShopId().longValue();
		}else{
			return false;
		}
	}
}
