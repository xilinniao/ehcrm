package com.eh.shop.admin.logic.impl;

import com.eh.base.logic.BaseLogic;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbOrderDetail;
import com.eh.shop.entity.TbOrderMain;

public class OrderLogicImpl extends BaseLogic implements OrderLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#addOrder(com.eh.shop.entity.TbOrderMain, java.lang.Long[], java.lang.Long[])
	 */
	public String addOrder(TbOrderMain main, Long[] productIds, Long[] cnt) {
		super.save(main);
		if(productIds!=null){
			for(int i = 0 , len = productIds.length;i < len; i++){				
				TbOrderDetail detail = new TbOrderDetail();
				detail.setOrder(main);
				detail.setGoodsCount(cnt[i]);
				TbGoodsInfo goods = this.load(TbGoodsInfo.class, productIds[i]);
				detail.setGoodsPrice(goods.getDiscountPrice());
				detail.setGoods(goods);
				//detail.setGoodsScore(goods.get)
				super.save(detail);
			}
		}
		//添加一条
		return null;
	}

}
