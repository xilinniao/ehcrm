package com.eh.base.admin.logic;

import java.util.List;

import com.eh.base.entity.TbRoleInfo;
import com.eh.base.logic.IBaseLogic;

public interface RoleLogic extends IBaseLogic {
	/**
	 * 查找角色列表
	 * @param treeNo
	 * @return
	 */
	public List findRoleTree(String treeNo);
	/**
	 * 保存角色
	 * @param role
	 * @return
	 */
	public Long saveRoleInfo(TbRoleInfo role);	
	/**
	 * 根据角色查找角色所拥有的权限
	 * @param roleId
	 * @return
	 */
	public List findCheckedResId(Long roleId);
	/**
	 * 保存角色资源信息
	 * @param roleId
	 * @param chkIds
	 */
	public void saveRoleRes(Long roleId,String[] chkIds);
	/**
	 * 根据用户查找所能赋予的角色类型
	 * @param userId
	 * @return
	 */
	public List findUserRoles(Long userId);
}
