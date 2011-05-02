/**
 * 
 */
package com.eh.shop.admin.logic;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.ShopIndexCategoryQry;
import com.eh.shop.entity.TbIndexCategory;
import com.eh.shop.entity.TbSiteCategory;

/**
 *
 */
public interface IndexCategoryLogic extends IBaseLogic {
	/**
	 * 保存店铺分页信息
	 * @param entity
	 * @return
	 */
	public String saveIndexCategory(TbIndexCategory entity);
	/**
	 * 删除分页信息
	 * @param entity
	 * @return
	 */
	public String deleteIndexCategory(TbIndexCategory entity);
	/**
	 * 查找分页信息
	 * @param qry
	 * @return
	 */
	public Page findIndexCategoryList(ShopIndexCategoryQry qry);
	/**
	 * 查找最大排序号
	 * @param siteCategory
	 * @return
	 */
	public Long findMaxOrderNum(Long shopId);
}
