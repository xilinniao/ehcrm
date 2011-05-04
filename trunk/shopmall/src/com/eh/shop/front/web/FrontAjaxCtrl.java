/**
 * 
 */
package com.eh.shop.front.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;

import com.eh.shop.admin.logic.CustAddrLogic;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.entity.TbGoodsInfoShort;
import com.eh.shop.front.cache.GoodsShort;
import com.eh.shop.front.logic.FrontCacheLogic;
import com.eh.shop.front.vo.CustInfo;

/**
 * 公共AJAX处理函数
 *
 */
public class FrontAjaxCtrl extends BaseFrontCtrl {
	GoodsLogic goodsLogic;
	CustAddrLogic custAddrLogic;	
	FrontCacheLogic frontCacheLogic;
	
	/**
	 * 获取商品信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView ajaxProduct(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String productId = super.getString(request, "productId", true);
		List productList = new ArrayList();
		String[] productIds = productId.split(",");
		StringBuffer json = new StringBuffer();
		for(int i = 0,len = productIds.length;i<len;i++){
			try{
				String[] tmp = productIds[i].split("=");//0为商品ID,1为商品订购数量
				if(tmp.length==2){
					Long goodsId = Long.parseLong(tmp[0]);
					GoodsShort product = this.frontCacheLogic.findGoodsShort(goodsId);				
					Map data = new HashMap();
					data.put("subId", goodsId);
					data.put("name", product.getName());
					data.put("price", product.getPriceStr());
					data.put("discountPrice", product.getDiscountPriceStr());
					data.put("cnt", Long.parseLong(tmp[1]));
					productList.add(data);
				}
			}catch(NumberFormatException ne){
			}
		}	
		super.renderText(response,JSONArray.fromObject(productList).toString());		
		return null;
	}
	
	/*public ModelAndView ajaxAddress(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo cust = super.getCustInfo(request);
		if(cust!=null){
			return null;
		}else{
			return null;
		}
	}*/
	
	/**
	 * 判断是否已登录,true已登录，false未登录
	 */
	public ModelAndView ajaxCheckLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustInfo custInfo = super.getCustInfo(request);
		Map data = new HashMap();
		data.put(STATUS, custInfo!=null);
		renderJson(response,JSONObject.fromObject(data).toString());
		return null;
	}
	
	/**
	 * 自动提示提醒
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView autoSuggestSearch(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String q = super.getString(request, "q", true);
		List<TbGoodsInfoShort> result = this.goodsLogic.findAutoSuggest(q);
		for (TbGoodsInfoShort good : result) {
			super.renderText(response, good.getGoodsName()+"|"+good.getGoodsId()+"\r\n");
		}
		super.renderText(response, "re|e");
		return null;
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

	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}

	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}
	
	
}
