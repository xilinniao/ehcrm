/**
 * 
 */
package com.eh.shop.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.GoodsRemarkLogic;
import com.eh.shop.admin.web.qry.GoodsRemarkQry;
import com.eh.shop.entity.TbGoodsRemark;



public class GoodsRemarkCtrl extends BaseShopAdminCtrl {
	GoodsRemarkLogic goodsRemarkLogic = null;


	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_remark/index");
		
		GoodsRemarkQry qry = new GoodsRemarkQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = goodsRemarkLogic.findPage(qry);
		mav.addObject("page", page);
		return mav;
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_remark/edit");
		TbGoodsRemark entity = new TbGoodsRemark();
		entity.setRecId(Constants.ADD_PK_ID);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_remark/edit");
		Long recId = super.getLong(request, "recId", false);
		// 修改操作
		TbGoodsRemark entity = this.goodsRemarkLogic.get(TbGoodsRemark.class, recId);
		mav.addObject("entity", entity);
		return mav;
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long recId = super.getLong(request, "recId", false);
		
		if(recId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbGoodsRemark entity = new TbGoodsRemark();
			super.bindObject(request,entity);
			this.goodsRemarkLogic.saveGoodsRemark(entity);
		}else{
			//修改操作
			TbGoodsRemark entity = this.goodsRemarkLogic.get(TbGoodsRemark.class, recId);
			if(entity!=null){
				super.bindObject(request, entity);
				goodsRemarkLogic.saveGoodsRemark(entity);
			}else{
				super.addErrors(request, "非法操作");
			}
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " goodsRemark.xhtml?method=index");
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
		/*Long recId = super.getLong(request, "recId", false);
		TbGoodsRemark entity = goodsRemarkLogic.get(TbGoodsRemark.class, recId);
		if(entity!=null){
			String result = goodsRemarkLogic.deleteRecId(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作");
		}		*/
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " goodsRemark.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the goodsRemarkLogic
	 */
	public GoodsRemarkLogic getGoodsRemarkLogic() {
		return goodsRemarkLogic;
	}

	/**
	 * @param goodsRemarkLogic the goodsRemarkLogic to set
	 */
	public void setGoodsRemarkLogic(GoodsRemarkLogic goodsRemarkLogic) {
		this.goodsRemarkLogic = goodsRemarkLogic;
	}
}