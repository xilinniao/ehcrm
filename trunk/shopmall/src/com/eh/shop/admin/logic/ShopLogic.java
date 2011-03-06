/**
 * 
 */
package com.eh.shop.admin.logic;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbShopInfo;

/**
 * 商铺LOGIC
 * @author zhoucl
 *
 */
public interface ShopLogic extends IBaseLogic {
	/**
	 * 获取所拥有的店铺
	 * @param userId
	 * @return
	 */
	public TbShopInfo getUserShop(Long userId);	
}
