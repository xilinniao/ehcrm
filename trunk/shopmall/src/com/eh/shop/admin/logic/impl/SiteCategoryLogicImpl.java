package com.eh.shop.admin.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.entity.TreeVo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsCategoryRel;
import com.eh.shop.entity.TbSiteCategory;
import com.eh.shop.front.web.qry.ProductQry;

public class SiteCategoryLogicImpl extends BaseLogic implements SiteCategoryLogic {
	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCatLogic#getRootCategory(java.lang.Long)
	 */
	public TbSiteCategory getRootCategory() {
		List cats = super.baseDao.find("from TbSiteCategory t order by t.treeNo asc ");
		return (TbSiteCategory)cats.get(0);
	}

	public List<TreeVo> findSiteCategoryTree(String treeNo) {
		List tmpList = super.baseDao.find("from TbSiteCategory t where t.treeNo like ? order by t.treeNo ",new Object[]{treeNo+"%"});
		List goodscatList = new ArrayList();
		for(int i = 0,len = tmpList.size();i<len;i++){
			TbSiteCategory goodscatInfo = (TbSiteCategory)tmpList.get(i);
			TreeVo vo = new TreeVo();
			vo.setTreeId(goodscatInfo.getCategoryId());
			vo.setParentId(goodscatInfo.getParent()!=null?goodscatInfo.getParent().getCategoryId():null);
			vo.setTreeName(goodscatInfo.getCategoryName());
			vo.setTreeNo(goodscatInfo.getTreeNo());
			goodscatList.add(vo);
		}
		return goodscatList;
	}

	public Long saveSiteCategory(TbSiteCategory goodscat) {
		if(goodscat.getCategoryId().longValue()==Long.valueOf(-99)){
			goodscat.setCategoryId(null);
			goodscat.setDataStatus(Constants.YES);
			super.save(goodscat);
			loopGoodscat(goodscat.getParent().getCategoryId(),goodscat.getParent().getTreeNo());
		}else{
			super.save(goodscat);
			loopGoodscat(goodscat.getParent().getCategoryId(),goodscat.getParent().getTreeNo());
		}
		return goodscat.getCategoryId();
	}
	
	private void loopGoodscat(Long pid,String treeNo){
		List childs = super.baseDao.find("from TbSiteCategory t where t.parent.categoryId = ? order by t.orderNum asc", pid);
		String myTreeNo = "";
		TbSiteCategory goodscat = null;
		for(int i = 0,len = childs.size();i<len;i++){
			goodscat = (TbSiteCategory)childs.get(i);
			myTreeNo = treeNo+String.valueOf(100+i);
			goodscat.setTreeNo(myTreeNo);
			super.save(goodscat);
			loopGoodscat(goodscat.getCategoryId(),goodscat.getTreeNo());
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.base.admin.logic.GoodscatLogic#deleteGoodscatInfo(java.lang.Long)
	 */
	public String deleteSiteCategory(Long goodscatId) {
		TbSiteCategory info = super.load(TbSiteCategory.class, goodscatId);
		int cnt = super.baseDao.count("select count(*) from TbSiteCategory t where t.parent = ? ", info) ;
		if(cnt==0){
			super.remove(info);
			return "OK";
		}else{
			return "EER01";
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCatLogic#findCategoryListByUrl(java.lang.String)
	 */
	public List findCategoryListByUrl(String url) {
		List categoryList = super.baseDao.find("from TbSiteCategory t where t.categoryUrl = ? and t.shopInfo.shopId = ? ", new Object[]{url,Constants.SYSTEM_SHOP});
		if(categoryList.size()==1){
			TbSiteCategory category = (TbSiteCategory)categoryList.get(0);
			return super.baseDao.find("from TbSiteCategory t where t.parent.categoryId = ? and t.shopInfo.shopId = ?", new Object[]{
					category.getCategoryId(),
					Constants.SYSTEM_SHOP
			});
		}else{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCatLogic#findCategoryListByTreeNo(java.lang.String, java.lang.Long)
	 */
	public List findCategoryListByTreeNo(String treeNo) {
		return super.baseDao
				.find(
						"from TbSiteCategory t where t.treeNo like ?",
						new Object[] { treeNo+"%" });
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCatLogic#findCategoryListByParentId(java.lang.Long, java.lang.Long)
	 */
	public List findCategoryListByParentId(Long parentId) {
		return super.baseDao
				.find(
						"from TbSiteCategory t where t.parent.categoryId = ? order by treeNo asc ",
						new Object[] { parentId });
	}

	public Page findFrontGoodsList(ProductQry qry) {
		Criteria criteria = super.baseDao.createCriteria(TbGoodsCategoryRel.class);
		CriteriaUtil.addEq(criteria, "categoryId", qry.getCategoryId());		
		CriteriaUtil.addOrder(criteria, "orderNum", CriteriaUtil.ASC);
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
	
}
