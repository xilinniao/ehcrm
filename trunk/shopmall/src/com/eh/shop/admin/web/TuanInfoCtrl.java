/**
 * 
 */
package com.eh.shop.admin.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;
import com.eh.shop.admin.logic.TuanInfoLogic;
import com.eh.shop.admin.web.qry.TuanInfoQry;
import com.eh.shop.entity.TbTuanApply;
import com.eh.shop.entity.TbTuanApplyExt;
import com.eh.shop.entity.TbTuanInfo;
import com.eh.shop.entity.TbTuanInfoExt;



public class TuanInfoCtrl extends BaseShopAdminCtrl {
	TuanInfoLogic tuanInfoLogic = null;

	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_info/index");		
		TuanInfoQry qry = new TuanInfoQry();
		bindObject(request, qry);
		qry.setUserInfo(userInfo);
		Page page = tuanInfoLogic.findPage(qry);
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_info/edit");
		TbTuanInfo entity = new TbTuanInfo();
		entity.setTuanId(Constants.ADD_PK_ID);
		
		Long applyId = super.getLong(request, "applyId", false);
		if(applyId!=null){
			TbTuanApply apply = this.tuanInfoLogic.get(TbTuanApply.class, applyId);
			TbTuanApplyExt applyExt = apply.getExt();
			entity.setApplyId(applyId);
			entity.setBeginDate(apply.getBeginDate());
			entity.setEndDate(apply.getEndDate());
			entity.setTopicName(apply.getTopicName());
			entity.setMaxQty(apply.getMaxQty());
			entity.setCurrQty(Long.valueOf(0));
			entity.setDiscountPrice(apply.getDiscountPrice());
			entity.setPrice(apply.getPrice());
			entity.setLinkQq(apply.getLinkQq());
			entity.setLinkTel(apply.getLinkTel());
			entity.setIsPublish(Constants.NO);
			entity.setFaceImageId(apply.getFaceImageId());
			entity.setShopInfo(apply.getShopInfo());
			
			TbTuanInfoExt ext = new TbTuanInfoExt();
			ext.setRules(applyExt.getRules());
			ext.setTopicContent(applyExt.getTopicContent());
			entity.setExt(ext);
		}
		
		mav.addObject("entity", entity);
		mav.addObject(TITLE, "新增团购信息");
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
		ModelAndView mav = new ModelAndView("/jsp/shop/admin/tuan_info/edit");
		Long tuanId = super.getLong(request, "tuanId", false);
		// 修改操作
		TbTuanInfo entity = this.tuanInfoLogic.get(TbTuanInfo.class, tuanId);
		mav.addObject("entity", entity);
		mav.addObject(TITLE, "修改团购信息");
		return mav;
	}
	
	public  ModelAndView onEdit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);		
		Long tuanId = super.getLong(request, "tuanId", false);
		Long applyId = super.getLong(request, "applyId", false);
		
		if(tuanId.longValue() == Constants.ADD_PK_ID.longValue()) {
			//新增操作
			TbTuanApply apply = this.tuanInfoLogic.get(TbTuanApply.class, applyId);
			TbTuanInfo entity = new TbTuanInfo();
			super.bindObject(request,entity);
			entity.setShopInfo(apply.getShopInfo());
			entity.setApplyId(applyId);
			entity.setCreateTime(new Date());
			entity.setCreateUser(userInfo.getUser().getUserId());
			
			TbTuanInfoExt ext = new TbTuanInfoExt();
			super.bindObject(request, ext);
			entity.setExt(ext);
			ext.setInfo(entity);
			
			this.tuanInfoLogic.saveTuanInfo(entity);
		}else{
			//修改操作
			TbTuanInfo entity = this.tuanInfoLogic.get(TbTuanInfo.class, tuanId);
			if(entity!=null){
				super.bindObject(request, entity);
				TbTuanInfoExt ext = entity.getExt();
				if(ext==null){
					ext = new TbTuanInfoExt();		
					super.bindObject(request, ext);
					entity.setExt(ext);
					ext.setInfo(entity);
				}else{
					super.bindObject(request, ext);
					entity.setExt(ext);
				}
				tuanInfoLogic.saveTuanInfo(entity);
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
		Long tuanId = super.getLong(request, "tuanId", false);
		TbTuanInfo entity = tuanInfoLogic.get(TbTuanInfo.class, tuanId);
		if(entity!=null){
			/*String result = tuanInfoLogic.deleteTuanId(entity);
			//返回错误信息
			if(StringUtils.isNotBlank(result)){
				super.addErrors(request, result);
			}*/
		}else{
			super.addErrors(request, "非法操作");
		}		
		ModelAndView mav = new ModelAndView(SUCCESS_URL);
		mav.addObject("redirectUrl", " tuanInfo.xhtml?method=index");
		return mav;
	}

	/**
	 * @return the tuanInfoLogic
	 */
	public TuanInfoLogic getTuanInfoLogic() {
		return tuanInfoLogic;
	}

	/**
	 * @param tuanInfoLogic the tuanInfoLogic to set
	 */
	public void setTuanInfoLogic(TuanInfoLogic tuanInfoLogic) {
		this.tuanInfoLogic = tuanInfoLogic;
	}
}