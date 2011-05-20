/**
 * 
 */
package com.eh.shop.front.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbSiteCategory;
import com.eh.shop.front.logic.FrontCacheLogic;
import com.eh.shop.front.vo.GoodsCategoryVo;

/**
 * 团购、菜篮子、家用电器、手机数码、家居厨具、潮流服饰、母婴用品
 * 显示首页信息
 */
public class IndexCtrl extends BaseCtrl {
	public static final Long PAGE_INDEX = Long.valueOf(1);
	/**
	 * 前端缓存LOGIC
	 */
	FrontCacheLogic frontCacheLogic;
	
	PageCategoryLogic pageCategoryLogic = null;
	
	SiteCategoryLogic siteCategoryLogic;
	
	/**
	 * 查找商品列表
	 * @param request
	 */
	private void findGoodList(HttpServletRequest request,Long siteCategoryId){
		List<TbPageCategory> categoryList = pageCategoryLogic.findPageCategoryByType(siteCategoryId);
		List categoryGoodsList = new ArrayList();
		for(int i = 0,len = categoryList.size();i<len;i++){
			GoodsCategoryVo vo = new GoodsCategoryVo();
			vo.setCategoryName(categoryList.get(i).getCategoryName());
			vo.setGoodsList(findGoodsByCategory(categoryList.get(i).getCategoryId(),Long.valueOf(8)));
			categoryGoodsList.add(vo);
		}
		request.setAttribute("categoryGoodsList", categoryGoodsList);
	}
	
	/**
	 * 查找商品列表by pageCategory
	 * @param categoryId
	 * @param showNum
	 * @return
	 */
	private List findGoodsByCategory(Long categoryId,Long showNum){
		List<TbGoodsInfo> goodsList = this.pageCategoryLogic.findGoodsByPageCategory(categoryId);
		return goodsList;
	}
	
	/**
	 * 查找导航栏列表
	 * @param request
	 * @param pageTypeId
	 */
	private void findNavList(HttpServletRequest request,Long pageTypeId){
		
	}
	
	/**
	 * 
	 * 设置头部信息
	 * @param request
	 */
	private void findHeadNavSubByUrl(HttpServletRequest request,String url,String attr){
		//查找首页下属分页
		/*StringBuffer html = new StringBuffer();
		List subList = this.goodsCategoryLogic.findCategoryListByUrl(url);
		for(int i = 0,len = subList.size();i<len;i++){
			TbSiteCategory category = (TbSiteCategory)subList.get(i);
			html.append(" <dl>");
			html.append("<dt><a href=\"");
			html.append(category.getCategoryUrl());
			html.append("\">");
			html.append(category.getCategoryName());
			html.append("</a></dt>");	
			List ddList = this.goodsCategoryLogic.findCategoryListByTreeNo(category.getTreeNo(), Constants.SYSTEM_SHOP);
			if(ddList.size()>0){
				html.append("<dd>");
				for(int j = 0,lenj = ddList.size();j<lenj;j++){
					TbSiteCategory dd = (TbSiteCategory)ddList.get(j);
					html.append("<a href=\"");
					html.append(dd.getCategoryUrl());
					html.append("\">");
					html.append(dd.getCategoryName());
					html.append("</a>");
				}
				html.append("</dd>");
			}
			html.append("</dl>");
		}
		request.setAttribute(attr, html.toString());*/
	}
	
	/**
	 * 查找头部导航信息
	 * @param request
	 */
	public void findHeadNavSub(HttpServletRequest request){
		this.findHeadNavSubByUrl(request, "/electronic", "electronic");
		this.findHeadNavSubByUrl(request, "/digital", "digital");
		this.findHeadNavSubByUrl(request, "/clothing", "clothing");
	}
	
