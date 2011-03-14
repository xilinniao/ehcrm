package com.eh.shop.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbShopInfo;

public class GoodsCatCtrl extends BaseTreeCtrl{
	GoodsCatLogic goodsCatLogic;	
	/**
	 * 商店LOGIC
	 */
	ShopLogic shopLogic;
	
	public ModelAndView getJingDongCat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		this.goodsCatLogic.bulkUpdate("delete from TbGoodsCategory t where t.categoryId <> 1 ",new Object[]{});
		
		Document doc = Jsoup.connect("http://www.360buy.com/allSort.aspx").get();
		
		Elements elms = doc.select("div.m");
		for (int i = 1,len = elms.size();i<len;i++) {
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
					String url = em.select("a").first().attr("href");
					level3.setCategoryUrl(url);
					level3.setDataStatus(Long.valueOf(0));
					level3.setOrderNum(Long.valueOf(k));
					level3.setTreeNo(level2.getTreeNo()+String.valueOf(100+k));
					level3.setShopInfo(this.shopLogic.load(TbShopInfo.class, Long.valueOf(1)));
					level3.setParent(level2);
					this.goodsCatLogic.save(level3);
					/*if(k==0){
						getProduct(url,level3);
					}*/
					getProduct(url,level3,true);
				}
			}
			
			/*System.out.print(bc.select("div.mc > dl  > dt").first().text());
			Elements ddems = bc.select("div.mc > dl  > dd > em");
			for (Element ddem : ddems) {
				System.out.print(ddem.text());
			}*/
		}
		
		super.renderText(response, "ok");
		return null;
	}
	private void getProduct(String url, TbGoodsCategory cat, boolean isLoop) {
		String fix = url.substring(0, 4);
		if (StringUtils.isNotBlank(url)) {
			String realurl = "";
			if (!("http".equals(fix))) {
				realurl = "http://www.360buy.com/" + url;
			} else {
				realurl = url;
			}
			//System.out.println(realurl);
			
			try {
				Document doc = Jsoup.connect(realurl).get();
				Elements elms = doc.select("ul.list-h > li");

				for (int i = 0, len = elms.size(); i < len; i++) {
					Element elm = (Element) elms.get(i);
					TbGoodsInfo goods = new TbGoodsInfo();
					goods.setCategory(cat);
					goods.setGoodsName(elm.select("div.p-name > a").text());
					goods.setShopInfo(this.shopLogic.load(TbShopInfo.class,
							Long.valueOf(1)));
					String imageUrl = elm.select("div.p-img > a > img").attr(
							"src");
					if (StringUtils.isBlank(imageUrl)) {
						imageUrl = elm.select("div.p-img > a > img").attr(
								"src2");
					}
					goods.setImageUrl(imageUrl);
					
					//原价
					String orgPrice = elm.select("div.p-price > del").text().substring(1);
					goods.setOriginalPrice(Double.parseDouble(orgPrice));
					
					this.getProductDetail(elm.select("div.p-name > a").attr("href"), goods);
					/*Double price = 
					goods.setDiscountPrice(discountPrice)*/
					this.goodsCatLogic.save(goods);
				}

				if (isLoop) {
					int pageSize = 0;
					// 获取页数
					Elements page = doc.select("div.m > div.pagin > a ");
					for (int i = 0, len = page.size(); i < len; i++) {
						Element elm = (Element) page.get(i);
						// System.out.println(elm.text());
						if (NumberUtils.isDigits(elm.text())) {
							pageSize = Integer.parseInt(elm.text());
						}
					}
					//System.out.println(pageSize);
					for (int i = 1; i < pageSize; i++) {
						String newUrl = realurl.substring(0,
								realurl.length() - 6);
						newUrl += (i + 1);
						newUrl += realurl.substring(realurl.length() - 5);
						//System.out.println(newUrl);
						getProduct(newUrl, cat, false);
						//Thread.sleep(3000);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取商品明细
	 * @param detailUrl
	 * @param goods
	 */
	private void getProductDetail(String url,TbGoodsInfo goods){
		String fix = url.substring(0, 4);
		if (StringUtils.isNotBlank(url)) {
			String realurl = "";
			if (!("http".equals(fix))) {
				realurl = "http://www.360buy.com/" + url;
			} else {
				realurl = url;
			}
			//System.out.println(realurl);
			try {
				Document doc = Jsoup.connect(realurl).get();
				Elements elms = doc.select("div.mc > div.content");
				goods.setGoodsDesc(elms.get(0).html());
				//Thread.sleep(3000);
				
				/*Elements uls = doc.select("div.mc > div.i-detail");
				for(int i = 0 ,len = uls.size();i<len;i++){
					
				}*/
				
				//重量
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取分类商品信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public ModelAndView getProductByCategory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Long categoryId = super.getLong(request, "categoryId", false);
		TbGoodsCategory category = this.goodsCatLogic.get(TbGoodsCategory.class, categoryId);
		this.goodsCatLogic.bulkUpdate("delete from TbGoodsInfo t where t.category = ? ", new Object[]{category});
		this.getProduct(category.getCategoryUrl(), category,true);
		super.renderText(response, "ok");
		return null;
	}
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goodscat/index");
		TbGoodsCategory rootCategory = this.goodsCatLogic.getRootCategory(userInfo.getShopInfo().getShopId());
		mav.addObject("rootId", rootCategory.getCategoryId());
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		//设置ROOT根节点信息
		TbGoodsCategory rootGoodscat = this.goodsCatLogic.getRootCategory(userInfo.getShopInfo().getShopId());
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
		super.renderJson(response, FreeMarkerUtil.process("shop.admin.goodscat.entity.ftl", entity));
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
		super.renderText(response, "OK");
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
		return new ModelAndView("/jsp/shop/admin/goodscat/tree");
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
		return new ModelAndView("/jsp/shop/admin/goodscat/add");
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
		super.renderText(response, result);
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
