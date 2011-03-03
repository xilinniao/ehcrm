package com.eh.base.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.admin.logic.DeptLogic;
import com.eh.base.admin.logic.RoleLogic;
import com.eh.base.controller.BaseCtrl;
import com.eh.base.entity.TbDeptInfo;
/**
 * 
 * @author jcrm
 *
 */
public class CommonCtrl extends BaseCtrl {
	
	
	DeptLogic deptLogic = null;
	RoleLogic roleLogic = null;

	public DeptLogic getDeptLogic() {
		return deptLogic;
	}

	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}

	public RoleLogic getRoleLogic() {
		return roleLogic;
	}

	public void setRoleLogic(RoleLogic roleLogic) {
		this.roleLogic = roleLogic;
	}

	/**
	 * 树形结构列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deptList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return index(request, response);
	}
	
	/**
	 * 自动补全机构信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView acDeptList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return index(request, response);
	}
	
	
	
	/**
	 * 查询所有的机构 用于需要弹出选择窗口
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView findChildDept(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/common/deptTree.jsp");
		/*List deptList = deptLogic.findDeptTree();
		mav.addObject("deptList", deptList);*/
		return mav;
	}
	
	/**
	 * 根据机构号查询机构名 多用于查询报表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView findDeptNameByCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/common/deptNameByCodeIfm.jsp");
		String deptCode = this.getString(request,"deptCode",true);
		TbDeptInfo deptInfo = deptLogic.findDepByCode(deptCode);
		mav.addObject("deptInfo", deptInfo);
		return mav;
	}
	
	
	
	/**
	 * 查询所有的角色
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView findAllRole(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/common/roleTree.jsp");
		/*List treeList = roleLogic.findTreeList();
		mav.addObject("treeList", treeList);*/
		return mav;
	}
	
	
	public ModelAndView meetTree(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/common/meetingTree.jsp");		
		
		return mav;
	}
}
