package com.eh.jingdong;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbGoodsInfo;

public class GetPriceMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/applicationContext.xml",
						"/config/spring/bean-shop-admin.xml" });
		GoodsLogic goodsLogic = (GoodsLogic) context.getBean("goodsLogic");
		GoodsInfoQry qry = new GoodsInfoQry();
		qry.setPageSize(20);
		int i=0;
		while(true){
			i++;
			qry.setPageNo(i);
			List<TbGoodsInfo> goodsList = goodsLogic.findGoodsListForJingDongPrice(qry).getResult();
			
			if(goodsList.size()>0){
				for(TbGoodsInfo next:goodsList){
					PriceThread detailThread = new PriceThread();
					detailThread.setContext(context);
					detailThread.setGoodsInfo(next);
					detailThread.getProduct();
					//detailThread.run();
					
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				break;
			}
		}
	}

}
