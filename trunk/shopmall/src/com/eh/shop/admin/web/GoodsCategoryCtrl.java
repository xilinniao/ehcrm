package com.eh.shop.admin.web;

import java.util.List;
import java.util.Random;

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
import com.eh.base.util.Constants;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.GoodsCategoryLogic;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbPageGoodsRel;
import com.eh.shop.entity.TbShopInfo;

public class GoodsCategoryCtrl extends BaseTreeCtrl{
	GoodsCategoryLogic goodsCategoryLogic;
	/**
	 * 商店LOGIC
	 */
	ShopLogic shopLogic;
	/**
	 * <li> <a href="<%=homeUrl %>" class="home">首页</a></li>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView top(HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<TbGoodsCategory> categoryList = goodsCategoryLogic.findCategoryListByParentId(Long.valueOf(1), Long.valueOf(1));
		StringBuffer ul = new StringBuffer("<ul id=\"topnav\">");
		for(TbGoodsCategory levela:categoryList){
			ul.append("<li><a href=\"/category/"+levela.getCategoryId()+".html\" class=\"products\">"+levela.getCategoryName()+"</a><div class=\"sub\">");
			List<TbGoodsCategory> listb = goodsCategoryLogic.findCategoryListByParentId(levela.getCategoryId(), Long.valueOf(1));
			for(TbGoodsCategory levelb:listb){
				ul.append("<dl><dt><a href=\"/category/"+levelb.getCategoryId()+".html\">"+levelb.getCategoryName()+"</a></dt><dd>");
				List<TbGoodsCategory> listc = goodsCategoryLogic.findCategoryListByParentId(levelb.getCategoryId(), Long.valueOf(1));
				for(TbGoodsCategory levelc:listc){
					ul.append("<a href=\"/products/"+levelc.getCategoryId()+".html\">"+levelc.getCategoryName()+"</a>");
				}
				ul.append("</dd></dl>");
			}
			ul.append("</div></li>");
		}
		ul.append("</ul>");
		System.out.println(ul.toString());
		return null;
	}
	
	/**
	 * 初始化good rel
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView initGoodsRel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<TbGoodsCategory> categoryList = goodsCategoryLogic.find("select t from TbGoodsCategory t join t.shopInfo as s where s.shopId = ? order by t.treeNo asc",new Object[]{Long.valueOf(1)});
		for (int i = 0, size = categoryList.size(); i < size; i++) {
			TbGoodsCategory category = categoryList.get(i);
			if(category.getTreeNo().length()<10){
				initGoodsRelAaa(category);
			}
		}		
		return null;
	}
	
	private void initGoodsRelAaa(TbGoodsCategory category) throws Exception {
		List tmpList = this.goodsCategoryLogic
				.find(
						"select min(t.goodsId),max(t.goodsId)  from TbGoodsInfo t join t.category as cat where cat.treeNo like ?",
						new Object[] { category.getTreeNo() + "%" });
		if(tmpList.size()>0){
			Object[] t = (Object[])tmpList.get(0);
			Long from = (Long)t[0];
			Long to = (Long)t[1];
			if(from==null||to==null){
				return;
			}
			int between = to.intValue()-from.intValue();
			Random ram = new Random();
			int[] ramints = new int[100];
			for(int i = 0 ;i < 100 ;i++){
				ramints[i] = from.intValue()+ram.nextInt(between);
			}
			
			
			TbPageCategory a = new TbPageCategory();
			a.setCategoryName("热门商品");
			a.setOrderNum(Long.valueOf(1));
			a.setPageType(category);
			a.setShopInfo(this.goodsCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.goodsCategoryLogic.save(a);
			for (int i = 0;i<8;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setGoodsInfo(goodsCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setPageCategory(a);
				rel.setOrderNum(Long.valueOf(i));
				this.goodsCategoryLogic.save(rel);
			}
			
			TbPageCategory b = new TbPageCategory();
			b.setCategoryName("新品");
			b.setOrderNum(Long.valueOf(1));
			b.setPageType(category);
			b.setShopInfo(this.goodsCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.goodsCategoryLogic.save(b);
			for (int i = 10;i<18;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setPageCategory(b);
				rel.setGoodsInfo(goodsCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setOrderNum(Long.valueOf(i));
				this.goodsCategoryLogic.save(rel);
			}
			
			TbPageCategory c = new TbPageCategory();
			c.setCategoryName("特价促销");
			c.setOrderNum(Long.valueOf(1));
			c.setPageType(category);
			c.setShopInfo(this.goodsCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.goodsCategoryLogic.save(c);
			for (int i = 20;i<28;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setPageCategory(c);
				rel.setGoodsInfo(goodsCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setOrderNum(Long.valueOf(i));
				this.goodsCategoryLogic.save(rel);
			}
			
			
			TbPageCategory d = new TbPageCategory();
			d.setCategoryName("疯狂抢购");
			d.setOrderNum(Long.valueOf(1));
			d.setPageType(category);
			d.setShopInfo(this.goodsCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.goodsCategoryLogic.save(d);
			for (int i = 30;i<38;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setPageCategory(d);
				rel.setGoodsInfo(goodsCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setOrderNum(Long.valueOf(i));
				this.goodsCategoryLogic.save(rel);
			}
		}
	}
	
	
	public ModelAndView getJingDongCat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		this.goodsCategoryLogic.bulkUpdate("delete from TbGoodsCategory t where t.categoryId <> 1 ",new Object[]{});
		
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
			level1.setParent(this.goodsCategoryLogic.load(TbGoodsCategory.class, Long.valueOf(1)));
			this.goodsCategoryLogic.save(level1);
			
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
				this.goodsCategoryLogic.save(level2);
				
				Elements ems = dl.select(" dd > em");
				for (int k = 0,lenk = ems.size();k<lenk;k++) {
					Element em = (Element)ems.get(k);
					TbGoodsCategory level3 = new TbGoodsCategory();
					level3.setCategoryName(em.text());
					String url = em.select("a").first().attr("href");
					level3.setJdUrl(url);
					level3.setDataStatus(Long.valueOf(0));
					level3.setOrderNum(Long.valueOf(k));
					level3.setTreeNo(level2.getTreeNo()+String.valueOf(100+k));
					level3.setShopInfo(this.shopLogic.load(TbShopInfo.class, Long.valueOf(1)));
					level3.setParent(level2);
					this.goodsCategoryLogic.save(level3);
					/*if(k==0){
						getProduct(url,level3);
					}*/
					//getProduct(url,level3,true);
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
					
