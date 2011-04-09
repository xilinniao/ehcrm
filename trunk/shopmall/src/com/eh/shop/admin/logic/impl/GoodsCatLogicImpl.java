package com.eh.shop.admin.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.eh.base.entity.TreeVo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.GoodsCatLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbShopInfo;

public class GoodsCatLogicImpl extends BaseLogic implements GoodsCatLogic {
	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsCatLogic#getRootCategory(java.lang.Long)
	 */
	public TbGoodsCategory getRootCategory(Long shopId) {
		List cats = super.baseDao.find("from TbGoodsCategory t where t.treeNo = '001' ");
		return (TbGoodsCategory)cats.get(0);
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
			loopGoodscat(goodscat.getParent().getCategoryId(),goodscat.getParent().getTreeNo());
		}else{
			super.save(goodscat);
			loopGoodscat(goodscat.getParent().getCategoryId(),goodscat.getParent().getTreeNo());
		}
		return goodscat.getCategoryId();
	}
	
	private void loopGoodscat(Long pid,String treeNo){
		List childs = super.baseDao.find("from TbGoodsCategory t where t.parent.categoryId = ? order by t.orderNum asc", pid);
		String myTreeNo = "";
		TbGoodsCategory goodscat = null;
		for(int i = 0,len = childs.size();i<len;i++){
			goodscat = (TbGoodsCategory)childs.get(i);
			myTreeNo = treeNo+String.valueOf(100+i);
			goodscat.setTreeNo(myTreeNo);
			super.save(goodscat);
			loopGoodscat(goodscat.getCategoryId(),goodscat.getTreeNo());
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
						"from TbGoodsCategory t where t.treeNo like ? and t.shopInfo.shopId = ? ",
						new Object[] { treeNo+"%", Constants.SYSTEM_SHOP });
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
