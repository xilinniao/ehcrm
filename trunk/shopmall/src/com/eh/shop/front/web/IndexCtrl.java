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
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.GoodsCatLogic;
import com.eh.shop.admin.logic.PageCategoryLogic;
import com.eh.shop.entity.TbGoodsCategory;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.front.vo.GoodsCategoryVo;

/**
 * 团购、菜篮子、家用电器、手机数码、家居厨具、潮流服饰、母婴用品
 * 显示首页信息
 */
public class IndexCtrl extends BaseCtrl {
	public static final Long PAGE_INDEX = Long.valueOf(1);
	
	PageCategoryLogic pageCategoryLogic = null;
	
	GoodsCatLogic goodsCatLogic;
	
	/**
	 * 查找商品列表
	 * @param request
	 */
	private void findGoodList(HttpServletRequest request,Long pageTypeId){
		List<TbPageCategory> categoryList = pageCategoryLogic.findPageCategoryByType(Constants.SYSTEM_SHOP, pageTypeId);
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
	 * <dl class="">
        <dt><a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12002&amp;nLevel=2" title="潮流女鞋">潮流女鞋</a></dt>
        <dd>
                   <a href="http://mall.woyo.com/search/%E5%A5%B3%E9%9E%8B.shtml" title="女鞋">女鞋</a>
           <a href="http://mall.woyo.com/search/%E8%BF%90%E5%8A%A8%E9%9E%8B%20%E5%A5%B3.shtml" title="运动鞋">运动鞋</a>
           <a href="http://mall.woyo.com/search/%E5%8D%95%E9%9E%8B%20%E5%A5%B3.shtml" title="单鞋">单鞋</a>
           <a href="http://mall.woyo.com/search/%E6%9D%BF%E9%9E%8B%20%E5%A5%B3.shtml" title="板鞋">板鞋</a>
                           </dd>
      </dl>
      
	 * 设置头部信息
	 * @param request
	 */
	private void findHeadNavSubByUrl(HttpServletRequest request,String url,String attr){
		//查找首页下属分页
		/*StringBuffer html = new StringBuffer();
		List subList = this.goodsCatLogic.findCategoryListByUrl(url);
		for(int i = 0,len = subList.size();i<len;i++){
			TbGoodsCategory category = (TbGoodsCategory)subList.get(i);
			html.append(" <dl>");
			html.append("<dt><a href=\"");
			html.append(category.getCategoryUrl());
			html.append("\">");
			html.append(category.getCategoryName());
			html.append("</a></dt>");	
			List ddList = this.goodsCatLogic.findCategoryListByTreeNo(category.getTreeNo(), Constants.SYSTEM_SHOP);
			if(ddList.size()>0){
				html.append("<dd>");
				for(int j = 0,lenj = ddList.size();j<lenj;j++){
					TbGoodsCategory dd = (TbGoodsCategory)ddList.get(j);
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
		findHeadNavSub(request);
		return new ModelAndView("/jsp/shop/front/index");
	}
	
	/**
	 * 团购栏目
	 */
	public ModelAndView tuan(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/tuan");
	}
	
	/**
	 * 菜篮子
	 */
	public ModelAndView food(HttpServletRequest request,HttpServletResponse response) throws Exception {
		findGoodList(request, PAGE_INDEX);
		findHeadNavSub(request);
		return new ModelAndView("/jsp/shop/front/food");
	}
	
	/**
	 * 家电
	 */
	public ModelAndView electronic(HttpServletRequest request,HttpServletResponse response) throws Exception {
		findGoodList(request, PAGE_INDEX);
		findHeadNavSub(request);
		return new ModelAndView("/jsp/shop/front/electronic");
	}
	
	/**
	 * 数码产品
	 */
	public ModelAndView digital(HttpServletRequest request,HttpServletResponse response) throws Exception {
		findGoodList(request, PAGE_INDEX);
		return new ModelAndView("/jsp/shop/front/digital");
	}
	
	/**
	 * 家居家纺
	 */
	public ModelAndView home(HttpServletRequest request,HttpServletResponse response) throws Exception {
		findGoodList(request, PAGE_INDEX);
		return new ModelAndView("/jsp/shop/front/home");
	}
	
	/**
	 * 服饰
	 */
	public ModelAndView clothing(HttpServletRequest request,HttpServletResponse response) throws Exception {
		findGoodList(request, PAGE_INDEX);
		return new ModelAndView("/jsp/shop/front/clothing");
	}
	
	/**
	 * 母婴
	 */
	public ModelAndView baby(HttpServletRequest request,HttpServletResponse response) throws Exception {
		findGoodList(request, PAGE_INDEX);
		return new ModelAndView("/jsp/shop/front/baby");
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
				goods.setGoodsDesc(elms.get(0).html());
				
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
		TbGoodsInfo product = this.goodsCatLogic.get(TbGoodsInfo.class, productId);		
		//查找产品图片信息
		this.getProductDetail(request,product);
		this.goodsCatLogic.save(product);
		mav.addObject("product", product);
		
		//获取分类
		
		//http://img14.360buyimg.com/n5/
		
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
}
