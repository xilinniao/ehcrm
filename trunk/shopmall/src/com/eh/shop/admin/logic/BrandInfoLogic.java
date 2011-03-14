/**
 * 
 */
package com.eh.shop.admin.logic;

import com.eh.base.logic.IBaseLogic;
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
}
