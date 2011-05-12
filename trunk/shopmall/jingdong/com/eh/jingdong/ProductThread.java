/**
 * 
 */
package com.eh.jingdong;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.eh.base.entity.TbAttachment;
import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbSiteCategory;

/**
 * @author zhoucl
 *
 */
public class ProductThread extends Thread {
	ApplicationContext context;
	SiteCategoryLogic siteCategoryLogic ;
	String urla;
	TbSiteCategory cata;
	
	@Override
	public void run() {
		this.getProduct(urla, cata, true);
	}

	private void getProduct(String url, TbSiteCategory cat, boolean isLoop) {
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
				Elements elms = doc.select("ul.list-h > li");

				for (int i = 0, len = elms.size(); i < len; i++) {
					Element elm = (Element) elms.get(i);
					TbGoodsInfo goods = new TbGoodsInfo();
					goods.setSiteCategory(cat);
					goods.setGoodsName(elm.select("div.p-name > a").text());
					String imageUrl = elm.select("div.p-img > a > img").attr(
							"src");
					if (StringUtils.isBlank(imageUrl)) {
						imageUrl = elm.select("div.p-img > a > img").attr(
								"src2");
					}
					
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
					goods.setFaceImage(attach);
					
					//原价
					//String orgPrice = elm.select("div.p-price > del").text().substring(1);
					goods.setMarketPrice(0.0);
					
					goods.setJdUrl(elm.select("div.p-name > a").attr("href"));
					this.siteCategoryLogic.save(goods);
				}

				if (isLoop) {
					int pageSize = 0;
					// 获取页数
					Elements page = doc.select("div.m > div.pagin > a ");
					for (int i = 0, len = page.size(); i < len; i++) {
						Element elm = (Element) page.get(i);
						// System.out.println(elm.text());
						if (NumberUtils.isDigits(elm.text())) {
							pageSize = Integer.parseInt(elm.text());
						}
					}
					//System.out.println(pageSize);
					for (int i = 1; i < pageSize; i++) {
						String newUrl = realurl.substring(0,
								realurl.length() - 6);
						newUrl += (i + 1);
						newUrl += realurl.substring(realurl.length() - 5);
						getProduct(newUrl, cat, false);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				this.getProduct(url, cat, isLoop);
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

	public TbSiteCategory getCata() {
		return cata;
	}

	public void setCata(TbSiteCategory cata) {
		this.cata = cata;
	}
}
