package com.eh.shop.admin.logic.impl;

import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.admin.web.qry.PageCategoryQry;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;

public class PageCategoryLogicImpl extends BaseLogic implements PageCategoryLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.PageCategoryLogic#savePageCategory(com.eh.shop.entity.TbPageCategory)
	 */
	public String savePageCategory(TbPageCategory entity) {
		if(entity.getCategoryId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setCategoryId(null);
		}
		super.save(entity);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.PageCategoryLogic#deletePageCategory(com.eh.shop.entity.TbPageCategory)
	 */
	public String deletePageCategory(TbPageCategory entity) {
		/*int cnt = super.baseDao.count("select count(*) from TbPageCategory t where t.PageCategory = ? ", entity);
		if(cnt>0){
			return "发现该品牌下有"+cnt+"个商品，不能删除该品牌"; 
		}else{
			super.remove(entity);
			return null;
		}*/
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.PageCategoryLogic#findPageCategoryList(com.eh.shop.admin.web.qry.PageCategoryQry)
	 */
	public Page findPageCategoryList(PageCategoryQry qry) {
		Criteria criteria = baseDao.createCriteria(TbPageCategory.class);
		return baseDao.pagedQuery(criteria, qry.getDataTablesPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.PageCategoryLogic#findPageTypeList()
	 */
	public List findPageTypeList(Long shopId) {
		List resultList = super.baseDao.find("from TbPageType where shopInfo.shopId = ?",shopId);
		if(resultList.size()>0){
			return resultList;
		}else{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.PageCategoryLogic#findAllPageCategoryList()
	 */
	public List findAllPageCategoryList(Long shopId) {
		return super.baseDao.find("from TbPageCategory t where t.shopInfo.shopId = ?",shopId);
	}
	
	/**
	 * 根据ID查找页面分类
	 */
	public List<TbPageCategory> findPageCategoryByType(Long shopId,Long pageTypeId){
		return super.baseDao
				.find(
						"from TbPageCategory t where t.shopInfo.shopId = ? and t.pageType.typeId = ?",
						new Object[] { shopId, pageTypeId });
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.PageCategoryLogic#findGoodsByPageCategory(java.lang.Long)
	 */
	public List<TbGoodsInfo> findGoodsByPageCategory(Long categoryId) {
		return super.baseDao.find("select t.goodsInfo from TbPageGoodsRel t where t.pageCategory.categoryId = ? ", categoryId);
	}
	
	
}