package com.eh.shop.front.logic.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import com.eh.base.entity.TbAttachment;
import com.eh.base.logic.BaseLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsInfoSub;
import com.eh.shop.front.cache.GoodsDetail;
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.cache.ImageUrl;
import com.eh.shop.front.logic.FrontCacheLogic;

public class FrontCacheLogicImpl extends BaseLogic implements FrontCacheLogic {
	/**
	 * 缓存
	 */
	Ehcache frontCache;
	
	/**
	 * 
	 */
	public GoodsDetail findGoodsDetail(Long goodsId) {
		String key = "gs_"+goodsId;
		TbGoodsInfo goodInfo = this.baseDao.get(TbGoodsInfo.class, goodsId);
		Element elm = frontCache.get(key);
		if(elm==null){
			GoodsDetail vo = new GoodsDetail();
			vo.setName(goodInfo.getGoodsName());
			vo.setPrice(goodInfo.getMarketPrice());
			vo.setDiscountPrice(goodInfo.getDiscountPrice());
			vo.setGoodsDesc(goodInfo.getGoodsDesc());
			vo.setLeavesCount(goodInfo.getLeavesCount());
			
			List<TbGoodsInfoSub> goodsSubList = baseDao.find("from TbGoodsInfoSub t where t.goods.goodsId = ? order by ",goodsId);			
			List subList = new ArrayList();
			for(TbGoodsInfoSub next:goodsSubList){
				GoodsShort subvo = new GoodsShort();
				subvo.setName(next.getGoodsSubName());
				subvo.setPrice(next.getMarketPrice());
				subvo.setDiscountPrice(next.getDiscountPrice());
				subList.add(subvo);
			}			
			vo.setSubGoods(subList);
			
			List<TbAttachment> attachList = baseDao.find("select r.attachment from TbGoodsAttach r where r.goodsInfo.goodsId = ? order by r.orderNum asc", goodsId);
			
			List imageList = new ArrayList();
			for(TbAttachment next:attachList){
				ImageUrl image = new ImageUrl();
				image.setMiddle(next.getFileLoaction()+"."+next.getFileExtension());
				imageList.add(image);
			}
			vo.setImageList(imageList);
			
			this.frontCache.put(new Element(key,vo));
			return vo;
		}else{
			return (GoodsDetail)elm.getValue();
		}
	}

	/**
	 * 传入子商品信息
	 */
	public GoodsShort findGoodsShort(Long subGoodsId) {
		String key = "gs_"+subGoodsId;
		TbGoodsInfoSub goodInfo = this.baseDao.get(TbGoodsInfoSub.class, subGoodsId);
		Element elm = frontCache.get(key);
		if(elm==null){
			GoodsShort vo = new GoodsShort();
			vo.setGoodId(goodInfo.getGoods().getGoodsId());
			vo.setName(goodInfo.getGoods().getGoodsName()+goodInfo.getGoodsSubName());
			vo.setPrice(goodInfo.getMarketPrice());
			vo.setDiscountPrice(goodInfo.getDiscountPrice());
			this.frontCache.put(new Element(key,vo));
			return vo;
		}else{
			return (GoodsShort)elm.getValue();
		}
	}

	public Ehcache getFrontCache() {
		return frontCache;
	}

	public void setFrontCache(Ehcache frontCache) {
		this.frontCache = frontCache;
	}
	
	
}
