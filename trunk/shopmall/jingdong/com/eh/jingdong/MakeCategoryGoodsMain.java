package com.eh.jingdong;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbPageCategory;
import com.eh.shop.entity.TbPageGoodsRel;
import com.eh.shop.entity.TbSiteCategory;

/**
 * 生成数据
 * 
 * @author zhoucl
 * 
 */
public class MakeCategoryGoodsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/applicationContext.xml",
						"/config/spring/bean-shop-admin.xml" });
		SiteCategoryLogic siteCategoryLogic = (SiteCategoryLogic) context
				.getBean("siteCategoryLogic");
		
		List<TbSiteCategory> categoryList = siteCategoryLogic.findCategoryListByParentId(Long.valueOf(1));
		categoryList.add(siteCategoryLogic.get(TbSiteCategory.class, Long.valueOf(1)));

		String[] catName = { "新品上市", "疯狂抢购", "特价促销", "热门商品" };
		for (TbSiteCategory next : categoryList) {

			List objList = siteCategoryLogic
					.find(
							"select min(t.goodsId),max(t.goodsId) from TbGoodsInfo t join t.siteCategory as sc where sc.treeNo like ?",
							new Object[] { next.getTreeNo() + "%" });
			Object[] mm = (Object[]) objList.get(0);

			for (int i = 0; i < catName.length; i++) {
				TbPageCategory page = new TbPageCategory();
				page.setCategoryName(catName[i]);
				page.setIsShow(Long.valueOf(0));
				page.setSiteCategory(next);
				page.setOrderNum(new Long(i + 1));
				page.setShowNum(new Long(8+i*4));
				siteCategoryLogic.save(page);

				for (int j = 0; ((j < (8+i*4))&&(j<20)); j++) {
					TbPageGoodsRel rel = new TbPageGoodsRel();
					rel.setCreateTime(new Date());
					rel.setCreateUser(Long.valueOf(-1));
					rel.setOrderNum(new Long(j + 1));
					rel.setPageCategory(page);
					int rmid = MakeCategoryGoodsMain.nextInt(((Long) mm[0]).intValue(),
							((Long) mm[1]).intValue());
					TbGoodsInfo goodsInfo = siteCategoryLogic.get(TbGoodsInfo.class, new Long(rmid));
					rel.setGoodsInfo(goodsInfo);
					siteCategoryLogic.save(rel);
				}
			}
		}
		
	}
	
	
	private static int nextInt(int min, int max) {
		Random rand = new Random();
		int value = 0;
		while (value < min) {
			value = rand.nextInt(max);
		}
		return value;
	}
}
