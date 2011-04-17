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
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbPageGoodsRel;
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.entity.TbSiteCategory;

public class SiteCategoryCtrl extends BaseTreeCtrl{
	SiteCategoryLogic siteCategoryLogic;
	/**
	 * <li> <a href="<%=homeUrl %>" class="home">首页</a></li>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView top(HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<TbSiteCategory> categoryList = siteCategoryLogic.findCategoryListByParentId(Long.valueOf(1));
		StringBuffer ul = new StringBuffer("<ul id=\"topnav\">");
		for(TbSiteCategory levela:categoryList){
			ul.append("<li><a href=\"/category/"+levela.getCategoryId()+".html\" class=\"products\">"+levela.getCategoryName()+"</a><div class=\"sub\">");
			List<TbSiteCategory> listb = siteCategoryLogic.findCategoryListByParentId(levela.getCategoryId());
			for(TbSiteCategory levelb:listb){
				ul.append("<dl><dt><a href=\"/category/"+levelb.getCategoryId()+".html\">"+levelb.getCategoryName()+"</a></dt><dd>");
				List<TbSiteCategory> listc = siteCategoryLogic.findCategoryListByParentId(levelb.getCategoryId());
				for(TbSiteCategory levelc:listc){
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
		List<TbSiteCategory> categoryList = siteCategoryLogic.find("select t from TbSiteCategory t join t.shopInfo as s where s.shopId = ? order by t.treeNo asc",new Object[]{Long.valueOf(1)});
		for (int i = 0, size = categoryList.size(); i < size; i++) {
			TbSiteCategory category = categoryList.get(i);
			if(category.getTreeNo().length()<10){
				initGoodsRelAaa(category);
			}
		}		
		return null;
	}
	
	private void initGoodsRelAaa(TbSiteCategory category) throws Exception {
		List tmpList = this.siteCategoryLogic
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
			//a.setPageType(category);
			a.setShopInfo(this.siteCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.siteCategoryLogic.save(a);
			for (int i = 0;i<8;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setGoodsInfo(siteCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setPageCategory(a);
				rel.setOrderNum(Long.valueOf(i));
				this.siteCategoryLogic.save(rel);
			}
			
			TbPageCategory b = new TbPageCategory();
			b.setCategoryName("新品");
			b.setOrderNum(Long.valueOf(1));
			//b.setPageType(category);
			b.setShopInfo(this.siteCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.siteCategoryLogic.save(b);
			for (int i = 10;i<18;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setPageCategory(b);
				rel.setGoodsInfo(siteCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setOrderNum(Long.valueOf(i));
				this.siteCategoryLogic.save(rel);
			}
			
			TbPageCategory c = new TbPageCategory();
			c.setCategoryName("特价促销");
			c.setOrderNum(Long.valueOf(1));
			//c.setPageType(category);
			c.setShopInfo(this.siteCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.siteCategoryLogic.save(c);
			for (int i = 20;i<28;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setPageCategory(c);
				rel.setGoodsInfo(siteCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setOrderNum(Long.valueOf(i));
				this.siteCategoryLogic.save(rel);
			}
			
			
			TbPageCategory d = new TbPageCategory();
			d.setCategoryName("疯狂抢购");
			d.setOrderNum(Long.valueOf(1));
			//d.setPageType(category);
			d.setShopInfo(this.siteCategoryLogic.get(TbShopInfo.class, Long.valueOf(1)));
			this.siteCategoryLogic.save(d);
			for (int i = 30;i<38;i++){
				TbPageGoodsRel rel = new TbPageGoodsRel();
				rel.setPageCategory(d);
				rel.setGoodsInfo(siteCategoryLogic.get(TbGoodsInfo.class, Long.valueOf(ramints[i])));
				rel.setOrderNum(Long.valueOf(i));
				this.siteCategoryLogic.save(rel);
			}
		}
	}
	
	
	public ModelAndView getJingDongCat(HttpServletRequest request,HttpServletResponse response) throws Exception {
		this.siteCategoryLogic.bulkUpdate("delete from TbSiteCategory t where t.categoryId <> 1 ",new Object[]{});
		
		Document doc = Jsoup.connect("http://www.360buy.com/allSort.aspx").get();
		
		Elements elms = doc.select("div.m");
		for (int i = 1,len = elms.size();i<len;i++) {
			Element bc = (Element)elms.get(i);
			//插入主分类
			TbSiteCategory level1 = new TbSiteCategory();
			level1.setCategoryName(bc.select("div.mt > h2  > a").first().text());
			level1.setDataStatus(Long.valueOf(0));
			level1.setOrderNum(Long.valueOf(i));
			level1.setTreeNo("001"+String.valueOf(100+i));
			level1.setParent(this.siteCategoryLogic.load(TbSiteCategory.class, Long.valueOf(1)));
			this.siteCategoryLogic.save(level1);
			
			//二级分类
			Element mc = bc.select("div.mc").first();
			Elements dls = mc.select("dl");
			for (int j = 0,lenj = dls.size();j<lenj;j++) {
				Element dl = (Element)dls.get(j);				
				TbSiteCategory level2 = new TbSiteCategory();
				level2.setCategoryName(dl.select("dt").first().text());
				level2.setDataStatus(Long.valueOf(0));
				level2.setOrderNum(Long.valueOf(j));
				level2.setTreeNo(level1.getTreeNo()+String.valueOf(100+j));
				level2.setParent(level1);
				this.siteCategoryLogic.save(level2);
				
				Elements ems = dl.select(" dd > em");
				for (int k = 0,lenk = ems.size();k<lenk;k++) {
					Element em = (Element)ems.get(k);
					TbSiteCategory level3 = new TbSiteCategory();
					level3.setCategoryName(em.text());
					String url = em.select("a").first().attr("href");
					level3.setJdUrl(url);
					level3.setDataStatus(Long.valueOf(0));
					level3.setOrderNum(Long.valueOf(k));
					level3.setTreeNo(level2.getTreeNo()+String.valueOf(100+k));
					level3.setParent(level2);
					this.siteCategoryLogic.save(level3);
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
	private void getProduct(String url, TbSiteCategory cat, boolean isLoop) {
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
					//goods.setCategory(cat);
					goods.setGoodsName(elm.select("div.p-name > a").text());
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
					this.siteCategoryLogic.save(goods);
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
		TbSiteCategory category = this.siteCategoryLogic.get(TbSiteCategory.class, categoryId);
		this.siteCategoryLogic.bulkUpdate("delete from TbGoodsInfo t where t.category = ? ", new Object[]{category});
		this.getProduct(category.getCategoryUrl(), category,true);
		super.renderText(response, "ok");
		return null;
	}
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/site_category/index");
		TbSiteCategory rootCategory = this.siteCategoryLogic.getRootCategory();
		mav.addObject("rootId", rootCategory.getCategoryId());
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		//设置ROOT根节点信息
		TbSiteCategory rootGoodscat = this.siteCategoryLogic.getRootCategory();
		super.rootId = rootGoodscat.getCategoryId();
		super.rootTreeName = rootGoodscat.getCategoryName();
		return siteCategoryLogic.findSiteCategoryTree(rootGoodscat.getTreeNo());
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editCategory(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbSiteCategory entity = siteCategoryLogic.get(TbSiteCategory.class, goodscatId);
		super.renderJson(response, FreeMarkerUtil.process("shop.admin.goodscat.entity.ftl", entity));
		return null;
	}
	
	public ModelAndView onEditCategory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodscatId = super.getLong(request, "categoryId", false);
		TbSiteCategory entity = null;
		if(goodscatId.longValue()!=Long.valueOf(-99)){
			entity = siteCategoryLogic.get(TbSiteCategory.class, goodscatId);
		}else{
			entity = new TbSiteCategory();
		}
		super.bindObject(request, entity);
		Long parentGoodscatId = super.getLong(request, "parentCategoryId", false);
		TbSiteCategory parentGoodscat = siteCategoryLogic.load(TbSiteCategory.class, parentGoodscatId);
		entity.setParent(parentGoodscat);
		siteCategoryLogic.saveSiteCategory(entity);
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
	public ModelAndView selectCategory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		return new ModelAndView("/jsp/shop/admin/site_category/tree");
	}
	
	/**
	 * 新增商品分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addCategory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		return new ModelAndView("/jsp/shop/admin/site_category/add");
	}
	
	/**
	 * 删除商品分类资源
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteCategory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long goodscatId = super.getLong(request, "categoryId", false);		
		String result = this.siteCategoryLogic.deleteSiteCategory(goodscatId);
		super.renderText(response, result);
		return null;
	}

	/**
	 * @return the siteCategoryLogic
	 */
	public SiteCategoryLogic getSiteCategoryLogic() {
		return siteCategoryLogic;
	}

	/**
	 * @param siteCategoryLogic the siteCategoryLogic to set
	 */
	public void setSiteCategoryLogic(SiteCategoryLogic siteCategoryLogic) {
		this.siteCategoryLogic = siteCategoryLogic;
	}
	
	
}
