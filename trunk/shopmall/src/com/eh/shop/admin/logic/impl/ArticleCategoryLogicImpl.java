package com.eh.shop.admin.logic.impl;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.ArticleCategoryLogic;
import com.eh.shop.admin.web.qry.ArticleCategoryQry;
import com.eh.shop.entity.TbArticleCategory;

public class ArticleCategoryLogicImpl extends BaseLogic implements ArticleCategoryLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ArticleCategoryInfoLogic#saveArticleCategoryInfo(com.eh.shop.entity.TbArticleCategory)
	 */
	public String saveArticleCategory(TbArticleCategory entity) {
		if(entity.getCategoryId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setCategoryId(null);
		}
		super.save(entity);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ArticleCategoryInfoLogic#deleteArticleCategoryInfo(com.eh.shop.entity.TbArticleCategory)
	 */
	public String deleteArticleCategory(TbArticleCategory entity) {
		int cnt = super.baseDao.count("select count(*) from TbGoodsInfo t where t.ArticleCategoryInfo = ? ", entity);
		if(cnt>0){
			return "发现该品牌下有"+cnt+"个文章，不能删除该文章"; 
		}else{
			super.remove(entity);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ArticleCategoryInfoLogic#findArticleCategoryList(com.eh.shop.admin.web.qry.ArticleCategoryInfoQry)
	 */
	public Page findArticleCategoryList(ArticleCategoryQry qry,Long shopId) {
		Criteria criteria = baseDao.createCriteria(TbArticleCategory.class);
		criteria.createAlias("shopInfo","shop");
		CriteriaUtil.addFullLike(criteria, "categoryName", qry.getCategoryName());		
		//店铺为必输条件		
		CriteriaUtil.addEq(criteria, "shop.shopId",shopId);
		CriteriaUtil.addOrder(criteria, "orderNum", CriteriaUtil.ASC);
		return baseDao.pagedQuery(criteria, qry.getDataTablesPageNo(), qry.getPageSize());
	}
	
	
}