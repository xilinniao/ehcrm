package com.eh.shop.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseTreeCtrl;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.GoodsCatLogic;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbShopInfo;

public class GoodsCatCtrl extends BaseTreeCtrl{
	private static final Long ROOT_ID = Long.valueOf(1);
	
	GoodsCatLogic goodsCatLogic;	
	/**
	 * 商店LOGIC
	 */
	ShopLogic shopLogic;
	
	public ModelAndView getJingDongCat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Document doc = Jsoup.connect("http://www.360buy.com/allSort.aspx").get();
		
		Elements elms = doc.select("div.m");
		for (int i = 0,len = elms.size();i<len;i++) {
			Element bc = (Element)elms.get(i);
			//插入主分类
			TbGoodsCategory level1 = new TbGoodsCategory();
			level1.setCategoryName(bc.select("div.mt > h2  > a").first().text());
			level1.setDataStatus(Long.valueOf(0));
			level1.setOrderNum(Long.valueOf(i));
			level1.setTreeNo("001"+String.valueOf(100+i));
			level1.setShopInfo(this.shopLogic.load(TbShopInfo.class, Long.valueOf(1)));
			level1.setParent(this.goodsCatLogic.load(TbGoodsCategory.class, Long.valueOf(1)));
			this.goodsCatLogic.save(level1);
			
			//二级分类
			Element mc = bc.select("div.mc").first();
			Elements dls = mc.select("dl");
			for (int j = 0,lenj = dls.size();j<lenj;j++) {
				Element dl = (Element)dls.get(j);				
				TbGoodsCategory level2 = new TbGoodsCategory();
				level2.setCategoryName(dl.select("dt").first().text());
				level2.setDataStatus(Long.valueOf(0));
				level2.setOrderNum(Long.valueOf(j));
				level2.setTreeNo(level1.getTreeNo()+String.valueOf(100+j));
				level2.setShopInfo(this.shopLogic.load(TbShopInfo.class, Long.valueOf(1)));
				level2.setParent(level1);
				this.goodsCatLogic.save(level2);
				
				Elements ems = dl.select(" dd > em");
				for (int k = 0,lenk = ems.size();k<lenk;k++) {
					Element em = (Element)ems.get(k);
					TbGoodsCategory level3 = new TbGoodsCategory();
					level3.setCategoryName(em.text());
					level3.setDataStatus(Long.valueOf(0));
					level3.setOrderNum(Long.valueOf(k));
					level3.setTreeNo(level2.getTreeNo()+String.valueOf(100+k));
					level3.setShopInfo(this.shopLogic.load(TbShopInfo.class, Long.valueOf(1)));
					level3.setParent(level2);
					this.goodsCatLogic.save(level3);
				}
			}
			/*System.out.print(bc.select("div.mc > dl  > dt").first().text());
			Elements ddems = bc.select("div.mc > dl  > dd > em");
			for (Element ddem : ddems) {
				System.out.print(ddem.text());
			}*/
		}
		
		super.renderText(response, "ok", null);
		return null;
	}
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goodscat/index.jsp");
		mav.addObject("rootId", ROOT_ID);
		return mav;
	}
	
	private TbGoodsCategory getRootGoodscat(){
		return goodsCatLogic.get(TbGoodsCategory.class,ROOT_ID);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		//设置ROOT根节点信息
		TbGoodsCategory rootGoodscat = getRootGoodscat();
		super.rootId = rootGoodscat.getCategoryId();
		super.rootTreeName = rootGoodscat.getCategoryName();
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		return goodsCatLogic.findGoodscatTree(rootGoodscat.getTreeNo(),shop.getShopId());
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editGoodscat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbGoodsCategory entity = goodsCatLogic.get(TbGoodsCategory.class, goodscatId);
		super.renderJson(response, FreeMarkerUtil.process("shop.admin.goodscat.entity.ftl", entity),null);
		return null;
	}
	
	public ModelAndView onEditGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		TbGoodsCategory entity = null;
		if(goodscatId.longValue()!=Long.valueOf(-99)){
			entity = goodsCatLogic.get(TbGoodsCategory.class, goodscatId);
		}else{
			entity = new TbGoodsCategory();
		}
		super.bindObject(request, entity);
		Long parentGoodscatId = super.getLong(request, "parentGoodscatId", false);
		TbGoodsCategory parentGoodscat = goodsCatLogic.load(TbGoodsCategory.class, parentGoodscatId);
		entity.setParent(parentGoodscat);
		entity.setShopInfo(shop);
		goodsCatLogic.saveGoodscatInfo(entity);
		super.renderText(response, "OK", null);
		return null;
	}
	
	/**
	 * 选择商品分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		return new ModelAndView("/jsp/shop/admin/goodscat/tree.jsp");
	}
	
	/**
	 * 新增商品分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		return new ModelAndView("/jsp/shop/admin/goodscat/add.jsp");
	}
	
	/**
	 * 删除商品分类资源
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodscatId = super.getLong(request, "categoryId", false);		
		String result = this.goodsCatLogic.deleteGoodscatInfo(goodscatId);
		super.renderText(response, result, null);
		return null;
	}

	/**
	 * @return the goodsCatLogic
	 */
	public GoodsCatLogic getGoodsCatLogic() {
		return goodsCatLogic;
	}

	/**
	 * @param goodsCatLogic the goodsCatLogic to set
	 */
	public void setGoodsCatLogic(GoodsCatLogic goodsCatLogic) {
		this.goodsCatLogic = goodsCatLogic;
	}

	/**
	 * @return the shopLogic
	 */
	public ShopLogic getShopLogic() {
		return shopLogic;
	}

	/**
	 * @param shopLogic the shopLogic to set
	 */
	public void setShopLogic(ShopLogic shopLogic) {
		this.shopLogic = shopLogic;
	}
}
