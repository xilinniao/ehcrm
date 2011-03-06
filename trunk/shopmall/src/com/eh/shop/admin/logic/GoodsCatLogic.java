package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbGoodsCategory;

public interface GoodsCatLogic extends IBaseLogic {
	/**
	 * 查找商品分类数据
	 * @param treeNo
	 * @return
	 */
	public List findGoodscatTree(String treeNo,Long shopId);
	/**
	 * 保存商品分类数据
	 * @param goodscat
	 * @return
	 */
	public Long saveGoodscatInfo(TbGoodsCategory goodscat);
	/**
	 * 删除商品分类资源
	 * @param goodscatId
	 * @return
	 */
	public String deleteGoodscatInfo(Long goodscatId);
}
