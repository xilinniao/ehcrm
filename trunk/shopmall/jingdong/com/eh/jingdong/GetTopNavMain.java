package com.eh.jingdong;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbSiteCategory;

public class GetTopNavMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/applicationContext.xml",
						"/config/spring/bean-shop-admin.xml" });
		SiteCategoryLogic siteCategoryLogic = (SiteCategoryLogic) context.getBean("siteCategoryLogic");
		
		List<TbSiteCategory> categoryList = siteCategoryLogic.findCategoryListByParentId(Long.valueOf(1));
		StringBuffer ul = new StringBuffer("<ul id=\"topnav\">");
		ul.append("<li><a href=\"<%=path%>/index.xhtml\" id=\"id_home\" class=\"home\">首页</a></li>");
		for(TbSiteCategory levela:categoryList){
			ul.append("<li><a href=\"<%=path%>/category/"+levela.getCategoryId()+"-"+levela.getCategoryId()+".html\" id=\"category_"+levela.getCategoryId()+"\" class=\"products\">"+levela.getCategoryName()+"</a><div class=\"sub\">");
			List<TbSiteCategory> listb = siteCategoryLogic.findCategoryListByParentId(levela.getCategoryId());
			for(TbSiteCategory levelb:listb){
				//ul.append("<dl><dt><a href=\"/category/"+levelb.getCategoryId()+".html\">"+levelb.getCategoryName()+"</a></dt><dd>");
				ul.append("<dl><dt>"+levelb.getCategoryName()+"</dt><dd>");
				List<TbSiteCategory> listc = siteCategoryLogic.findCategoryListByParentId(levelb.getCategoryId());
				for(TbSiteCategory levelc:listc){
					ul.append("<a href=\"<%=path%>/products/"+levelc.getCategoryId()+"-"+levela.getCategoryId()+".html\">"+levelc.getCategoryName()+"</a>");
				}
				ul.append("</dd></dl>");
			}
			ul.append("</div></li>");
		}
		ul.append("</ul>");
		System.out.println(ul.toString());
	}
}
