/**
 * 
 */
package com.eh.shop.admin.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.entity.TbAttachment;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbGoodsImages;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsInfoShort;
import com.eh.shop.entity.TbGoodsInfoSub;
import com.eh.shop.entity.TbSiteCategory;
import com.eh.shop.front.cache.GoodsShort;

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
		//加上商店的判断
		CriteriaUtil.addEq(criteria, "shopInfo.shopId", qry.getUserInfo().getShopInfo().getShopId());
		CriteriaUtil.addRightLike(criteria, "c.treeNo", qry.getTreeNo());
		CriteriaUtil.addFullLike(criteria, "goodsName", qry.getGoodsName());
		CriteriaUtil.addOrder(criteria, "createTime", CriteriaUtil.DESC);
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	/*
	 * (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#findGoodsListForPageSelect(com.eh.shop.admin.web.qry.GoodsInfoQry)
	 */
	public Page findGoodsListForPage(GoodsInfoQry qry) {
		Criteria criteria = baseDao.createCriteria(TbGoodsInfo.class);
		criteria.createAlias("siteCategory","c");
		criteria.createAlias("shopInfo", "s");		
		CriteriaUtil.addRightLike(criteria, "c.treeNo", qry.getTreeNo());
		CriteriaUtil.addFullLike(criteria, "goodsName", qry.getGoodsName());
		criteria.addOrder(Order.asc("c.treeNo"));
		criteria.addOrder(Order.desc("createTime"));
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
	
	public Page findGoodsListForJingdong(GoodsInfoQry qry) {
		Criteria criteria = baseDao.createCriteria(TbGoodsInfo.class);
		criteria.add(Restrictions.isNull("createUser"));
		criteria.addOrder(Order.asc("goodsId"));
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
	
	public Page findGoodsListForJingDongPrice(GoodsInfoQry qry) {
		Criteria criteria = baseDao.createCriteria(TbGoodsInfo.class);
		criteria.add(Restrictions.isNull("createTime"));
		criteria.addOrder(Order.asc("goodsId"));
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.GoodsLogic#saveGoodsInfo(com.eh.shop.entity.TbGoodsInfo)
	 */
	public String saveGoodsInfo(TbGoodsInfo info,TbSiteCategory siteCategory,TbGoodsInfoSub[] subs,Long[] imageIds) {
		if(info.getGoodsId().longValue()==Constants.ADD_PK_ID.longValue()){
			info.setGoodsId(null);
			//增加一条对应关系
			if(siteCategory!=null){
				info.setSiteCategory(siteCategory);
			}
			info.setMarketPrice(subs[0].getMarketPrice());
			info.setDiscountPrice(subs[0].getDiscountPrice());
			super.save(info);
			for(TbGoodsInfoSub next:subs){
				next.setGoods(info);
				super.save(next);
			}
			
			if(imageIds!=null){
				for(int i = 0,len = imageIds.length;i<len;i++){
					TbGoodsImages ga = new TbGoodsImages();
					TbAttachment attach = super.get(TbAttachment.class, imageIds[i]);
					ga.setAttachment(attach);
					ga.setGoodsInfo(info);
					ga.setOrderNum(i);
					ga.setRelType(Constants.GOODS_ATTACHMENT_TYPE);
					if(i==0){
						//设置成封面
						info.setFaceImage(attach);
						super.save(info);
					}
					super.save(ga);
				}
			}
			
			/*if(siteCategory != null ){
				TbGoodsCategoryRel rel = new TbGoodsCategoryRel();
				rel.setGoods(info);
				rel.setCategory(siteCategory);
				Long orderNum = this.getMaxOrderNum(siteCategory);
				rel.setOrderNum(orderNum);
				rel.setCreateTime(new Date());
				rel.setCreateUser(info.getCreateUser());
				super.save(rel);
			}*/
		}else{
			//查询到原来的价格
			for(TbGoodsInfoSub next:subs){
				next.setGoods(info);
				super.save(next);
			}
			
			//查找原有的图片信息
			List<TbGoodsImages> imagesList = super.baseDao.find("from TbGoodsImages r where r.goodsInfo.goodsId = ? order by r.orderNum asc",info.getGoodsId());
			if(imagesList.size()>0){
				for(TbGoodsImages next:imagesList){
					if(!this.isInImages(next.getAttachment().getRecId(), imageIds)){
						super.remove(next);
					}
				}
			}
			
			//添加新的图片信息
			if(imageIds!=null){
				for(int i = 0,len = imageIds.length;i<len;i++){
					TbAttachment attach = null;
					if(i==0){
						attach= super.get(TbAttachment.class, imageIds[i]);
						//设置成封面
						info.setFaceImage(attach);
						super.save(info);
					}
					if(this.isNewImage(imageIds[i], imagesList)){				
						TbGoodsImages ga = new TbGoodsImages();
						attach = super.get(TbAttachment.class, imageIds[i]);
						ga.setAttachment(attach);
						ga.setGoodsInfo(info);
						ga.setOrderNum(i);
						ga.setRelType(Constants.GOODS_ATTACHMENT_TYPE);						
						super.save(ga);
					}
					if(i==0){
						info.setFaceImage(super.get(TbAttachment.class, imageIds[i]));
					}
				}
			}
			super.save(info);
		}
		return null;
	}
	
	/**
	 * 是否老图片是否在新图片列表中
	 * @param imageId
	 * @param imageIds
	 * @return
	 */
	private boolean isInImages(Long imageId,Long[] imageIds){
		if(imageIds!=null){
			for(Long next:imageIds){
				if(imageId.longValue()==next.longValue()){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断是否是新图片
	 * @param imageId
	 * @param imagesList
	 * @return
	 */
	private boolean isNewImage(Long imageId,List<TbGoodsImages> imagesList){
		for(TbGoodsImages next:imagesList){
			if(next.getAttachment().getRecId().longValue()==imageId.longValue()){
				return false;
			}
		}
		return true;
	}
	
	
	private Long getMaxOrderNum(TbSiteCategory siteCategory){
		Long max = super.baseDao.findLong("select max(orderNum) from TbGoodsCategoryRel t where t.category = ? ", new Object[]{siteCategory});
		if(max==null){
			return Long.valueOf(1);
		}else{
			return max+1;
		}
	}
	
	/*private Long cntCategoryRel(TbSiteCategory siteCategory,){
		Long cnt = super.baseDao.findLong("select count(*) from TbGoodsCategoryRel where category = ? and goods = ? ", new Object[]{
				
		}); 
	}*/
	
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
					
					GoodsShort goods = new GoodsShort();
					TbGoodsInfoSub subGoods = super.get(TbGoodsInfoSub.class,product);
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
	
	/**
	 * 查找商品子列表
	 */
	public List findGoodSubList(Long goodsId) {
		return super.baseDao.find("from TbGoodsInfoSub t where t.goods.goodsId = ? ",goodsId);
	}
	
	/**
	 * 查找图片信息
	 */
	public List findImageList(Long goodsId) {
		return super.baseDao.find("select r.attachment from TbGoodsImages r where r.goodsInfo.goodsId = ? order by r.orderNum asc", goodsId);
	}

	public Page findFrontGoodsList(GoodsInfoQry qry) {
		StringBuffer hql = new StringBuffer("select t.goodsSubId from TbGoodsInfoSub t join t.goods as g where g.shopInfo.shopId = ? ");
		List params = new ArrayList();
		params.add(qry.getShopId());
		if(StringUtils.isNotBlank(qry.getTreeNo())){
			hql.append(" and g.category.treeNo like ? ");
			params.add(qry.getTreeNo()+"%");
		}
		
		hql.append(" order by g.createTime desc");
		return super.baseDao.pagedQuery(hql.toString(), qry.getPageNo(), qry.getPageSize(), params.toArray());
	}
	
	/**
	 * 最多显示12个推荐商品
	 */
	public List findRecommendGoods(GoodsInfoQry qry) {
		StringBuffer hql = new StringBuffer("select g.defaultGoodsSub from TbGoodsInfo g where g.shopInfo.shopId = ? and g.isRecommend = 1 order by g.orderNum asc");
		return super.baseDao.pagedQuery(hql.toString(), 1, 12, qry.getShopId()).getResult();
	}	
}
