package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbShopInfo;

public interface GoodsCategoryLogic extends IBaseLogic {
	/**
	 * 查找商品分类数据
	 * @param treeNo
	 * @return
	 */
	public List findGoodscatTree(String treeNo,Long shopId);
	/**
	 * 查找第一层分类
	 * @param shopId
	 * @return
	 */
	public List findFirstLevelCategory(Long shopId);
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
	 * 创建顶层分类
	 * @param shopInfo
	 * @return
	 */
	public TbGoodsCategory saveRootCategory(TbShopInfo shopInfo);
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
	/**
	 * 按上级分类ID查找分类列表
	 * @param parentId
	 * @param shopId
	 * @return
	 */
	public List findCategoryListByParentId(Long parentId,Long shopId);
	/**
	 * 查找商店分类信息
	 * @param shopId
	 * @return
	 */
	public List findShopCategory(Long shopId);
}
