/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.util.VelocityUtils;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.BrandInfoLogic;
import com.eh.shop.admin.web.qry.BrandInfoQry;
import com.eh.shop.entity.TbBrandInfo;
import com.eh.shop.entity.TbGoodsInfo;

/**
 * 品牌控制类
 * @author zhoucl
 *
 */
public class BrandInfoCtrl extends BaseShopAdminCtrl {
	BrandInfoLogic brandInfoLogic = null;
	/**
	 * 首页
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/brand/index");
		return mav;
	}
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		BrandInfoQry qry = new BrandInfoQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = this.brandInfoLogic.findBrandList(qry);
		Map data = super.getParameterMap(request);
		data.put("page", page);
		renderJson(response, VelocityUtils.render("shop-admin-brand-info-list",
				data));
		return null;
	}
	
	/**
	 * 新增
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/brand/edit");
		TbBrandInfo entity = new TbBrandInfo();
		entity.setBrandId(Constants.ADD_PK_ID);
		mav.addObject("entity", entity);
		return mav;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/brand/edit");
		Long brandId = super.getLong(request, "brandId", false);
		// 修改操作
		TbBrandInfo entity = this.brandInfoLogic.get(TbBrandInfo.class, brandId);
		if(entity!=null&&isYourShop(entity.getShopInfo(), userInfo)){
			mav.addObject("entity", entity);
			return mav;
		}else{
			//设置错误信息
			super.addErrors(request, "非法操作，没有找到指定的商品信息");
			return new ModelAndView(REDIRECT_URL);
		}
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long brandId = super.getLong(request, "brandId", false);
		
		if(brandId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbBrandInfo entity = new TbBrandInfo();
			super.bindObject(request,entity);
			entity.setShopInfo(userInfo.getShopInfo());
			this.brandInfoLogic.saveBrandInfo(entity);
		}else{
			//修改操作
			TbBrandInfo entity = this.brandInfoLogic.get(TbBrandInfo.class, brandId);
			if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
				super.bindObject(request, entity);
				this.brandInfoLogic.saveBrandInfo(entity);
			}else{
				super.addErrors(request, "非法操作，没有找到指定的品牌");
			}
		}
		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", "brandInfo.xhtml?method=index");
		return mav;
	}
	
	/**
	 * 删除操作
	 * @param request 
	 * @param response  
	 * @return 
	 * @throws Exception
	 */
	public ModelAndView onDelete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long brandId = super.getLong(request, "brandId", false);
		TbBrandInfo entity = this.brandInfoLogic.get(TbBrandInfo.class, brandId);
		if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
			String result = this.brandInfoLogic.deleteBrandInfo(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作，没有找到指定的品牌");
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", "brandInfo.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the brandInfoLogic
	 */
	public BrandInfoLogic getBrandInfoLogic() {
		return brandInfoLogic;
	}

	/**
	 * @param brandInfoLogic the brandInfoLogic to set
	 */
	public void setBrandInfoLogic(BrandInfoLogic brandInfoLogic) {
		this.brandInfoLogic = brandInfoLogic;
	}
}
