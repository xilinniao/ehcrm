/**
 * 
 */
package com.eh.shop.front.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.logic.FrontCacheLogic;
import com.eh.shop.front.vo.CustInfo;

/**
 * @author zhoucl
 *
 */
public class OrderCtrl extends BaseFrontCtrl {
	GoodsLogic goodsLogic;
	CustAddrLogic custAddrLogic;
	OrderLogic orderLogic;
	FrontCacheLogic frontCacheLogic;
	
	/**
	 * 购物车
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView shoppingcart(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shopping_cart");		
		//获取COOKIE信息
		List productList = findCartItems(request);
		mav.addObject("productList", productList);		
		return mav;
	}
	
	/**
	 * 查找购物车中商品数量
	 */
	private List findCartItems(HttpServletRequest request){
		//获取COOKIE信息
		Cookie cookie = CookieUtils.getCookie(request, "cartitems");
		if(cookie!=null){
			String cartList = "";
			try {
				cartList = URLDecoder.decode(cookie.getValue(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String[] productIds = cartList.split(",");
			
			List productList = new ArrayList();
			for(int i = 0,len = productIds.length;i<len;i++){
				try{
					String[] tmp = productIds[i].split("=");//0为商品ID,1为商品订购数量
					if(tmp.length==2){
						Long productId = Long.parseLong(tmp[0]);
						Long cnt = Long.parseLong(tmp[1]);
						GoodsShort product = frontCacheLogic.findGoodsShort(productId, true);
						if(product!=null){
							Map data = new HashMap();
							data.put("subGoodsId", productId);
							data.put("goodsId", product.getGoodsId());
							data.put("goodsName", product.getName());
							data.put("price", product.getPriceStr());
							data.put("discountPrice", product.getDiscountPriceStr());
							data.put("cnt", Long.parseLong(tmp[1]));
							data.put("imagea", product.getImageA());
							data.put("imageb", product.getImageB());
							data.put("imagec", product.getImageC());
							data.put("imaged", product.getImageD());
							data.put("imagee", product.getImageE());
							data.put("imagef", product.getImageF());
							productList.add(data);
						}
					}
				}catch(NumberFormatException ne){
					//忽略
				}
			}
			return productList;
		}else{
			return null;
		}
	}
	
	public ModelAndView checkout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo cust = super.getCustInfo(request);
		if(cust!=null){
			List productList = this.findCartItems(request);
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
			//移除COOKIE
			CookieUtils.removeCookie(response,"cartitems");			
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

	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}

	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}
	
	
}
