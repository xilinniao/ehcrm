package com.eh.shop.front.logic.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import com.eh.base.entity.TbAttachment;
import com.eh.base.logic.BaseLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsInfoSub;
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.front.cache.GoodsDetail;
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.cache.ImageUrl;
import com.eh.shop.front.cache.ShopInfo;
import com.eh.shop.front.logic.FrontCacheLogic;

public class FrontCacheLogicImpl extends BaseLogic implements FrontCacheLogic {
	/**
	 * 缓存
	 */
	Ehcache frontCache;
	/**
	 * 
	 */
	public GoodsDetail findGoodsDetail(Long subGoodsId,boolean reRead) {
		String key = "gsd_"+subGoodsId;//good sub detail	
		frontCache.remove(key);
		
		Element elm = frontCache.get(key);
		if(elm==null){
			TbGoodsInfoSub goodInfoSub = this.baseDao.get(TbGoodsInfoSub.class, subGoodsId);
			if(goodInfoSub==null){
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
			
			List<TbGoodsInfoSub> goodsSubList = baseDao.find("from TbGoodsInfoSub t where t.goods = ? order by t.orderNum asc ",goodInfo);			
			List subList = new ArrayList();
			for(TbGoodsInfoSub next:goodsSubList){
				GoodsShort subvo = new GoodsShort();
				subvo.setName(next.getGoodsSubName());
				subvo.setPrice(next.getMarketPrice());
				subvo.setDiscountPrice(next.getDiscountPrice());
				subList.add(subvo);
			}
			vo.setSubGoods(subList);
			
			List<TbAttachment> attachList = baseDao.find("select r.attachment from TbGoodsImages r where r.goodsInfo = ? order by r.orderNum asc", goodInfo);
			
			List imageList = new ArrayList();
			for(TbAttachment next:attachList){
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
			this.frontCache.put(new Element(key,vo));
			return vo;
		}else{
			return (GoodsDetail)elm.getValue();
		}
	}

	/**
	 * 传入子商品信息
	 */
	public GoodsShort findGoodsShort(Long subGoodsId,boolean reRead) {
		String key = "gss_"+subGoodsId;//good sub short		
		frontCache.remove(key);
		Element elm = frontCache.get(key);
		if(elm==null){
			TbGoodsInfoSub goodInfo = this.baseDao.get(TbGoodsInfoSub.class, subGoodsId);
			if(goodInfo==null){
				return null;
			}
			GoodsShort vo = new GoodsShort();
			vo.setGoodsId(subGoodsId);
			vo.setGoodsId(goodInfo.getGoods().getGoodsId());
			vo.setName(goodInfo.getGoods().getGoodsName()+(goodInfo.getGoodsSubName()==null?"":goodInfo.getGoodsSubName()));
			vo.setPrice(goodInfo.getMarketPrice());
			vo.setDiscountPrice(goodInfo.getDiscountPrice());
			vo.setImageA(goodInfo.getGoods().getFaceImage().getFilePathA());
			vo.setImageB(goodInfo.getGoods().getFaceImage().getFilePathB());
			vo.setImageC(goodInfo.getGoods().getFaceImage().getFilePathC());
			vo.setImageD(goodInfo.getGoods().getFaceImage().getFilePathD());
			vo.setImageE(goodInfo.getGoods().getFaceImage().getFilePathE());
			vo.setImageF(goodInfo.getGoods().getFaceImage().getFilePathF());
			this.frontCache.put(new Element(key,vo));
			return vo;
		}else{
			return (GoodsShort)elm.getValue();
		}
	}

	/**
	 * 店铺信息缓存
	 */
	public ShopInfo findShopInfo(Long shopId,boolean reRead) {
		String key = "si_"+shopId;//shop info
		frontCache.remove(key);
		Element elm = frontCache.get(key);
		if(elm==null){
			TbShopInfo shopInfo = super.baseDao.get(TbShopInfo.class, shopId);
			ShopInfo vo = new ShopInfo();
			vo.setShopName(shopInfo.getShopName());
			vo.setLinkerMobile(shopInfo.getLinkerMobile());
			vo.setLinkerMan(shopInfo.getLinkerMan());
			return vo;
		}else{
			return (ShopInfo)elm.getValue();
		}
	}

	public Ehcache getFrontCache() {
		return frontCache;
	}

	public void setFrontCache(Ehcache frontCache) {
		this.frontCache = frontCache;
	}
	
	
}
