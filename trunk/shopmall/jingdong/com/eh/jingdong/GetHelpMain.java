package com.eh.jingdong;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eh.shop.admin.logic.SiteCategoryLogic;
import com.eh.shop.entity.TbArticleCategory;
import com.eh.shop.entity.TbArticleInfo;

public class GetHelpMain {

	/**
	 * 
	<div class=\"helpMainLeft\">
		<div class=\"helpLeftTitle\">帮助中心</div>
		<div class=\"helpLeftMenu\">
			<div class=\"helpLeftBar\"><span>购物指南</span></div>
			<ul class=\"helpLeftGroup\" id=\"buy_list\">
				<li><a href=\"zygw.html\">怎样购物</a></li>
				<li><a href=\"hyzd.html\">会员制度</a></li>
				<li><a href=\"jfzc.html\" class=\"choose\">积分政策</a></li>
				<li><a href=\"cjwt.html\">常见问题</a></li>
				<li><a href=\"zcxy.html\">注册协议</a></li>
			</ul>
			<div class=\"helpLeftBar\"><span>配送方式</span></div>
			<ul class=\"helpLeftGroup\" id=\"delivery_list\">
				<li><a href=\"hhzwl.html\">配送政策</a></li>
				<li><a href=\"spqs.html\">商品签收</a></li>
			</ul>
			<div class=\"helpLeftBar\"><span>支付方式</span></div>
			<ul class=\"helpLeftGroup\" id=\"pay_list\">
				<li><a href=\"hdfk.html\">货到付款</a></li>
				<li><a href=\"zxzf.html\">在线支付</a></li>
				<li><a href=\"yhdh.html\">银行电汇</a></li>
				<li><a href=\"fpzd.html\">发票制度</a></li>
			</ul>
			<div class=\"helpLeftBar\"><span>售后服务</span></div>
			<ul class=\"helpLeftGroup\" id=\"after_sale_list\">
				<li><a href=\"thhyz.html\">退换货政策</a></li>
				<li><a href=\"thlc.html\">退货流程</a></li>
				<li><a href=\"hhlc.html\">换货流程</a></li>
				<li><a href=\"lxwm.html\">联系我们</a></li>
			</ul>
			<div class=\"helpLeftBar\"><span>个人服务</span></div>
			<ul class=\"helpLeftGroup\" id=\"personal_list\">
				<li><a href=\"wddd.html\">订单中心</a></li>
				<li><a href=\"wdyhq.html\">优惠券</a></li>
				<li><a href=\"findpassbyemail.htm\" target=\"_blank\">找回密码</a></li>
			</ul>
		</div>
	</div>
	
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/applicationContext.xml",
						"/config/spring/bean-shop-admin.xml" });
		SiteCategoryLogic siteCategoryLogic = (SiteCategoryLogic) context.getBean("siteCategoryLogic");
		List<TbArticleCategory> categoryList = siteCategoryLogic.find("from TbArticleCategory t order by t.orderNum asc ", null);
		String div = "<div class=\"helpMainLeft\"><div class=\"helpLeftTitle\">帮助中心</div><div class=\"helpLeftMenu\">";
		for(TbArticleCategory category:categoryList){
			div+="<div class=\"helpLeftBar\"><span>"+category.getCategoryName()+"</span></div>";
			div+="<ul class=\"helpLeftGroup\">";
			List<TbArticleInfo> articleList = siteCategoryLogic.find("from TbArticleInfo t where t.category = ? order by orderNum asc", category);
			for(TbArticleInfo article:articleList){
				div+="<li><a href=\"<%=path%>/help/topic-"+article.getArticleUrl()+".html\">"+article.getTitle()+"</a></li>";
			}
			div+="</ul>";
		}
		div +="</div></div>";
		System.out.println(div);
	}
}
