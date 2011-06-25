package com.eh.shop.admin.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.eh.base.entity.TreeVo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.GoodsCategoryLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbShopInfo;

public class GoodsCategoryLogicImpl extends BaseLogic implements GoodsCategoryLogic {
	
	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCatLogic#getRootCategory(java.lang.Long)
	 */
	public TbGoodsCategory getRootCategory(Long shopId) {
		List cats = super.baseDao.find("from TbGoodsCategory t where t.parent is null and t.shopInfo.shopId= ? ",shopId);
		if(cats.size()==0){
			return null;
		}else{
			return (TbGoodsCategory)cats.get(0);
		}
	}
	
	public TbGoodsCategory saveRootCategory(TbShopInfo shopInfo){
		TbGoodsCategory root = new TbGoodsCategory();
		root.setCategoryName("顶层分类");
		root.setShopInfo(shopInfo);
		root.setCategoryLevel(Long.valueOf(0));
		root.setIsLeaf(Constants.NO);
		root.setDataStatus(Constants.YES);
		root.setTreeNo("100");
		root.setOrderNum(Long.valueOf(0));
		super.save(root);
		return root;
	}
	
	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCategoryLogic#findFirstLevelCategory(java.lang.Long)
	 */
	public List findFirstLevelCategory(Long shopId) {
		TbGoodsCategory rootCategory = this.getRootCategory(shopId);
		return super.baseDao
				.find(
						"from TbGoodsCategory t where t.categoryId = ? or t.parent = ? order by t.treeNo asc",
						new Object[] { rootCategory.getCategoryId(),
								rootCategory });
	}

	public List<TreeVo> findGoodscatTree(String treeNo,Long shopId) {
		List tmpList = super.baseDao.find("from TbGoodsCategory t where t.treeNo like ? and t.shopInfo.shopId = ? order by t.treeNo ",new Object[]{treeNo+"%",shopId});
		List goodscatList = new ArrayList();
		for(int i = 0,len = tmpList.size();i<len;i++){
			TbGoodsCategory goodscatInfo = (TbGoodsCategory)tmpList.get(i);
			TreeVo vo = new TreeVo();
			vo.setTreeId(goodscatInfo.getCategoryId());
			vo.setParentId(goodscatInfo.getParent()!=null?goodscatInfo.getParent().getCategoryId():null);
			vo.setTreeName(goodscatInfo.getCategoryName());
			vo.setTreeNo(goodscatInfo.getTreeNo());
			goodscatList.add(vo);
		}
		return goodscatList;
	}

	public Long saveGoodscatInfo(TbGoodsCategory goodscat) {
		if(goodscat.getCategoryId().longValue()==Long.valueOf(-99)){
			goodscat.setCategoryId(null);
			goodscat.setDataStatus(Constants.YES);
			super.save(goodscat);
			loopGoodscat(goodscat.getParent(),goodscat.getParent().getTreeNo());
		}else{
			super.save(goodscat);
			loopGoodscat(goodscat.getParent(),goodscat.getParent().getTreeNo());
		}
		return goodscat.getCategoryId();
	}
	
	private void loopGoodscat(TbGoodsCategory parent,String treeNo){
		List childs = super.baseDao.find("from TbGoodsCategory t where t.parent = ? order by t.orderNum asc", parent);
		if(childs.size()==0){
			parent.setIsLeaf(Constants.YES);
		}else{
			parent.setIsLeaf(Constants.NO);
		}
		super.save(parent);
		String myTreeNo = "";
		TbGoodsCategory goodscat = null;
		for(int i = 0,len = childs.size();i<len;i++){
			goodscat = (TbGoodsCategory)childs.get(i);
			myTreeNo = treeNo+String.valueOf(100+i);
			goodscat.setTreeNo(myTreeNo);
			goodscat.setCategoryLevel(parent.getCategoryLevel()+1);
			super.save(goodscat);
			loopGoodscat(goodscat,goodscat.getTreeNo());
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.base.admin.logic.GoodscatLogic#deleteGoodscatInfo(java.lang.Long)
	 */
	public String deleteGoodscatInfo(Long goodscatId) {
		TbGoodsCategory info = super.load(TbGoodsCategory.class, goodscatId);
		int cnt = super.baseDao.count("select count(*) from TbGoodsCategory t where t.parent = ? ", info) ;
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
		List categoryList = super.baseDao.find("from TbGoodsCategory t where t.categoryUrl = ? and t.shopInfo.shopId = ? ", new Object[]{url,Constants.SYSTEM_SHOP});
		if(categoryList.size()==1){
			TbGoodsCategory category = (TbGoodsCategory)categoryList.get(0);
			return super.baseDao.find("from TbGoodsCategory t where t.parent.categoryId = ? and t.shopInfo.shopId = ?", new Object[]{
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
	public List findCategoryListByTreeNo(String treeNo, Long shopId) {
		return super.baseDao
				.find(
						"from TbGoodsCategory t where t.treeNo like ? and t.shopInfo.shopId = ? order by t.treeNo asc",
						new Object[] { treeNo+"%", Constants.SYSTEM_SHOP });
	}
	
	/**
	 * 根据店铺ID查找所有分类
	 * @param shopId
	 * @return
	 */
	public List findAllCategoryByShop(Long shopId){
		return super.baseDao.find("from TbGoodsCategory t where t.shopInfo.shopId = ? order by t.treeNo asc",shopId);
	}
	
	/**
	 * 查找店铺所有分类信息
	 * @param treeNo
	 * @param shopId
	 * @return
	 */
	public List findShopCategory(Long shopId) {
		return super.baseDao.find("from TbGoodsCategory t where t.parent is not null and t.shopInfo.shopId = ? order by t.treeNo asc",shopId);
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCatLogic#findCategoryListByParentId(java.lang.Long, java.lang.Long)
	 */
	public List findCategoryListByParentId(Long parentId, Long shopId) {
		return super.baseDao
				.find(
						"from TbGoodsCategory t where t.parent.categoryId = ? and t.shopInfo.shopId = ? order by treeNo asc ",
						new Object[] { parentId, shopId });
	}
	
	
}
