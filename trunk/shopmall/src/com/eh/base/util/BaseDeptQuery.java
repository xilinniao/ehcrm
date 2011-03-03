package com.eh.base.util;

import com.eh.base.vo.UserInfo;

public class BaseDeptQuery extends BaseQuery {
	private Long deptId;
	private String deptName;
	private String treeNo;
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getTreeNo() {
		return treeNo;
	}
	public void setTreeNo(String treeNo) {
		this.treeNo = treeNo;
	}
	public String getTreeNoLike(){
		return this.treeNo+"%";
	}
	
	/**
	 * 
	 * @return
	 */
	private String getTopTreeNo(){
		UserInfo u = super.getUserInfo();
		if(u.findResource(Constants.DATA_PRIV_ALL)){
			//查看所有数据	,不做过滤
			return null;
		}else if(u.findResource(Constants.DATA_PRIV_SELF_AND_BLEW)){
			//本机构数据及本机构以下数据
			return u.getDept().getTreeNo();
		}else if(u.findResource(Constants.DATA_PRIV_SELF)){
			//只能看本机构数据
			return u.getDept().getTreeNo();
		}else{
			return u.getDept().getTreeNo();
		}
	}
}
