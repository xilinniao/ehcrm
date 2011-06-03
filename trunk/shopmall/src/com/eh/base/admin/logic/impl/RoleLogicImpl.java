package com.eh.base.admin.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.eh.base.admin.logic.RoleLogic;
import com.eh.base.entity.TbMenuInfo;
import com.eh.base.entity.TbResRel;
import com.eh.base.entity.TbRoleInfo;
import com.eh.base.entity.TbUserInfo;
import com.eh.base.entity.TreeVo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;

public class RoleLogicImpl extends BaseLogic implements RoleLogic {
	public Long saveRoleInfo(TbRoleInfo role) {
		if(role.getRoleId().longValue()==Long.valueOf(-99)){
			role.setRoleId(null);
			role.setStatus(Constants.YES);
			super.save(role);
			loopMenu(role.getParent().getRoleId(),role.getParent().getTreeNo());
		}else{
			super.save(role);
			loopMenu(role.getParent().getRoleId(),role.getParent().getTreeNo());
		}
		return role.getRoleId();
	}
	
	private void loopMenu(Long pid,String treeNo){
		List childs = super.baseDao.find("from TbRoleInfo t where t.parent.roleId = ? order by t.sortNum asc", pid);
		String myTreeNo = "";
		TbRoleInfo role = null;
		for(int i = 0,len = childs.size();i<len;i++){
			role = (TbRoleInfo)childs.get(i);
			myTreeNo = treeNo+String.valueOf(100+i);
			role.setTreeNo(myTreeNo);
			super.save(role);
			loopMenu(role.getRoleId(),role.getTreeNo());
		}
	}
	
	
	
	public List findRoleTree(String treeNo) {
		List tmpList = super.baseDao.find("from TbRoleInfo t where t.treeNo like ? order by t.treeNo ",treeNo+"%");
		List roleList = new ArrayList();
		for(int i = 0,len = tmpList.size();i<len;i++){
			TbRoleInfo roleInfo = (TbRoleInfo)tmpList.get(i);
			TreeVo vo = new TreeVo();
			vo.setTreeId(roleInfo.getRoleId());
			vo.setParentId(roleInfo.getParent()!=null?roleInfo.getParent().getRoleId():null);
			vo.setTreeName(roleInfo.getRoleName());
			vo.setTreeNo(roleInfo.getTreeNo());
			roleList.add(vo);
		}
		return roleList;
	}
	
	/**
	 * 查找用户所能赋予的角色
	 * @param treeNo
	 * @return
	 */
	public List findUserRoles(Long userId) {
		TbUserInfo userInfo = super.get(TbUserInfo.class, userId);
		return super.baseDao.find("from TbRoleInfo t where t.roleId <>1 order by t.treeNo");
	}
	
	/**
	 * 根据角色查找已经选中的资源
	 * @param roleId
	 * @return
	 */
	public List findCheckedResId(Long roleId){
		return super.baseDao.find("select menu from TbResRel t where t.relType = 'R' and t.objId = ? and t.menu.menuId <> 1 ",roleId);
	}

	public void saveRoleRes(Long roleId, String[] chkIds) {
		//先删除
		super.bulkUpdate("delete from TbResRel t where t.relType = 'R' and t.objId = ? ", new Object[]{roleId});
		if(chkIds!=null){
			for(int i =0,len = chkIds.length;i<len;i++){
				TbResRel rel = new TbResRel();
				TbMenuInfo res = super.get(TbMenuInfo.class, Long.parseLong(chkIds[i]));
				rel.setMenu(res);
				rel.setRelType("R");
				rel.setObjId(roleId);
				super.save(rel);
			}
		}
	}
	
	
}
