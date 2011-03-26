package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbShopInfo;

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
	/**
	 * 根据商店ID获取根分类
	 * @return
	 */
	public TbGoodsCategory getRootCategory(Long shopId);	
	/**
	 * 系统店铺使用
	 * 根据URL查询分类信息
	 */
	public List findCategoryListByUrl(String url);	
	/**
	 * 按树形编码查找类别信息
	 * @param treeNo
	 * @param shopId
	 * @return
	 */
	public List findCategoryListByTreeNo(String treeNo,Long shopId);
}
