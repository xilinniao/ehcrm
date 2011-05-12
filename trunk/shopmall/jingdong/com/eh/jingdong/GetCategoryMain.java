package com.eh.jingdong;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbSiteCategory;

public class GetCategoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/applicationContext.xml",
						"/config/spring/bean-shop-admin.xml" });
		SiteCategoryLogic siteCategoryLogic = (SiteCategoryLogic) context
				.getBean("siteCategoryLogic");
		siteCategoryLogic.bulkUpdate(
				"delete from TbSiteCategory t where t.categoryId <> 1 ",
				new Object[] {});
		
		Document doc = null;
		try {
			doc = Jsoup.connect("http://www.360buy.com/allSort.aspx")
					.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elms = doc.select("div.m");
		for (int i = 1, len = elms.size(); i < len; i++) {
			Element bc = (Element) elms.get(i);
			// 插入主分类
			TbSiteCategory level1 = new TbSiteCategory();
			level1
					.setCategoryName(bc.select("div.mt > h2  > a").first()
							.text());
			level1.setDataStatus(Long.valueOf(0));
			level1.setOrderNum(Long.valueOf(i));
			level1.setTreeNo("001" + String.valueOf(100 + i));
			level1.setParent(siteCategoryLogic.load(TbSiteCategory.class, Long.valueOf(1)));
			siteCategoryLogic.save(level1);

			// 二级分类
			Element mc = bc.select("div.mc").first();
			Elements dls = mc.select("dl");
			for (int j = 0, lenj = dls.size(); j < lenj; j++) {
				Element dl = (Element) dls.get(j);
				TbSiteCategory level2 = new TbSiteCategory();
				level2.setCategoryName(dl.select("dt").first().text());
				level2.setDataStatus(Long.valueOf(0));
				level2.setOrderNum(Long.valueOf(j));
				level2.setTreeNo(level1.getTreeNo() + String.valueOf(100 + j));
				level2.setParent(level1);
				siteCategoryLogic.save(level2);

				Elements ems = dl.select(" dd > em");
				for (int k = 0, lenk = ems.size(); k < lenk; k++) {
					Element em = (Element) ems.get(k);
					TbSiteCategory level3 = new TbSiteCategory();
					level3.setCategoryName(em.text());
					String url = em.select("a").first().attr("href");
					level3.setJdUrl(url);
					level3.setDataStatus(Long.valueOf(0));
					level3.setOrderNum(Long.valueOf(k));
					level3.setTreeNo(level2.getTreeNo()
							+ String.valueOf(100 + k));
					level3.setParent(level2);
					siteCategoryLogic.save(level3);
				}
			}
		}
	}
}
