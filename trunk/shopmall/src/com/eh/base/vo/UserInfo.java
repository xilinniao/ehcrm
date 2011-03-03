package com.eh.base.vo;

import com.eh.base.entity.DeptInfo;
import com.eh.base.entity.TbUserInfo;

/**
 * session对象
 * @author jcrm
 *
 */
public class UserInfo {
	/**
	 * 部门对象
	 */
	private DeptInfo dept;
	/**
	 * 机构对象
	 */
	private DeptInfo org;
	/**
	 * 用户
	 */
	private TbUserInfo user;
	/**
	 * 用户检验结果，如果为OK,则验证成功
	 */
	private String checkResult;
	/**
	 * 用户资源ID
	 */
	private Long[] userRes;
	/**
	 * 菜单字符串
	 */
	private String menuStr;
	
	public boolean findResource(long id){		
		if (userRes == null) {
			return false;
		}else{
			for(int i=0,len=userRes.length-1;i<=len;i++){
				if(userRes[i].longValue()==id){
					return true;
				}
			}
		}
		return false;
	}
	

	public TbUserInfo getUser() {
		return user;
	}
	public void setUser(TbUserInfo user) {
		this.user = user;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public Long[] getUserRes() {
		return userRes;
	}
	public void setUserRes(Long[] userRes) {
		this.userRes = userRes;
	}
	public String getMenuStr() {
		return menuStr;
	}
	public void setMenuStr(String menuStr) {
		this.menuStr = menuStr;
	}


	public DeptInfo getDept() {
		return dept;
	}


	public void setDept(DeptInfo dept) {
		this.dept = dept;
	}


	public DeptInfo getOrg() {
		return org;
	}


	public void setOrg(DeptInfo org) {
		this.org = org;
	}
	
}
