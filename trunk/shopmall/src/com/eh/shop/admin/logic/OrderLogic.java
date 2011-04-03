package com.eh.shop.admin.logic;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbOrderMain;

/**
 * 订单类
 * @author zhoucl
 *
 */
public interface OrderLogic extends IBaseLogic {
	/**
	 * 
	 * @param shopId 商店ID
	 * @param custId 客户ID
	 * @param productIds 商品数组
	 * @param cnt 数量数组
	 * @param usesScore 使用积分
	 * @return
	 */
	public String addOrder(TbOrderMain main,Long[] productIds,Long[] cnt);
}
