package com.eh.base.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.admin.logic.MenuLogic;
import com.eh.base.admin.logic.RoleLogic;
import com.eh.base.controller.BaseTreeCtrl;
import com.eh.base.entity.TbMenuInfo;
import com.eh.base.entity.TbRoleInfo;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;
import com.eh.exception.BusinessException;

public class RoleCtrl extends BaseTreeCtrl {	
	RoleLogic roleLogic;
	MenuLogic menuLogic;
	
	/**
	 * 展示首页信息
	 */
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/admin/role/index");
		mav.addObject("rootId", TbRoleInfo.ROLE_ROOT_ID);
		return mav;
	}
	
	private TbRoleInfo getRootRole(){
		return roleLogic.get(TbRoleInfo.class,TbRoleInfo.ROLE_ROOT_ID);
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		//设置ROOT根节点信息
		TbRoleInfo rootRole = getRootRole();
		super.rootId = rootRole.getRoleId();
		super.rootTreeName = rootRole.getRoleName();
		return roleLogic.findRoleTree(rootRole.getTreeNo());
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editRole(HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		Long roleId = super.getLong(request, "roleId", false);
		TbRoleInfo entity = roleLogic.get(TbRoleInfo.class, roleId);
		super.renderJson(response, FreeMarkerUtil.process("admin.role.entity.ftl", entity));
		return null;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView onEditRole(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long roleId = super.getLong(request, "roleId", false);
		TbRoleInfo entity = null;
		if(roleId.longValue()!=Long.valueOf(-99)){
			entity = roleLogic.get(TbRoleInfo.class, roleId);
		}else{
			entity = new TbRoleInfo();
		}
		super.bindObject(request, entity);
		Long parentRoleId = super.getLong(request, "parentRoleId", false);
		TbRoleInfo parentRole = roleLogic.get(TbRoleInfo.class, parentRoleId);
		entity.setParent(parentRole);
		roleLogic.saveRoleInfo(entity);
		super.renderText(response, "OK");
		return null;
	}
	
	/**
	 * 设置角色权限
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView editRolePriv(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		ModelAndView mav = new ModelAndView("/jsp/admin/role/editRolePriv");
		Long roleId = super.getLong(request, "roleId", false);
		List checkMenuIds = this.roleLogic.findCheckedResId(roleId);
		mav.addObject("checkMenuIds", checkMenuIds);
		return mav;
	}
	
	public ModelAndView onEditRolePriv(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Long roleId = super.getLong(request, "roleId", false);
		String[] chkIds = super.getStrings(request, "chkIds", true);
		this.roleLogic.saveRoleRes(roleId, chkIds);
		super.rendText(response, "OK");
		return null;
	}
	
	/**
	 * 判断资源是否已经被checked
	 * @param checkMenuIds
	 * @param menuId
	 * @return
	 */
	private boolean checkExist(List checkMenuIds,Long menuId){
		Long tmpMenuId = null;
		for(int i = 0,len=checkMenuIds.size();i<len;i++){
			tmpMenuId = (Long)checkMenuIds.get(i);
			if(tmpMenuId.longValue()==menuId.longValue()){
				return true;
			}
		}
		return false;
	}
	/**
	 * 生成树状节点
	 * @param menuList
	 * @param menuId
	 * @param rootMenuId
	 * @param xml
	 * @param loopTimes
	 * @return
	 * @throws BusinessException
	 */
	private int makeMenuTreeXml(List menuList,List checkMenuIds,Long menuId,Long rootMenuId,StringBuffer xml,int loopTimes)throws BusinessException{
		if(loopTimes>=500){
			throw new BusinessException("菜单数据存在死循环，请调整菜单数据");
		}
		
		TbMenuInfo menu = null;
		for (int i = 0, len = menuList.size(); i < len; i++){
			menu = (TbMenuInfo)menuList.get(i);
			if(menu.getMenuId().longValue()==rootMenuId.longValue()){
				continue;
			}
			if(menu.getParent().getMenuId().longValue()==menuId.longValue()){
				xml.append("<item text=\"");
				xml.append(menu.getMenuName());
				xml.append("\" id=\"");
				xml.append(menu.getMenuId());
				xml.append("\" im0=\"book.gif\" im1=\"books_open.gif\"");
				if(checkExist(checkMenuIds,menu.getMenuId())){
					xml.append(" checked=\"1\"");
				}
				xml.append(" im2=\"book.gif\">");
				loopTimes = this.makeMenuTreeXml(menuList,checkMenuIds, menu.getMenuId(), rootMenuId, xml, loopTimes);
				xml.append("</item>");
			}
		}
		
		return loopTimes;
	}
	
	public RoleLogic getRoleLogic() {
		return roleLogic;
	}

	public void setRoleLogic(RoleLogic roleLogic) {
		this.roleLogic = roleLogic;
	}

	public MenuLogic getMenuLogic() {
		return menuLogic;
	}

	public void setMenuLogic(MenuLogic menuLogic) {
		this.menuLogic = menuLogic;
	}
	
	
}
