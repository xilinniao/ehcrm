/**
 * 
 */
package com.eh.shop.front.logic;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.front.cache.GoodsDetail;
import com.eh.shop.front.cache.GoodsShort;

/**
 * 前端缓存LOGIC
 * @author zhoucl
 *
 */
public interface FrontCacheLogic extends IBaseLogic {
	/**
	 * 查找商品简约信息
	 * @param goodsId
	 * @return
	 */
	public GoodsShort findGoodsShort(Long subGoodsId);
	/**
	 * 查找商品详细信息
	 * @param goodsId
	 * @return
	 */
	public GoodsDetail findGoodsDetail(Long subGoodsId);
}