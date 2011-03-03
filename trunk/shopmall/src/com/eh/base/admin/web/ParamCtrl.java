package com.eh.base.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.admin.logic.ParamLogic;
import com.eh.base.controller.BaseTreeCtrl;
import com.eh.base.entity.TbBaseParams;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;

public class ParamCtrl extends BaseTreeCtrl{
	private static final Long PARAM_ROOT_ID = Long.valueOf(1);
	
	ParamLogic paramLogic;
	
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/admin/param/index.jsp");
		mav.addObject("rootId", PARAM_ROOT_ID);
		return mav;
	}
	
	private TbBaseParams  getRootParam(){
		return paramLogic.get(TbBaseParams.class,PARAM_ROOT_ID);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		TbBaseParams  rootParam = getRootParam();
		super.rootId = rootParam.getKeyId();
		super.rootTreeName = rootParam.getKeyName();
		return paramLogic.findParamTree(rootParam.getTreeNo());
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editParam(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		Long keyId = super.getLong(request, "keyId", false);
		TbBaseParams  entity = paramLogic.get(TbBaseParams.class, keyId);
		super.renderJson(response, FreeMarkerUtil.process("admin.param.entity.ftl", entity),null);
		return null;
	}
	/**
	 * 测试
	 **/
	public ModelAndView onEditParam(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long keyId = super.getLong(request, "keyId", false);
		TbBaseParams  entity = null;
		if(keyId.longValue()!=Long.valueOf(-99)){
			entity = paramLogic.get(TbBaseParams.class, keyId);
		}else{
			entity = new TbBaseParams ();
		}
		super.bindObject(request, entity);
		Long parentKeyId = super.getLong(request, "parentKeyId", false);
		TbBaseParams  parentParam = paramLogic.load(TbBaseParams .class, parentKeyId);
		entity.setParent(parentParam);
		paramLogic.saveParamInfo(entity);
		super.renderText(response, "OK", null);
		return null;
	}
	
	public ParamLogic getParamLogic() {
		return paramLogic;
	}

	public void setParamLogic(ParamLogic paramLogic) {
		this.paramLogic = paramLogic;
	}
}