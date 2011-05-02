package com.eh.shop.admin.logic.impl;

import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.BrandInfoLogic;
import com.eh.shop.admin.web.qry.BrandInfoQry;
import com.eh.shop.entity.TbBrandInfo;

public class BrandInfoLogicImpl extends BaseLogic implements BrandInfoLogic {
	

	public Long findMaxSortNum(Long shopId) {
		return super.baseDao.findLong("select max(t.orderNum) from TbBrandInfo t where t.shopInfo.shopId=?", shopId);
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.BrandInfoLogic#saveBrandInfo(com.eh.shop.entity.TbBrandInfo)
	 */
	public String saveBrandInfo(TbBrandInfo entity) {
		if(entity.getBrandId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setBrandId(null);
		}
		super.save(entity);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.BrandInfoLogic#deleteBrandInfo(com.eh.shop.entity.TbBrandInfo)
	 */
	public String deleteBrandInfo(TbBrandInfo entity) {
		int cnt = super.baseDao.count("select count(*) from TbGoodsInfo t where t.brandInfo = ? ", entity);
		if(cnt>0){
			return "发现该品牌下有"+cnt+"个商品，不能删除该品牌"; 
		}else{
			super.remove(entity);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.BrandInfoLogic#findBrandList(com.eh.shop.admin.web.qry.BrandInfoQry)
	 */
	public Page findBrandList(BrandInfoQry qry) {
		Criteria criteria = baseDao.createCriteria(TbBrandInfo.class);
		CriteriaUtil.addFullLike(criteria, "name", qry.getName());
		CriteriaUtil.addEq(criteria, "shopInfo.shopId", qry.getUserInfo().getShopInfo().getShopId());
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.BrandInfoLogic#findAllBrandList(java.lang.Long)
	 */
	public List findAllBrandListByShop(Long shopId) {
		return super.baseDao.find("from TbBrandInfo t where t.shopInfo.shopId=?", shopId);
	}
}
