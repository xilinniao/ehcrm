package com.eh.shop.admin.logic.impl;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.IndexCategoryLogic;
import com.eh.shop.admin.web.qry.ShopIndexCategoryQry;
import com.eh.shop.entity.TbIndexCategory;
import com.eh.shop.entity.TbSiteCategory;

public class IndexCategoryLogicImpl extends BaseLogic implements IndexCategoryLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ShopIndexCategoryInfoLogic#saveShopIndexCategoryInfo(com.eh.shop.entity.TbShopIndexCategory)
	 */
	public String saveIndexCategory(TbIndexCategory entity) {
		if(entity.getCategoryId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setCategoryId(null);
		}
		super.save(entity);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ShopIndexCategoryInfoLogic#deleteShopIndexCategoryInfo(com.eh.shop.entity.TbShopIndexCategory)
	 */
	public String deleteIndexCategory(TbIndexCategory entity) {
		int cnt = super.baseDao.count("select count(*) from TbGoodsInfo t where t.ShopIndexCategoryInfo = ? ", entity);
		if(cnt>0){
			return "发现该品牌下有"+cnt+"个商品，不能删除该品牌"; 
		}else{
			super.remove(entity);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ShopIndexCategoryInfoLogic#findShopIndexCategoryList(com.eh.shop.admin.web.qry.ShopIndexCategoryInfoQry)
	 */
	public Page findIndexCategoryList(ShopIndexCategoryQry qry) {
		Criteria criteria = baseDao.createCriteria(TbIndexCategory.class);
		CriteriaUtil.addFullLike(criteria, "categoryName", qry.getName());
		CriteriaUtil.addEq(criteria, "shopInfo.shopId", qry.getUserInfo().getShopInfo().getShopId());
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	public Long findMaxOrderNum(Long shopId) {		
		Long max = super.baseDao.findLong("select max(t.orderNum) from TbIndexCategory t where t.shopInfo.shopId = ? ", shopId);
		if(max==null){
			return Long.valueOf(1);
		}else{
			return max+1;
		}
	}
	
	
	
	
}