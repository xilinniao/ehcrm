/**
 * 
 */
package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.front.vo.ShopRegVo;

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
	/**
	 * 店铺是否存在
	 * @param shopCode
	 * @return
	 */
	public boolean userExist(String userCode);
	/**
	 * 保存店铺
	 * @return
	 */
	public String saveCreateShopInfo(ShopRegVo reg); 
	/**
	 * 查找最近注册的店铺信息
	 * @return
	 */
	public List findLeastRegShop();
}
