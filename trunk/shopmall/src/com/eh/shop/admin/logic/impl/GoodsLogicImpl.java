/**
 * 
 */
package com.eh.shop.admin.logic.impl;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbGoodsInfo;

/**
 * @author zhoucl
 *
 */
public class GoodsLogicImpl extends BaseLogic implements GoodsLogic {
	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#findGoodsList(com.eh.shop.admin.web.qry.GoodsInfoQry)
	 */
	public Page findGoodsList(GoodsInfoQry qry) {
		Criteria criteria = baseDao.createCriteria(TbGoodsInfo.class);
		criteria.createAlias("category","c");
		criteria.createAlias("shopInfo", "s");
		//加上商店的判断
		CriteriaUtil.addEq(criteria, "s.shopId", qry.getUserInfo().getShopInfo().getShopId());
		CriteriaUtil.addRightLike(criteria, "c.treeNo", qry.getTreeNo());
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
}
