/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.VelocityUtils;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.GoodsLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbGoodsCategory;

/**
 * 商品管理
 * @author zhoucl
 *
 */
public class GoodsInfoCtrl extends BaseCtrl {
	GoodsLogic goodsLogic;
	/**
	 * 商品管理首页
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods/index.jsp");
		mav.addObject("rootId",userInfo.getShopInfo().getShopId());
		return mav;
	}
	
	/**
	 * 商品分类
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goodsList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		GoodsInfoQry qry = new GoodsInfoQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		if(StringUtils.isBlank(qry.getTreeNo())){
			TbGoodsCategory category = this.goodsLogic.load(TbGoodsCategory.class, qry.getCategoryId());
			qry.setTreeNo(category.getTreeNo());
		}
		Page page = goodsLogic.findGoodsList(qry);
		Map data = super.getParameterMap(request);
		data.put("page", page);
		renderJson(response,VelocityUtils.render("shop-admin-goods-info-list", data),null);
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
	
	
}
