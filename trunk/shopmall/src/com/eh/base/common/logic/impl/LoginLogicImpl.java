package com.eh.base.common.logic.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.eh.base.common.logic.LoginLogic;
import com.eh.base.dao.jdbc.BaseJdbcDao;
import com.eh.base.entity.TbMenuInfo;
import com.eh.base.entity.TbUserInfo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.vo.UserInfo;
/**
 * 登录验证类
 * @author jcrm
 *
 */
public class LoginLogicImpl extends BaseLogic implements LoginLogic{
	private BaseJdbcDao baseJdbc;
	/*
	 * (non-Javadoc)
	 * @see com.jcrm.common.logic.LoginLogic#checkUser(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public UserInfo checkUser(String userCode, String password) {
		UserInfo sessionInfo = new UserInfo();
		List<TbUserInfo> userList = baseDao
				.find(
						"select u from TbUserInfo u join fetch u.dept where upper(u.userCode) = ? and u.loginPwd = ?",
						new Object[] { userCode, password });
		
		//找不到用户
		if (userList.size() == 0) {
			sessionInfo.setCheckResult("用户名或密码错误");
			return sessionInfo;
		}else{
			TbUserInfo user = userList.get(0);
			if(user.getStatus().longValue()==Long.valueOf(1)){
				sessionInfo.setCheckResult("用户已被禁用，请联系管理员");
				return sessionInfo;
			}else{
				//获取资源操作
				List resourceList = this.findUserResourcesList(user.getUserId());
				Long[] resources = (Long[])resourceList.toArray(new Long[0]);				
				sessionInfo.setUser(user);
				sessionInfo.setUserRes(resources);
				sessionInfo.setCheckResult("OK");
				
				//获取用户所在机构操作
				sessionInfo.setDept(user.getDept());
			}
		}

		return sessionInfo;
	}
	
	@SuppressWarnings("unchecked")
	public List findUserMenuList(Long userId){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT res.*   ");
		sql.append("FROM tb_menu_rel rel     ");
		sql.append("JOIN tb_menu_info res ON(rel.REL_TYPE = 'R' AND rel.RES_ID = res.RES_ID AND res.RES_TYPE = 1) ");
		sql.append("JOIN tb_udr_rel udr ON(udr.ROLE_ID = rel.OBJ_ID AND udr.USER_ID = ?)");
		sql.append("ORDER BY res.TREE_NO ASC");
		return this.baseJdbc.queryForList(sql.toString(), new Object[]{userId},menuRw);
	}
	
	private final MenuRowMapper menuRw = new MenuRowMapper();
	public class MenuRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rownum) throws SQLException {
			TbMenuInfo entity = new TbMenuInfo();
			entity.setMenuId(rs.getLong("RES_ID"));
			TbMenuInfo p = new TbMenuInfo();
			p.setMenuId(rs.getLong("P_RES_ID"));
			entity.setParent(p);
			entity.setMenuName(rs.getString("RES_NAME"));
			entity.setMenuUrl(rs.getString("RES_URL"));
			entity.setTreeNo(rs.getString("TREE_NO"));
			return entity;
		}
	}
	
	@SuppressWarnings("unchecked")
	private List findUserResourcesList(Long userId){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT res.RES_CODE,res.tree_no ");
		sql.append("FROM tb_menu_rel rel     ");
		sql.append("JOIN tb_menu_info res ON(rel.REL_TYPE = 'R' AND rel.RES_ID = res.RES_ID AND res.RES_TYPE = 2) ");
		sql.append("JOIN tb_udr_rel udr ON(udr.ROLE_ID = rel.OBJ_ID AND udr.USER_ID = ?)");
		sql.append("ORDER BY res.tree_no ASC");
		return this.baseJdbc.queryForList(sql.toString(), new Object[]{userId},resourceRw);
	}

	private final ResourceRowMapper resourceRw = new ResourceRowMapper();
	public class ResourceRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rownum) throws SQLException {
			return rs.getLong("RES_CODE");
		}
	}
	
	public BaseJdbcDao getBaseJdbc() {
		return baseJdbc;
	}

	public void setBaseJdbc(BaseJdbcDao baseJdbc) {
		this.baseJdbc = baseJdbc;
	}
	
}
