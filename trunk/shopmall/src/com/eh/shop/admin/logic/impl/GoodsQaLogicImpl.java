package com.eh.shop.admin.logic.impl;

import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.GoodsQaLogic;
import com.eh.shop.entity.TbGoodsQa;

public class GoodsQaLogicImpl extends BaseLogic implements GoodsQaLogic {
	/**
	 * 保存商品问答信息
	 */
	public String saveGoodsQa(TbGoodsQa entity) {
		if(entity.getRecId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setRecId(null);
		}
		super.save(entity);
		return null;
	}
}