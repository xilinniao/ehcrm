package com.eh.shop.admin.logic;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbGoodsQa;

/**
 *
 */
public interface GoodsQaLogic extends IBaseLogic {
	/**
	 * 保存商品问答信息
	 * @param entity
	 * @return
	 */
	public String saveGoodsQa(TbGoodsQa entity);
}