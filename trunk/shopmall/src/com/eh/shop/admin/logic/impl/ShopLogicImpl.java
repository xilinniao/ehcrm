/**
 * 
 */
package com.eh.shop.admin.logic.impl;

import java.util.List;

import com.eh.base.logic.BaseLogic;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.entity.TbShopInfo;

/**
 * 
 * 商铺LOGIC
 * 
 * @author zhoucl
 * 
 */
public class ShopLogicImpl extends BaseLogic implements ShopLogic {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eh.shop.admin.logic.ShopLogic#getUserShop(java.lang.Long)
	 */
	public TbShopInfo getUserShop(Long userId) {
		List shopList = super.baseDao.find(
				"from TbShopInfo t where t.admin.userId = ?", userId);
		if (shopList.size() > 0) {
			return (TbShopInfo) shopList.get(0);
		} else {
			return null;
		}
	}

}
