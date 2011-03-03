package com.eh.base.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.admin.logic.DeptLogic;
import com.eh.base.admin.web.qo.DeptQuery;
import com.eh.base.controller.BaseTreeCtrl;
import com.eh.base.entity.TbDeptInfo;
import com.eh.base.entity.DeptInfo;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;

public class DeptCtrl extends BaseTreeCtrl {
	
	
	private DeptLogic deptLogic;
	
	@Override
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/admin/dept/index.jsp");
		DeptInfo rootDept = super.getRootDept(userInfo);
		mav.addObject("rootId",rootDept.getDeptId());
		return mav;
	}
	
	
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		DeptQuery qry = new DeptQuery();
		qry.setUserInfo(userInfo);
		//设置ROOT根节点信息
		DeptInfo rootDept = super.getRootDept(userInfo);
		super.rootId = rootDept.getDeptId();
		super.rootTreeName = rootDept.getDeptName();
		qry.setTreeNo(rootDept.getTreeNo());
		return deptLogic.findDeptTree(qry);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editDept(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long deptId = super.getLong(request, "deptId", false);
		DeptInfo entity = deptLogic.get(DeptInfo.class, deptId);
		super.renderJson(response, FreeMarkerUtil.process("admin.dept.entity.ftl", entity),null);
		return null;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onEditDept(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long deptId = super.getLong(request, "deptId", false);
		Long parentDeptId = super.getLong(request, "parentDeptId", false);
		TbDeptInfo entity = null;
		if(deptId.longValue()==Long.valueOf(-99)){
			entity = new TbDeptInfo();
			super.bindObject(request, entity);
		}else{
			entity = deptLogic.get(TbDeptInfo.class, deptId);
			super.bindObject(request, entity);
		}
		deptLogic.saveDeptInfo(entity,parentDeptId);
		super.renderText(response, "OK", null);
		return null;
	}

	public DeptLogic getDeptLogic() {
		return deptLogic;
	}

	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
	
	
}
