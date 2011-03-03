/**
 * 
 */
package com.eh.base.common.logic;

import java.util.List;

import com.eh.base.logic.IBaseLogic;
import com.eh.base.vo.UserInfo;

/**
 * @author jcrm
 *
 */
public interface LoginLogic extends IBaseLogic {
	/**
	 * 检验用户登录
	 * @param userCode
	 * @param password
	 */
	public UserInfo checkUser(String userCode,String password);
	/**
	 * 获取用户所拥有的菜单资源
	 * @param userId
	 * @return
	 */
	public List findUserMenuList(Long userId);
}
