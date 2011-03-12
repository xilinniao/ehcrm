/**
 * 
 */
package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbGoodsInfo;

/**
 * @author zhoucl
 *
 */
public interface GoodsLogic extends IBaseLogic {
	/**
	 * 查找商品列表
	 * @param qry
	 * @return
	 */
	public Page findGoodsList(GoodsInfoQry qry);
	/**
	 * 保存商品信息
	 * @param info
	 * @return
	 */
	public String saveGoodsInfo(TbGoodsInfo info);
	/**
	 * 根据物品ID查询图片列表
	 * @param goodsId
	 * @return
	 */
	public List findImageList(Long goodsId);
}
