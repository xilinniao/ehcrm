package com.eh.base.admin.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.admin.logic.RoleLogic;
import com.eh.base.admin.logic.UserLogic;
import com.eh.base.admin.web.qo.UserQuery;
import com.eh.base.controller.BaseCtrl;
import com.eh.base.dao.hibernate.Page;
import com.eh.base.entity.TbRoleInfo;
import com.eh.base.entity.TbUserInfo;
import com.eh.base.entity.DeptInfo;
import com.eh.base.util.Constants;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;
import com.eh.exception.BusinessException;

public class UserCtrl extends BaseCtrl {
	UserLogic userLogic;
	RoleLogic roleLogic;
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/admin/user/index");
		DeptInfo rootDept = super.getRootDept(userInfo);
		mav.addObject("rootId",rootDept.getDeptId());
		return mav;
	}
	
	/**
	 * 查找人员列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView userList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserQuery qry = new UserQuery();
		bindObject(request, qry);
		if(StringUtils.isBlank(qry.getTreeNo())){
			DeptInfo dept = userLogic.get(DeptInfo.class, qry.getDeptId());
			qry.setDeptName(dept.getDeptName());
			qry.setTreeNo(dept.getTreeNo());
		}
		Page page = userLogic.findUserList(qry);
		Map data = super.getParameterMap(request);
		data.put("page", page);
		renderJson(response, FreeMarkerUtil.process("admin.user.userList.ftl", data));
		return null;
	}
	
	
	/**
	 * 编辑人员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/admin/user/editUser");
		Long userId = super.getLong(request, "userId", false);
		TbUserInfo entity = null;
		if(userId.longValue()!=Long.valueOf(-99)){
			entity = userLogic.get(TbUserInfo.class, userId);			
		}else{
			Long deptId = super.getLong(request, "deptId", false);
			DeptInfo dept = userLogic.get(DeptInfo.class, deptId);
			entity = new TbUserInfo();
			entity.setDept(dept);
			entity.setUserId(Long.valueOf(-99));
			entity.setStatus(Constants.YES);
		}
		mav.addObject("entity",entity);
		return mav;
	}
	
	/**
	 * 保存人员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onEditUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Long userId = super.getLong(request, "userId", false);
		TbUserInfo entity = null;
		if(userId.longValue()==Long.valueOf(-99)){
			entity = new TbUserInfo();
			super.bindObject(request, entity);
			entity.setStatus(Long.valueOf(0));
			Long deptId = super.getLong(request, "deptId", false);
			DeptInfo dept = this.userLogic.get(DeptInfo.class, deptId);
			entity.setDept(dept);
		}else{
			entity = userLogic.get(TbUserInfo.class, userId);
			super.bindObject(request, entity);
			//密码不重置
		}
		userLogic.saveUser(entity);
		super.renderText(response, "OK");
		return null;
	}
	
	/**
	 * 判断用户是否存在
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView checkUserExists(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String userCode = super.getString(request, "userCode", true);
		boolean isExist = this.userLogic.isUserExist(userCode);
		super.renderText(response, isExist);
		return null;
	}
	
	/**
	 * 删除人员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteUser(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		Long userId = super.getLong(request, "userId", true);		
		this.userLogic.deleteUser(userId);		
		response.sendRedirect("/admin/user.xhtml?method=userList");
		return null;
	}
	
	/**
	 * 设置用户角色
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView userApplyRoles(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/admin/user/userApplyRoles");
		Long userId = super.getLong(request, "userId", false);
		TbUserInfo user = this.userLogic.get(TbUserInfo.class, userId);
		List roleList = this.roleLogic.findUserRoles(userId);
		List checkRoleIds = this.userLogic.findCheckedRoles(userId);
		mav.addObject("roleList", roleList);
		mav.addObject("checkRoleIds", checkRoleIds);
		mav.addObject("user", user);
		return mav;
	}
	
	public ModelAndView onUserApplyRoles(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Long userId = super.getLong(request, "userId", false);
		String[] roleIds = super.getStrings(request, "roleId", true);
		this.userLogic.saveUserRole(userId, roleIds);
		super.rendText(response, "OK$<p>保存成功</p>");
		return null;
	}
	
	private boolean checkExist(List checkRoleIds,Long roleId){
		Long tmpMenuId = null;
		for(int i = 0,len=checkRoleIds.size();i<len;i++){
			tmpMenuId = (Long)checkRoleIds.get(i);
			if(tmpMenuId.longValue()==roleId.longValue()){
				return true;
			}
		}
		return false;
	}
	
	private int makeRoleTreeXml(List roleList,List checkRoleIds,Long roleId,Long rootRoleId,StringBuffer xml,int loopTimes)throws BusinessException{
		if(loopTimes>=500){
			throw new BusinessException("菜单数据存在死循环，请调整菜单数据");
		}
		
		TbRoleInfo role = null;
		for (int i = 0, len = roleList.size(); i < len; i++){
			role = (TbRoleInfo)roleList.get(i);
			if(role.getRoleId().longValue()==rootRoleId.longValue()){
				continue;
			}
			if(role.getParent().getRoleId().longValue()==roleId.longValue()){
				xml.append("<item text=\"");
				xml.append(role.getRoleName());
				xml.append("\" id=\"");
				xml.append(role.getRoleId());
				xml.append("\" im0=\"book.gif\" im1=\"books_open.gif\"");
				if(checkExist(checkRoleIds,role.getRoleId())){
					xml.append(" checked=\"1\"");
				}
				xml.append(" im2=\"book.gif\">");
				loopTimes = this.makeRoleTreeXml(roleList,checkRoleIds, role.getRoleId(), rootRoleId, xml, loopTimes);
				xml.append("</item>");
			}
		}
		
		return loopTimes;
	}
	
	/**
	 * 查看人员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView viewUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/admin/user/viewUser");		
		Long userId = super.getLong(request, "userId", false);
		if(userId.longValue()!=Long.valueOf(-1)){
			TbUserInfo entity = userLogic.get(TbUserInfo.class, userId);
			mav.addObject("entity", entity);
		}
		return mav;
	}
	

	public UserLogic getUserLogic() {
		return userLogic;
	}

	public void setUserLogic(UserLogic userLogic) {
		this.userLogic = userLogic;
	}

	public RoleLogic getRoleLogic() {
		return roleLogic;
	}

	public void setRoleLogic(RoleLogic roleLogic) {
		this.roleLogic = roleLogic;
	}
	
	
	
}