	/**
	 * 首页显示
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		findGoodList(request, PAGE_INDEX);
		return new ModelAndView("/jsp/shop/front/index");
	}
	
	/**
	 * 获取商品明细
	 * @param detailUrl
	 * @param goods
	 */
	private void getProductDetail(HttpServletRequest request,TbGoodsInfo goods){
		String url = goods.getJdUrl();
		String fix = url.substring(0, 4);
		if (StringUtils.isNotBlank(url)) {
			String realurl = "";
			if (!("http".equals(fix))) {
				realurl = "http://www.360buy.com/" + url;
			} else {
				realurl = url;
			}
			try {
				Document doc = Jsoup.connect(realurl).get();
				Elements elms = doc.select("div.mc > div.content");
				//goods.setGoodsDesc(elms.get(0).html());
				
				Elements imgs = doc.select("div#spec-list > ul  > li > img");
				//System.out.println(imgs);
				List imageList = new ArrayList();
				for (int j = 0,lenj = imgs.size();j<lenj;j++) {
					Element img = (Element)imgs.get(j);
					imageList.add(img.attr("src"));
				}
				request.setAttribute("imageList", imageList);
				
				Elements bigphoto = doc.select("div#spec-n1 > img");
				request.setAttribute("bigphoto", bigphoto.get(0).attr("src"));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 产品
	 */
	public ModelAndView product(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/product");
		findGoodList(request, PAGE_INDEX);
		findHeadNavSub(request);
		Long productId = super.getLong(request, "productId", true);
		TbGoodsInfo product = this.siteCategoryLogic.get(TbGoodsInfo.class, productId);
		//查找产品图片信息
		this.getProductDetail(request,product);
		this.siteCategoryLogic.save(product);
		mav.addObject("product", product);
		
		//获取分类
		//http://img14.360buyimg.com/n5/
		
		return mav;
	}
	
	/**
	 * 大的分类
	 *
	 
	 
	 <div class="mt"><h2>电脑、软件、办公</h2></div>
				<div class="mc">
                    <div class="item current">
                    <h3><b></b><a href="http://www.360buy.com/products/670-671-000.html">电脑整机</a></h3>
                    <ul>
                    <li><a href="http://www.360buy.com/products/670-671-672-0-0-0-0-0-0-0-1-1-1.html">笔记本</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-1105-0-0-0-0-0-0-0-1-1-1.html">上网本</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-2694-0-0-0-0-0-0-0-1-1-1.html">平板电脑</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-673-0-0-0-0-0-0-0-1-1-1.html">台式机</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-674-0-0-0-0-0-0-0-1-1-1.html">服务器</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-675-0-0-0-0-0-0-0-1-1-1.html">笔记本配件</a></li>
                    </ul>
                    </div>
				</div>
				
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView category(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/category");
		Long categoryId = super.getLong(request, "categoryId", false);		
		TbSiteCategory category = this.siteCategoryLogic.get(TbSiteCategory.class, categoryId);
		List<TbSiteCategory> categoryList = this.siteCategoryLogic.findCategoryListByTreeNo(category.getTreeNo());
		StringBuffer div = new StringBuffer("<div class=\"mt\"><h2>");
		div.append(category.getCategoryName());
		div.append("</h2></div><div class=\"mc\">");
		for (int i = 1, size = categoryList.size(); i < size; i++) {
			TbSiteCategory tmp = (TbSiteCategory)categoryList.get(i);
			//如果相等，则做循环
			if(tmp.getParent().getCategoryId().longValue()==category.getCategoryId().longValue()){
				div.append("<div class=\"item current\"><h3><b></b><a href=\"http://www.360buy.com/products/670-671-000.html\">");
				div.append(tmp.getCategoryName());
				div.append("</a></h3><ul>");
				this.loopCategory(categoryList, category.getCategoryId(), div);
				div.append("</ul></div>");
			}
		}
		div.append("</div>");
		mav.addObject("categoryList", div.toString());		
		findGoodList(request, categoryId);//分类
		return mav;
	}
	
	private void loopCategory(List<TbSiteCategory> categoryList,Long category,StringBuffer div){
		for (int i = 1, size = categoryList.size(); i < size; i++) {
			TbSiteCategory tmp = (TbSiteCategory)categoryList.get(i);
			if(tmp.getParent().getCategoryId().longValue()==category.longValue()){
				div.append("<li><a href=\"http://www.360buy.com/products/670-671-672-0-0-0-0-0-0-0-1-1-1.html\">");
				div.append(tmp.getCategoryName());
				div.append("</a></li>");
			}
		}
	}
	
	
	
	/**
	 * 产品分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView products(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/products");
		Long categoryId = super.getLong(request, "categoryId", false);		
		return mav;
	}
	
	/**
	 * @return the pageCategoryLogic
	 */
	public PageCategoryLogic getPageCategoryLogic() {
		return pageCategoryLogic;
	}

	/**
	 * @param pageCategoryLogic the pageCategoryLogic to set
	 */
	public void setPageCategoryLogic(PageCategoryLogic pageCategoryLogic) {
		this.pageCategoryLogic = pageCategoryLogic;
	}

	public SiteCategoryLogic getSiteCategoryLogic() {
		return siteCategoryLogic;
	}

	public void setSiteCategoryLogic(SiteCategoryLogic siteCategoryLogic) {
		this.siteCategoryLogic = siteCategoryLogic;
	}

	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}

	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}
}
