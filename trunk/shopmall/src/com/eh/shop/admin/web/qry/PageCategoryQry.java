/**
 * 
 */
package com.eh.shop.admin.web.qry;

import com.eh.base.util.BaseQuery;

/**
 * @author zhoucl
 *
 */
public class PageCategoryQry extends BaseQuery {
	/**
	 * 分类ID
	 */
	Long categoryId;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
