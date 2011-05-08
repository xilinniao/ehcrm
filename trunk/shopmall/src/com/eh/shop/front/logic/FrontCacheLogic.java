/**
 * 
 */
package com.eh.shop.front.logic;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.front.cache.GoodsDetail;
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.cache.ShopInfo;

/**
 * 前端缓存LOGIC
 * @author zhoucl
 *
 */
public interface FrontCacheLogic extends IBaseLogic {
	/**
	 * 查找商品简约信息
	 * @param subGoodsId 子商品ID
	 * @param reRead 是否重复读
	 * @return
	 */
	public GoodsShort findGoodsShort(Long subGoodsId,boolean reRead);
	/**
	 * 查找商品详细信息
	 * @param goodsId
	 * @return
	 */
	public GoodsDetail findGoodsDetail(Long subGoodsId,boolean reRead);
	/**
	 * 查找店铺信息
	 * @param shopId
	 * @return
	 */
	public ShopInfo findShopInfo(Long shopId,boolean reRead);
}