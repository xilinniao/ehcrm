/**
 * 
 */
package com.eh.base.admin.logic;

import java.util.List;

import com.eh.base.admin.web.qo.UserQuery;
import com.eh.base.dao.hibernate.Page;
import com.eh.base.entity.TbUdrRel;
import com.eh.base.entity.TbUserInfo;
import com.eh.base.logic.IBaseLogic;

/**
 * 用户管理LOGIC
 * @author jcrm
 *
 */
public interface UserLogic extends IBaseLogic {
	public Page findUserList(UserQuery qry);	
	/**
	 * 保存用户信息
	 * @param tbUserInfo
	 * @param bankNetId
	 * @param roleId
	 */
	public void saveUser(TbUserInfo tbUserInfo);
	/**
	 * 删除用户信息
	 * @param tbUserInfo
	 * @param bankNetId
	 * @param roleId
	 */
	public void deleteUser(Long userId);
	/**
	 * 查找已经被CHECKED的Role
	 * @param userId
	 * @return
	 */
	public List findCheckedRoles(Long userId);
	/**
	 * 
	 * @param userId
	 * @param roles
	 */
	public void saveUserRole(Long userId,String[] roleIds);
	/**
	 * 判断用户名是否存在
	 * @param userCode
	 */
	public boolean isUserExist(String userCode);
}
