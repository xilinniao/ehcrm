package com.eh.shop.front.logic.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.entity.TbAttachment;
import com.eh.base.logic.BaseLogic;
import com.eh.shop.entity.TbArticleInfo;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsInfoSub;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.front.cache.GoodsDetail;
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.cache.ImageUrl;
import com.eh.shop.front.cache.ShopInfo;
import com.eh.shop.front.logic.FrontCacheLogic;
import com.eh.shop.front.vo.GoodsCategoryVo;

public class FrontCacheLogicImpl extends BaseLogic implements FrontCacheLogic {
	/**
	 * 缓存
	 */
	Ehcache frontCache;

	/**
	 * 
	 */
	public GoodsDetail findGoodsDetail(Long subGoodsId, boolean reRead) {
		String key = "gsd_" + subGoodsId;// good sub detail
		// frontCache.remove(key);

		Element elm = frontCache.get(key);
		if (elm == null) {
			TbGoodsInfoSub goodInfoSub = this.baseDao.get(TbGoodsInfoSub.class,
					subGoodsId);
			if (goodInfoSub == null) {
				return null;
			}
			TbGoodsInfo goodInfo = goodInfoSub.getGoods();

			GoodsDetail vo = new GoodsDetail();
			vo.setGoodsId(subGoodsId);
			vo.setName(goodInfo.getGoodsName());
			vo.setPrice(goodInfoSub.getMarketPrice());
			vo.setDiscountPrice(goodInfoSub.getDiscountPrice());
			vo.setGoodsDesc(goodInfo.getExt().getGoodsDesc());
			vo.setLeavesCount(goodInfoSub.getLeavesCount());

			List<TbGoodsInfoSub> goodsSubList = baseDao
					.find(
							"from TbGoodsInfoSub t where t.goods = ? order by t.orderNum asc ",
							goodInfo);
			List subList = new ArrayList();
			for (TbGoodsInfoSub next : goodsSubList) {
				GoodsShort subvo = new GoodsShort();
				subvo.setName(next.getGoodsSubName());
				subvo.setPrice(next.getMarketPrice());
				subvo.setDiscountPrice(next.getDiscountPrice());
				subList.add(subvo);
			}
			vo.setSubGoods(subList);

			List<TbAttachment> attachList = baseDao
					.find(
							"select r.attachment from TbGoodsImages r where r.goodsInfo = ? order by r.orderNum asc",
							goodInfo);

			List imageList = new ArrayList();
			for (TbAttachment next : attachList) {
				ImageUrl image = new ImageUrl();
				image.setImageA(next.getFilePathA());
				image.setImageB(next.getFilePathB());
				image.setImageC(next.getFilePathC());
				image.setImageD(next.getFilePathD());
				image.setImageE(next.getFilePathE());
				image.setImageF(next.getFilePathF());
				imageList.add(image);
			}
			vo.setImageList(imageList);
			vo.setShopId(goodInfo.getShopInfo().getShopId());
			this.frontCache.put(new Element(key, vo));
			return vo;
		} else {
			return (GoodsDetail) elm.getValue();
		}
	}

	/**
	 * 传入子商品信息
	 */
	public GoodsShort findGoodsShort(Long subGoodsId, boolean reRead) {
		String key = "gss_" + subGoodsId;// good sub short
		// frontCache.remove(key);
		Element elm = frontCache.get(key);
		if (elm == null) {
			TbGoodsInfoSub goodInfo = this.baseDao.get(TbGoodsInfoSub.class,
					subGoodsId);
			if (goodInfo == null) {
				return null;
			}
			GoodsShort vo = new GoodsShort();
			vo.setGoodsId(subGoodsId);
			vo.setGoodsId(goodInfo.getGoods().getGoodsId());
			vo.setName(goodInfo.getGoods().getGoodsName()
					+ (goodInfo.getGoodsSubName() == null ? "" : goodInfo
							.getGoodsSubName()));
			vo.setPrice(goodInfo.getMarketPrice());
			vo.setDiscountPrice(goodInfo.getDiscountPrice());
			vo.setImageA(goodInfo.getGoods().getFaceImage().getFilePathA());
			vo.setImageB(goodInfo.getGoods().getFaceImage().getFilePathB());
			vo.setImageC(goodInfo.getGoods().getFaceImage().getFilePathC());
			vo.setImageD(goodInfo.getGoods().getFaceImage().getFilePathD());
			vo.setImageE(goodInfo.getGoods().getFaceImage().getFilePathE());
			vo.setImageF(goodInfo.getGoods().getFaceImage().getFilePathF());
			this.frontCache.put(new Element(key, vo));
			return vo;
		} else {
			return (GoodsShort) elm.getValue();
		}
	}

