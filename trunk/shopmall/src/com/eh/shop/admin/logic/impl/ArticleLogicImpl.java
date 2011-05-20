package com.eh.shop.admin.logic.impl;

import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.ArticleLogic;
import com.eh.shop.admin.web.qry.ArticleQry;
import com.eh.shop.entity.TbArticleInfo;

public class ArticleLogicImpl extends BaseLogic implements ArticleLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ArticleInfoLogic#saveArticleInfo(com.eh.shop.entity.TbArticleInfo)
	 */
	public String saveArticle(TbArticleInfo entity) {
		if(entity.getArticleId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setArticleId(null);
		}
		super.save(entity);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ArticleInfoLogic#deleteArticleInfo(com.eh.shop.entity.TbArticleInfo)
	 */
	public String deleteArticle(TbArticleInfo entity) {
		int cnt = super.baseDao.count("select count(*) from TbGoodsInfo t where t.ArticleInfo = ? ", entity);
		if(cnt>0){
			return "发现该品牌下有"+cnt+"个商品，不能删除该品牌"; 
		}else{
			super.remove(entity);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ArticleInfoLogic#findArticleList(com.eh.shop.admin.web.qry.ArticleInfoQry)
	 */
	public Page findArticleList(ArticleQry qry) {
		Criteria criteria = baseDao.createCriteria(TbArticleInfo.class);
		CriteriaUtil.addFullLike(criteria, "title", qry.getTitle());
		return baseDao.pagedQuery(criteria, qry.getDataTablesPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.ArticleLogic#findCategoryList(java.lang.Long)
	 */
	public List findCategoryList() {
		return super.baseDao.find("from TbArticleCategory order by orderNum asc");
	}
	
}