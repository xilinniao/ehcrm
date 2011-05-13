/**
 * 
 */
package com.eh.jingdong;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.eh.base.entity.TbAttachment;
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsImages;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbSiteCategory;

/**
 * @author zhoucl
 *
 */
public class ProductDetailThread extends Thread {
	ApplicationContext context;
	SiteCategoryLogic siteCategoryLogic ;
	TbGoodsInfo goods;
	
	@Override
	public void run() {
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
				goods.getExt().setGoodsDesc(elms.get(0).html());
				goods.setCreateUser(Long.valueOf(-1));				
				//System.out.println(elms.get(0).html());
				Elements imgs = doc.select("div#spec-list > ul  > li > img");
				List imageList = new ArrayList();
				for (int j = 0,lenj = imgs.size();j<lenj;j++) {
					Element img = (Element)imgs.get(j);
					String imageUrl = img.attr("src");
					//System.out.println(imageUrl);
					imageUrl = imageUrl.substring(imageUrl.indexOf(".com")+7);					
					TbAttachment attach = new TbAttachment();
					attach.setAttactType("goods");
					attach.setFilePathA("http://img11.360buyimg.com/n"+5+imageUrl);
					attach.setFilePathB("http://img11.360buyimg.com/n"+4+imageUrl);
					attach.setFilePathC("http://img11.360buyimg.com/n"+3+imageUrl);
					attach.setFilePathD("http://img11.360buyimg.com/n"+2+imageUrl);
					attach.setFilePathE("http://img11.360buyimg.com/n"+1+imageUrl);
					attach.setFilePathF("http://img11.360buyimg.com/n"+0+imageUrl);
					this.siteCategoryLogic.save(attach);
					
					//增加一条图片对应关系
					TbGoodsImages ga = new TbGoodsImages();
					ga.setAttachment(attach);
					ga.setGoodsInfo(goods);
					ga.setOrderNum(Long.valueOf(j));
					ga.setRelType(Constants.GOODS_ATTACHMENT_TYPE);
					siteCategoryLogic.save(ga);
				}
				this.siteCategoryLogic.save(goods);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getProduct() {
		
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
		siteCategoryLogic = (SiteCategoryLogic) context.getBean("siteCategoryLogic");
	}

	public TbGoodsInfo getGoods() {
		return goods;
	}

	public void setGoods(TbGoodsInfo goods) {
		this.goods = goods;
	}
}
