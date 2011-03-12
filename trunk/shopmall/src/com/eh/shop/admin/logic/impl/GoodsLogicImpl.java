/**
 * 
 */
package com.eh.shop.admin.logic.impl;

import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
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
		return baseDao.pagedQuery(criteria, qry.getDataTablesPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#saveGoodsInfo(com.eh.shop.entity.TbGoodsInfo)
	 */
	public String saveGoodsInfo(TbGoodsInfo info) {
		if(info.getGoodsId().longValue()==Constants.ADD_PK_ID.longValue()){
			info.setGoodsId(null);
			super.save(info);
		}else{
			super.save(info);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#findImageList(java.lang.Long)
	 */
	public List findImageList(Long goodsId) {
		return super.baseDao.find("select r.attachment from TbGoodsAttach r where r.goodsInfo.goodsId = ?", goodsId);
	}
	
	
}
