/**
 * 
 */
package com.eh.shop.front.web;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.util.Constants;
import com.eh.base.util.CookieUtils;
import com.eh.shop.admin.logic.CustAddrLogic;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.entity.TbCustInfo;
import com.eh.shop.entity.TbOrderMain;
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.front.vo.CustInfo;

/**
 * @author zhoucl
 *
 */
public class OrderCtrl extends BaseFrontCtrl {
	GoodsLogic goodsLogic;
	CustAddrLogic custAddrLogic;
	OrderLogic orderLogic;
	
	public ModelAndView shoppingcart(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//获取COOKIE信息
		Cookie cookie = CookieUtils.getCookie(request, "cartitems");
		String products = URLDecoder.decode(cookie.getValue(), "UTF-8");
		List productList = goodsLogic.findGoodsForPrice(products);
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shopping_cart");
		mav.addObject("productList", productList);
		return mav;
	}
	
	public ModelAndView checkout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo cust = super.getCustInfo(request);
		if(cust!=null){
			Cookie cookie = CookieUtils.getCookie(request, "cartitems");
			String products = URLDecoder.decode(cookie.getValue(), "UTF-8");
			List productList = goodsLogic.findGoodsForPrice(products);		
			
			//取客户常用地址
			List addrList = this.custAddrLogic.findAddrListByCustId(cust.getCustId());
			ModelAndView mav = new ModelAndView("/jsp/shop/front/checkout");
			mav.addObject("productList", productList);
			mav.addObject("addrList", addrList);
			mav.addObject("addr_json", JSONArray.fromObject(addrList).toString());
			return mav;
		}else{
			//转向登录页面
			return gotoLogin(request);
		}
	}
	
	/**
	 * checkout 操作
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView oncheckout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo cust = super.getCustInfo(request);
		if(cust!=null){
			Long shopId = super.getLong(request, "shopId", false);
			Long[] productIds = super.getLongs(request, "productId", false);//产品IDS
			Long[] cnt = super.getLongs(request, "cnt", false);//数量S
			Long usesScore = super.getLong(request, "uses_score", false);//使用积分
			TbShopInfo shop = orderLogic.get(TbShopInfo.class, shopId);
			TbCustInfo custInfo = orderLogic.get(TbCustInfo.class, cust.getCustId());
			
			TbOrderMain main = new TbOrderMain();
			super.bindObject(request, main);
			main.setShopInfo(shop);
			main.setCustInfo(custInfo);
			main.setUsesScore(usesScore);
			main.setOrderStatus(Constants.ORDER_STATUS_CUST_INPUT);
			main.setOrderTime(new Date());
			this.orderLogic.addOrder(main, productIds, cnt);		
			return new ModelAndView("/jsp/shop/front/checkout_success");
		}else{
			return super.gotoLogin(request);//按道理不会到这部，前台有判断是否登录操作
		}
	}
	
	/**
	 * 订单详情
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView orderdetails(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/shop/front/order_details");
	}

	/**
	 * @return the goodsLogic
	 */
	public GoodsLogic getGoodsLogic() {
		return goodsLogic;
	}

	/**
	 * @param goodsLogic the goodsLogic to set
	 */
	public void setGoodsLogic(GoodsLogic goodsLogic) {
		this.goodsLogic = goodsLogic;
	}

	/**
	 * @return the custAddrLogic
	 */
	public CustAddrLogic getCustAddrLogic() {
		return custAddrLogic;
	}

	/**
	 * @param custAddrLogic the custAddrLogic to set
	 */
	public void setCustAddrLogic(CustAddrLogic custAddrLogic) {
		this.custAddrLogic = custAddrLogic;
	}

	/**
	 * @return the orderLogic
	 */
	public OrderLogic getOrderLogic() {
		return orderLogic;
	}

	/**
	 * @param orderLogic the orderLogic to set
	 */
	public void setOrderLogic(OrderLogic orderLogic) {
		this.orderLogic = orderLogic;
	}
	
	
}
