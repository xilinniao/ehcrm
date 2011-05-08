package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbSiteCategory;
import com.eh.shop.front.web.qry.ProductQry;

public interface SiteCategoryLogic extends IBaseLogic {
	/**
	 * 查找商品分类数据
	 * @param treeNo
	 * @return
	 */
	public List findSiteCategoryTree(String treeNo);
	/**
	 * 保存商品分类数据
	 * @param goodscat
	 * @return
	 */
	public Long saveSiteCategory(TbSiteCategory goodscat);
	/**
	 * 删除商品分类资源
	 * @param goodscatId
	 * @return
	 */
	public String deleteSiteCategory(Long goodscatId);
	/**
	 * 根据商店ID获取根分类
	 * @return
	 */
	public TbSiteCategory getRootCategory();	
	/**
	 * 系统店铺使用
	 * 根据URL查询分类信息
	 */
	public List findCategoryListByUrl(String url);	
	/**
	 * 按树形编码查找类别信息
	 * @param treeNo
	 * @return
	 */
	public List findCategoryListByTreeNo(String treeNo);
	/**
	 * 按上级分类ID查找分类列表
	 * @param parentId
	 * @return
	 */
	public List findCategoryListByParentId(Long parentId);
	/**
	 * 前台查找商品列表信息
	 * @param qry
	 * @return
	 */
	public Page findFrontGoodsList(ProductQry qry);
}
