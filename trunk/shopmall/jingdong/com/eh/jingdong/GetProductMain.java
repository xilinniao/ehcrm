package com.eh.jingdong;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbSiteCategory;

public class GetProductMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/applicationContext.xml",
						"/config/spring/bean-shop-admin.xml" });
		SiteCategoryLogic siteCategoryLogic = (SiteCategoryLogic) context.getBean("siteCategoryLogic");
		
		List<TbSiteCategory> categoryList = siteCategoryLogic.find("from TbSiteCategory t where t.jdUrl is not null order by t.treeNo",null);
		
		for(TbSiteCategory next:categoryList){
			ProductThread productThread = new ProductThread();
			productThread.setContext(context);
			productThread.setCata(next);
			productThread.setUrla(next.getJdUrl());
			productThread.start();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
