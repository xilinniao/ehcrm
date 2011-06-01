/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.TuanApplyLogic;
import com.eh.shop.admin.web.qry.TuanApplyQry;
import com.eh.shop.entity.TbTuanApply;



public class TuanApplyCtrl extends BaseShopAdminCtrl {
	TuanApplyLogic tuanApplyLogic = null;


	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_apply/index");
		TuanApplyQry qry = new TuanApplyQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = tuanApplyLogic.findPage(qry);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_apply/edit");
		TbTuanApply entity = new TbTuanApply();
		entity.setApplyId(Constants.ADD_PK_ID);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_apply/edit");
		Long applyId = super.getLong(request, "applyId", false);
		// 修改操作
		TbTuanApply entity = this. tuanApplyLogic.get(TbTuanApply.class, applyId);
		mav.addObject("entity", entity);
		return mav;
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long applyId = super.getLong(request, "applyId", false);
		
		if(applyId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbTuanApply entity = new TbTuanApply();
			super.bindObject(request,entity);
			this.tuanApplyLogic.saveTuanApply(entity);
		}else{
			//修改操作
			TbTuanApply entity = this.tuanApplyLogic.get(TbTuanApply.class, applyId);
			if(entity!=null){
				super.bindObject(request, entity);
				this. tuanApplyLogic.saveTuanApply(entity);
			}else{
				super.addErrors(request, "非法操作");
			}
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " tuanApply.xhtml?method=index");
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
		Long applyId = super.getLong(request, "applyId", false);
		TbTuanApply entity = this. tuanApplyLogic.get(TbTuanApply.class, applyId);
		if(entity!=null){
			String result = this. tuanApplyLogic.deleteTuanApply(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作，找不到相应文章");
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " tuanApply.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the tuanApplyLogic
	 */
	public TuanApplyLogic getTuanApplyLogic() {
		return tuanApplyLogic;
	}

	/**
	 * @param tuanApplyLogic the tuanApplyLogic to set
	 */
	public void setTuanApplyLogic(TuanApplyLogic tuanApplyLogic) {
		this.tuanApplyLogic = tuanApplyLogic;
	}
}