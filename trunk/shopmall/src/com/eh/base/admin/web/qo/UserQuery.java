package com.eh.base.admin.web.qo;

import com.eh.base.util.BaseDeptQuery;

/**
 * 用户查询对象
 * @author jcrm
 *
 */
public class UserQuery extends BaseDeptQuery{	
	String userName;
	String userCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
}
