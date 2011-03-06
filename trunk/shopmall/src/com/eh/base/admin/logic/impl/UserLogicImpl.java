/**
 * 
 */
package com.eh.base.admin.logic.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.eh.base.admin.logic.UserLogic;
import com.eh.base.admin.web.qo.UserQuery;
import com.eh.base.dao.hibernate.Page;
import com.eh.base.entity.TbDeptInfo;
import com.eh.base.entity.TbMenuInfo;
import com.eh.base.entity.TbRoleInfo;
import com.eh.base.entity.TbResRel;
import com.eh.base.entity.TbUdrRel;
import com.eh.base.entity.TbUserInfo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.CriteriaUtil;

/**
 * @author jcrm
 *
 */
public class UserLogicImpl extends BaseLogic implements UserLogic {
	/* (non-Javadoc)
	 * @see com.jcrm.admin.logic.UserLogic#findUserList(com.jcrm.admin.web.qo.UserQueryObject)
	 */
	public Page findUserList(UserQuery qry) {
		Criteria criteria = baseDao.createCriteria(TbUserInfo.class);
		criteria.createAlias("dept","d");
		CriteriaUtil.addRightLike(criteria, "d.treeNo", qry.getTreeNo());
		CriteriaUtil.addFullLike(criteria, "userName", qry.getUserName());
		CriteriaUtil.addFullLike(criteria, "userCode", qry.getUserCode());
		return baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}
	
	/**
	 * 保存用户信息
	 * @param tbUserInfo
	 * @param bankNetId
	 * @param roleId
	 */
	public void saveUser(TbUserInfo tbUserInfo){
		tbUserInfo.setUserCode(StringUtils.trim(tbUserInfo.getUserCode()));
		if(tbUserInfo.getUserId().longValue()==Long.valueOf(-99)){
			tbUserInfo.setUserId(null);
		}
		this.baseDao.save(tbUserInfo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.eh.base.admin.logic.UserLogic#isUserExist(java.lang.String)
	 */
	public boolean isUserExist(String userCode) {
		int cnt = super.baseDao.count("select count(*) from TbUserInfo where userCode=?", userCode);
		return cnt==0;
	}


	/**
	 * 禁用用户信息
	 * @param tbUserInfo
	 * @param bankNetId
	 * @param roleId
	 */
	public void deleteUser(Long userId){
		TbUserInfo entity = super.load(TbUserInfo.class, userId);
		entity.setStatus(Long.valueOf(1));
	}
	
	public List findCheckedRoles(Long userId){
		return super.baseDao.find("select t.roleInfo.roleId from TbUdrRel t where t.userInfo.userId = ?", userId);
	}
	
	public void saveUserRole(Long userId,String[] roleIds){
		super.bulkUpdate("delete from TbUdrRel t where t.userInfo.userId = ?", new Object[]{userId});
		TbUserInfo user = super.load(TbUserInfo.class, userId);
		if(roleIds!=null){
			for(int i =0,len = roleIds.length;i<len;i++){
				TbUdrRel rel = new TbUdrRel();
				TbRoleInfo role = super.load(TbRoleInfo.class, Long.parseLong(roleIds[i]));
				rel.setRoleInfo(role);
				rel.setUserInfo(user);
				super.save(rel);
			}
		}
	}
}
