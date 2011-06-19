/**
 * 
 */
package com.eh.jingdong;

import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.java4less.ocr.tess3.OCRFacade;

/**
 * @author zhoucl
 *
 */
public class PriceThread extends Thread {
	ApplicationContext context;
	SiteCategoryLogic siteCategoryLogic ;
	String urla;
	TbGoodsInfo goodsInfo;
	
	public PriceThread() {
		super();

	}
/*
	@Override
	public void run() {
		getProduct();
	}*/

	public void getProduct() {
		String url = goodsInfo.getJdUrl();
		
		url = url.substring(url.lastIndexOf("/")+1);
		url = url.substring(0, url.indexOf("."));
		url = "http://price.360buyimg.com/gp"+url+",3.png";
		
		System.out.print(url);
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		byte[] data = null;
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				data = getMethod.getResponseBody();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(data!=null){
			OCRFacade facade = new OCRFacade();
			try {
				String rmb = StringUtils.trim(facade.recognizeImage(data, "png","eng"));
				rmb = rmb.substring(1);
				Double drmb = Double.parseDouble(rmb);
				siteCategoryLogic
						.bulkUpdate(
								"update TbGoodsInfoSub t set t.discountPrice = ? , t.marketPrice = ? where t.goods = ? ",
								new Object[] { drmb, drmb * 1.05, goodsInfo });
				
				goodsInfo.setCreateTime(new Date());
				siteCategoryLogic.save(goodsInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
		siteCategoryLogic = (SiteCategoryLogic) context.getBean("siteCategoryLogic");
	}

	public String getUrla() {
		return urla;
	}

	public void setUrla(String urla) {
		this.urla = urla;
	}

	public TbGoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(TbGoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

}
