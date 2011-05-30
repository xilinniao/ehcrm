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
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.entity.TbSiteCategory;

/**
 * 生成数据
 * 
 * @author zhoucl
 * 
 */
public class MakeShopInfo {

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

		String[] catName = { "旗舰店", "精品店", "优质服务店", "专卖店","金巢店","赣东大道店","南湖路","扬名路","湖北路","四川路","河南路","玉山路","速递路","士大路","第三方路"  };
		for (TbSiteCategory next : categoryList) {
			
			
			//
			for (int i = 0; i < catName.length; i++) {
				TbShopInfo shop = new TbShopInfo();
				shop.setShopName("抚州"+next.getCategoryName()+catName[i]);
				
				for(int x = 0;x<400;x++){
					List objList = siteCategoryLogic.find(
							"select min(t.goodsId),max(t.goodsId) from TbGoodsInfo t join t.siteCategory as sc where t.shopInfo is null and sc.treeNo like ? ",
							new Object[] { next.getTreeNo() + "%" });
					Object[] mm = (Object[]) objList.get(0);
					
					
					
					int nextint = MakeShopInfo.nextInt(((Long) mm[0]).intValue(),((Long) mm[1]).intValue());
					TbGoodsInfo goods = siteCategoryLogic.get(TbGoodsInfo.class, new Long(nextint));
					goods.setShopInfo(shop);
					siteCategoryLogic.save(goods);
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
