package com.eh.base.admin.logic;

import java.util.List;

import com.eh.base.entity.TbMenuInfo;
import com.eh.base.logic.IBaseLogic;

public interface MenuLogic extends IBaseLogic {
	/**
	 * 查找菜单数据
	 * @param treeNo
	 * @return
	 */
	public List findMenuTree(String treeNo);
	/**
	 * 保存菜单数据
	 * @param menu
	 * @return
	 */
	public Long saveMenuInfo(TbMenuInfo menu);
	/**
	 * 删除菜单资源
	 * @param menuId
	 * @return
	 */
	public String deleteMenuInfo(Long menuId);
}