					goods.setJdUrl(elm.select("div.p-name > a").attr("href"));
					//明细就不获取了
					//this.getProductDetail(elm.select("div.p-name > a").attr("href"), goods);
					/*Double price =  goods.setDiscountPrice(discountPrice)*/
					this.goodsCategoryLogic.save(goods);
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
		TbGoodsCategory category = this.goodsCategoryLogic.get(TbGoodsCategory.class, categoryId);
		this.goodsCategoryLogic.bulkUpdate("delete from TbGoodsInfo t where t.category = ? ", new Object[]{category});
		this.getProduct(category.getCategoryUrl(), category,true);
		super.renderText(response, "ok");
		return null;
	}
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_category/index");
		TbGoodsCategory rootCategory = this.goodsCategoryLogic.getRootCategory(userInfo.getShopInfo().getShopId());
		mav.addObject("rootId", rootCategory.getCategoryId());
		
		List categoryList = this.goodsCategoryLogic.findFirstLevelCategory(userInfo.getShopInfo().getShopId());
		mav.addObject("categoryList", categoryList);
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		//设置ROOT根节点信息
		TbGoodsCategory rootGoodscat = this.goodsCategoryLogic.getRootCategory(userInfo.getShopInfo().getShopId());
		super.rootId = rootGoodscat.getCategoryId();
		super.rootTreeName = rootGoodscat.getCategoryName();
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		return goodsCategoryLogic.findGoodscatTree(rootGoodscat.getTreeNo(),shop.getShopId());
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editGoodscat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbGoodsCategory entity = goodsCategoryLogic.get(TbGoodsCategory.class, goodscatId);
		super.renderJson(response, FreeMarkerUtil.process("shop.admin.goodscat.entity.ftl", entity));
		return null;
	}
	
	public ModelAndView onEditGoodscat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbShopInfo shop = this.shopLogic.getUserShop(userInfo.getUser().getUserId());
		TbGoodsCategory entity = null;
		if(goodscatId.longValue()!=Long.valueOf(-99)){
			entity = goodsCategoryLogic.get(TbGoodsCategory.class, goodscatId);
		}else{
			entity = new TbGoodsCategory();
		}
		super.bindObject(request, entity);
		Long parentGoodscatId = super.getLong(request, "parentGoodscatId", false);
		TbGoodsCategory parentGoodscat = goodsCategoryLogic.load(TbGoodsCategory.class, parentGoodscatId);
		entity.setParent(parentGoodscat);
		entity.setShopInfo(shop);
		goodsCategoryLogic.saveGoodscatInfo(entity);
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
		return new ModelAndView("/jsp/shop/admin/goods_category/tree");
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_category/add");
		List categoryList = this.goodsCategoryLogic.findFirstLevelCategory(userInfo.getShopInfo().getShopId());
		mav.addObject("categoryList", categoryList);
		return mav;
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
		String result = this.goodsCategoryLogic.deleteGoodscatInfo(goodscatId);
		super.renderText(response, result);
		return null;
	}


	/**
	 * @return the goodsCategoryLogic
	 */
	public GoodsCategoryLogic getGoodsCategoryLogic() {
		return goodsCategoryLogic;
	}

	/**
	 * @param goodsCategoryLogic the goodsCategoryLogic to set
	 */
	public void setGoodsCategoryLogic(GoodsCategoryLogic goodsCategoryLogic) {
		this.goodsCategoryLogic = goodsCategoryLogic;
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