	/**
	 * 店铺信息缓存
	 */
	public ShopInfo findShopInfo(Long shopId, boolean reRead) {
		String key = "si_" + shopId;// shop info
		frontCache.remove(key);
		Element elm = frontCache.get(key);
		if (elm == null) {
			TbShopInfo shopInfo = super.baseDao.get(TbShopInfo.class, shopId);
			ShopInfo vo = new ShopInfo();
			vo.setShopId(shopId);
			vo.setShopName(shopInfo.getShopName());
			vo.setLinkerMobile(shopInfo.getLinkerMobile());
			vo.setLinkerMan(shopInfo.getLinkerMan());
			vo.setShopAddr(shopInfo.getShopAddr());
			vo.setFoundDate(shopInfo.getFoundDateStr());
			vo.setPubNote(shopInfo.getPubNote());
			this.frontCache.put(new Element(key, vo));
			return vo;
		} else {
			return (ShopInfo) elm.getValue();
		}
	}

	/**
	 * 顶层商品分类信息
	 */
	public List<GoodsCategoryVo> findCategoryGoods(Long categoryId) {
		String key = "gsc_" + categoryId;// category goods
		//frontCache.remove(key);
		Element elm = frontCache.get(key);
		if (elm == null) {
			List<GoodsCategoryVo> cacheList = new ArrayList<GoodsCategoryVo>();
			List<TbPageCategory> pageCategoryList = super.baseDao
					.find(
							"from TbPageCategory t where t.siteCategory.categoryId = ? and t.isShow = 0 order by orderNum asc ",
							new Object[] { categoryId });
			for (TbPageCategory pageCategory : pageCategoryList) {
				GoodsCategoryVo vo = new GoodsCategoryVo();
				vo.setCategoryName(pageCategory.getCategoryName());
				Page page = super.baseDao
						.pagedQuery(
								"select t.goodsInfo.goodsId from TbPageGoodsRel t where t.pageCategory = ? ",
								1, pageCategory.getShowNum().intValue(), pageCategory);
				List<Long> goodsList = (List<Long>)page.getResult();
				List<GoodsShort> goodsAdapterList = new ArrayList<GoodsShort>();
				for (Long goodsId : goodsList) {
					goodsAdapterList.add(this.findGoodsShort(goodsId, true));
				}
				vo.setGoodsList(goodsAdapterList);
				cacheList.add(vo);
			}
			this.frontCache.put(new Element(key, cacheList));
			return cacheList;
		} else {
			return (List<GoodsCategoryVo>) elm.getValue();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.eh.shop.front.logic.FrontCacheLogic#findHelpContent(java.lang.String)
	 */
	public Map<String,String> findHelpContent(String url) {
		String key = "help_" + url;// help
		//frontCache.remove(key);
		Element elm = frontCache.get(key);
		if (elm == null) {
			List<TbArticleInfo> articleList = super.baseDao.find("from TbArticleInfo t where t.articleUrl = ? ", url);
			Map<String,String> data = new HashMap<String,String>();
			if(articleList.size()>0){
				TbArticleInfo article = articleList.get(0);
				data.put("title", article.getTitle());
				data.put("content", article.getContent());
				return data;
			}else{
				return null;
			}
		} else {
			return (Map<String,String>) elm.getValue();
		}
	}

	public Ehcache getFrontCache() {
		return frontCache;
	}

	public void setFrontCache(Ehcache frontCache) {
		this.frontCache = frontCache;
	}

}
