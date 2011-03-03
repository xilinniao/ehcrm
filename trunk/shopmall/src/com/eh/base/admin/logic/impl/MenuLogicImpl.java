package com.eh.base.admin.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.eh.base.admin.logic.MenuLogic;
import com.eh.base.entity.TbMenuInfo;
import com.eh.base.entity.TreeVo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;

public class MenuLogicImpl extends BaseLogic implements MenuLogic {

	public List<TreeVo> findMenuTree(String treeNo) {
		List tmpList = super.baseDao.find("from TbMenuInfo t where t.treeNo like ? order by t.treeNo ",treeNo+"%");
		List menuList = new ArrayList();
		for(int i = 0,len = tmpList.size();i<len;i++){
			TbMenuInfo menuInfo = (TbMenuInfo)tmpList.get(i);
			TreeVo vo = new TreeVo();
			vo.setTreeId(menuInfo.getMenuId());
			vo.setParentId(menuInfo.getParent()!=null?menuInfo.getParent().getMenuId():null);
			vo.setTreeName(menuInfo.getMenuName());
			vo.setTreeNo(menuInfo.getTreeNo());
			menuList.add(vo);
		}
		return menuList;
	}

	public Long saveMenuInfo(TbMenuInfo menu) {
		if(menu.getMenuId().longValue()==Long.valueOf(-99)){
			menu.setMenuId(null);
			menu.setStatus(Constants.YES);
			super.save(menu);
			loopMenu(menu.getParent().getMenuId(),menu.getParent().getTreeNo());
		}else{
			super.save(menu);
			loopMenu(menu.getParent().getMenuId(),menu.getParent().getTreeNo());
		}
		return menu.getMenuId();
	}
	
	private void loopMenu(Long pid,String treeNo){
		List childs = super.baseDao.find("from TbMenuInfo t where t.parent.menuId = ? order by t.sortNum asc", pid);
		String myTreeNo = "";
		TbMenuInfo menu = null;
		for(int i = 0,len = childs.size();i<len;i++){
			menu = (TbMenuInfo)childs.get(i);
			myTreeNo = treeNo+String.valueOf(100+i);
			menu.setTreeNo(myTreeNo);
			super.save(menu);
			loopMenu(menu.getMenuId(),menu.getTreeNo());
		}
	}
}
