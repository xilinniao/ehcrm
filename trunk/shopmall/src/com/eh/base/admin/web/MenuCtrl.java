package com.eh.base.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.admin.logic.MenuLogic;
import com.eh.base.controller.BaseTreeCtrl;
import com.eh.base.entity.TbMenuInfo;
import com.eh.base.util.FreeMarkerUtil;
import com.eh.base.vo.UserInfo;

public class MenuCtrl extends BaseTreeCtrl{
	private static final Long MENU_ROOT_ID = Long.valueOf(1);
	
	MenuLogic menuLogic;
	
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		ModelAndView mav = new ModelAndView("/jsp/admin/menu/index.jsp");
		mav.addObject("rootId", MENU_ROOT_ID);
		return mav;
	}
	
	private TbMenuInfo getRootMenu(){
		return menuLogic.get(TbMenuInfo.class,MENU_ROOT_ID);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		//设置ROOT根节点信息
		TbMenuInfo rootMenu = getRootMenu();
		super.rootId = rootMenu.getMenuId();
		super.rootTreeName = rootMenu.getMenuName();
		return menuLogic.findMenuTree(rootMenu.getTreeNo());
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editMenu(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		Long menuId = super.getLong(request, "menuId", false);
		TbMenuInfo entity = menuLogic.get(TbMenuInfo.class, menuId);
		super.renderJson(response, FreeMarkerUtil.process("admin.menu.entity.ftl", entity),null);
		return null;
	}
	
	public ModelAndView onEditMenu(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long menuId = super.getLong(request, "menuId", false);
		TbMenuInfo entity = null;
		if(menuId.longValue()!=Long.valueOf(-99)){
			entity = menuLogic.get(TbMenuInfo.class, menuId);
		}else{
			entity = new TbMenuInfo();
		}
		super.bindObject(request, entity);
		Long parentMenuId = super.getLong(request, "parentMenuId", false);
		TbMenuInfo parentMenu = menuLogic.load(TbMenuInfo.class, parentMenuId);
		entity.setParent(parentMenu);
		menuLogic.saveMenuInfo(entity);
		super.renderText(response, "OK", null);
		return null;
	}
	
	/**
	 * 选择菜单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectMenu(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		return new ModelAndView("/jsp/admin/menu/tree.jsp");
	}
	
	/**
	 * 新增菜单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addMenu(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		return new ModelAndView("/jsp/admin/menu/add.jsp");
	}
	
	/**
	 * 删除菜单资源
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteMenu(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		Long menuId = super.getLong(request, "menuId", false);		
		String result = this.menuLogic.deleteMenuInfo(menuId);
		super.renderText(response, result, null);
		return null;
	}
	
	public MenuLogic getMenuLogic() {
		return menuLogic;
	}

	public void setMenuLogic(MenuLogic menuLogic) {
		this.menuLogic = menuLogic;
	}
	
	
}
