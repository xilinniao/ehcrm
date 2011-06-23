/**
 * 
 */
package com.eh.shop.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.GoodsQaLogic;
import com.eh.shop.admin.web.qry.GoodsQaQry;
import com.eh.shop.entity.TbGoodsQa;



public class GoodsQaCtrl extends BaseShopAdminCtrl {
	GoodsQaLogic goodsQaLogic = null;


	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_qa/index");
		
		GoodsQaQry qry = new GoodsQaQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = goodsQaLogic.findPage(qry);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_qa/edit");
		TbGoodsQa entity = new TbGoodsQa();
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/goods_qa/edit");
		Long recId = super.getLong(request, "recId", false);
		// 修改操作
		TbGoodsQa entity = this.goodsQaLogic.get(TbGoodsQa.class, recId);
		mav.addObject("entity", entity);
		return mav;
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long recId = super.getLong(request, "recId", false);
		
		if(recId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbGoodsQa entity = new TbGoodsQa();
			super.bindObject(request,entity);
			this.goodsQaLogic.saveGoodsQa(entity);
		}else{
			//修改操作
			TbGoodsQa entity = this.goodsQaLogic.get(TbGoodsQa.class, recId);
			if(entity!=null){
				super.bindObject(request, entity);
				goodsQaLogic.saveGoodsQa(entity);
			}else{
				super.addErrors(request, "非法操作");
			}
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " tuanInfo.xhtml?method=index");
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
		Long recId = super.getLong(request, "recId", false);
		/*TbGoodsQa entity = goodsQaLogic.get(TbGoodsQa.class, recId);
		if(entity!=null){
			String result = goodsQaLogic.deleteRecId(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作");
		}	*/	
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " tuanInfo.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the goodsQaLogic
	 */
	public GoodsQaLogic getGoodsQaLogic() {
		return goodsQaLogic;
	}

	/**
	 * @param goodsQaLogic the goodsQaLogic to set
	 */
	public void setGoodsQaLogic(GoodsQaLogic goodsQaLogic) {
		this.goodsQaLogic = goodsQaLogic;
	}
}