/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.entity.TbAttachment;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.TuanApplyLogic;
import com.eh.shop.admin.web.qry.TuanApplyQry;
import com.eh.shop.entity.TbTuanApply;
import com.eh.shop.entity.TbTuanApplyExt;

public class TuanApplyCtrl extends BaseShopAdminCtrl {
	TuanApplyLogic tuanApplyLogic = null;


	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_apply/index");
		TuanApplyQry qry = new TuanApplyQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		qry.setShopId(userInfo.getShopInfo().getShopId());
		Page page = tuanApplyLogic.findPage(qry);
		mav.addObject("page", page);
		mav.addObject("qry", qry);
		return mav;
	}
	
	/**
	 * 审批列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView auditList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_apply/auditList");
		TuanApplyQry qry = new TuanApplyQry();
		bindObject(request, qry);		
		qry.setUserInfo(userInfo);
		String isQry = super.getString(request, "is_qry", true);
		if(StringUtils.isBlank(isQry)){
			qry.setApplyStatus(Long.valueOf(1));
		}
		Page page = tuanApplyLogic.findPage(qry);
		mav.addObject("page", page);
		mav.addObject("qry", qry);
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
		entity.setApplyStatus(Long.valueOf(0));
		mav.addObject("entity", entity);
		mav.addObject(TITLE, "新增团购申请");
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
		Long applyId = super.getLong(request, "applyId", false);
		// 修改操作
		TbTuanApply entity = tuanApplyLogic.get(TbTuanApply.class, applyId);
		if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
			ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_apply/edit");
			mav.addObject("entity", entity);
			mav.addObject(TITLE, "修改团购申请");
			return mav;
		}else{
			super.addErrors(request, "非法操作");
			ModelAndView mav = new ModelAndView(ERROR_URL);
			return mav;
		}
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long applyId = super.getLong(request, "applyId", false);
		Long applySt = super.getLong(request, "applySt", false);
		Long faceImageId = super.getLong(request, "faceImageid", false);
		TbAttachment face = this.tuanApplyLogic.get(TbAttachment.class, faceImageId);
		if(applyId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbTuanApply entity = new TbTuanApply();	
			super.bindObject(request,entity);
			entity.setShopInfo(userInfo.getShopInfo());
			entity.setApplyStatus(applySt);
			entity.setCreateTime(new Date());
			entity.setCreateUser(userInfo.getUser().getUserId());			
			entity.setFaceImage(face);
			TbTuanApplyExt ext = new TbTuanApplyExt();
			super.bindObject(request, ext);
			entity.setExt(ext);
			ext.setApply(entity);
			this.tuanApplyLogic.saveTuanApply(entity);
		}else{
			//修改操作
			TbTuanApply entity = this.tuanApplyLogic.get(TbTuanApply.class, applyId);
			if(entity!=null&&super.isYourShop(entity.getShopInfo(), userInfo)){
				super.bindObject(request, entity);
				if(entity.getApplyStatus().longValue()==Long.valueOf(0)){
					entity.setApplyStatus(applySt);//状态
					TbTuanApplyExt ext = entity.getExt();
					if(ext==null){
						ext = new TbTuanApplyExt();					
						super.bindObject(request, ext);
						entity.setExt(ext);
						ext.setApply(entity);
					}else{
						super.bindObject(request, ext);
						entity.setExt(ext);
					}
					if(entity.getFaceImage().getRecId().longValue()!=face.getRecId().longValue()){
						this.tuanApplyLogic.remove(entity.getFaceImage());
						entity.setFaceImage(face);
					}
					tuanApplyLogic.saveTuanApply(entity);
				}else{
					super.addErrors(request, "已经提交审批，不能再保存啦....");
				}
			}else{
				super.addErrors(request, "非法操作");
			}
		}
		ModelAndView mav = new ModelAndView(hasErrors(request)?ERROR_URL:SUCCESS_URL);
		mav.addObject("redirectUrl", " tuanApply.xhtml?method=index");
		return mav;
	}
	
	/**
	 * 审批单修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView apply(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long applyId = super.getLong(request, "applyId", false);
		TbTuanApply entity = this.tuanApplyLogic.get(TbTuanApply.class, applyId);
		if(entity!=null){
			ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_apply/apply");
			mav.addObject("entity", entity);
			mav.addObject(TITLE, "审批团购申请");
			return mav;
		}else{
			super.addErrors(request, "找不到该审批单");
			ModelAndView mav = new ModelAndView(ERROR_URL);
			return mav;
		}
	}
	
	/**
	 * 审批单修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onApply(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long applyId = super.getLong(request, "applyId", false);
		TbTuanApply entity = this.tuanApplyLogic.get(TbTuanApply.class, applyId);
		if(entity!=null){
			super.bindObject(request, entity);
			this.tuanApplyLogic.save(entity);
		}else{
			super.addErrors(request, "找不到该审批单");
		}
		ModelAndView mav = new ModelAndView(hasErrors(request)?ERROR_URL:SUCCESS_URL);
		mav.addObject("redirectUrl", " tuanApply.xhtml?method=auditList");
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
		TbTuanApply entity = tuanApplyLogic.get(TbTuanApply.class,applyId);
		if(entity!=null){
			String result = tuanApplyLogic.deleteTuanApply(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}
		}else{
			super.addErrors(request, "非法操作");
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