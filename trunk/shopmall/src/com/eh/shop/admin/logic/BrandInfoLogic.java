/**
 * 
 */
package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.BrandInfoQry;
import com.eh.shop.entity.TbBrandInfo;

/**
 * @author zhoucl
 *
 */
public interface BrandInfoLogic extends IBaseLogic {
	public String saveBrandInfo(TbBrandInfo entity);
	/**
	 * 删除品牌信息
	 * @param entity
	 * @return
	 */
	public String deleteBrandInfo(TbBrandInfo entity);
	/**
	 * 查找品牌列表
	 * @param qry
	 * @return
	 */
	public Page findBrandList(BrandInfoQry qry);
	/**
	 * 查找所有品牌信息
	 * @param shopId
	 * @return
	 */
	public List findAllBrandListByShop(Long shopId);
	/**
	 * 根据店铺查找最大的排序号
	 * @param shopId
	 * @return
	 */
	public Long findMaxSortNum(Long shopId);
}
