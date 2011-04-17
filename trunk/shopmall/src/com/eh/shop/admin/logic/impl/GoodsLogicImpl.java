/**
 * 
 */
package com.eh.shop.admin.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbGoodsCategoryRel;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsInfoShort;
import com.eh.shop.entity.TbSiteCategory;

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
	public String saveGoodsInfo(TbGoodsInfo info,TbSiteCategory siteCategory) {
		if(info.getGoodsId().longValue()==Constants.ADD_PK_ID.longValue()){
			info.setGoodsId(null);
			//增加一条对应关系
			if(siteCategory!=null){
				info.setSiteCategory(siteCategory);
			}
			super.save(info);
			if(siteCategory != null ){
				TbGoodsCategoryRel rel = new TbGoodsCategoryRel();
				rel.setGoods(info);
				rel.setCategory(siteCategory);
				Long orderNum = this.getMaxOrderNum(siteCategory);
				rel.setOrderNum(orderNum);
				rel.setCreateTime(new Date());
				super.save(rel);
			}
		}else{
			super.save(info);
		}
		return null;
	}
	
	
	private Long getMaxOrderNum(TbSiteCategory siteCategory){
		Long max = super.baseDao.findLong("select max(orderNum) from TbGoodsCategoryRel t where t.category = ? ", new Object[]{siteCategory});
		if(max==null){
			return Long.valueOf(1);
		}else{
			return max+1;
		}
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#findImageList(java.lang.Long)
	 */
	public List findImageList(Long goodsId) {
		return super.baseDao.find("select r.attachment from TbGoodsAttach r where r.goodsInfo.goodsId = ?", goodsId);
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#findGoodsForPrice(java.lang.Long[])
	 */
	public List findGoodsForPrice(String productId) {
		List goodsList = new ArrayList();
		String[] productIds = productId.split(",");
		for(int i = 0,len = productIds.length;i<len;i++){
			try{
				String[] tmp = productIds[i].split("=");//0为商品ID,1为商品订购数量
				if(tmp.length==2){
					Long product = Long.parseLong(tmp[0]);
					Long cnt = Long.parseLong(tmp[1]);
					TbGoodsInfoShort goods = super.get(TbGoodsInfoShort.class,product);
					goods.setCnt(cnt);
					if(goods!=null){
						goodsList.add(goods);
					}
				}
				
				
			}catch(NumberFormatException ne){
				//忽略
			}
		}
		return goodsList;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#findAutoSuggest(java.lang.String)
	 */
	public List findAutoSuggest(String q) {
		Criteria criteria = baseDao.createCriteria(TbGoodsInfoShort.class);
		CriteriaUtil.addFullLike(criteria, "goodsName", q);
		criteria.setMaxResults(10);
		return criteria.list();
	}
}
