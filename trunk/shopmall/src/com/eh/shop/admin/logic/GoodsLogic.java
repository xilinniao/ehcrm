/**
 * 
 */
package com.eh.shop.admin.logic;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;

/**
 * @author zhoucl
 *
 */
public interface GoodsLogic extends IBaseLogic {
	/**
	 * 查找商品列表
	 * @param qry
	 * @return
	 */
	public Page findGoodsList(GoodsInfoQry qry);
}
