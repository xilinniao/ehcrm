package com.eh.shop.admin.logic;

import com.eh.base.logic.IBaseLogic;
import com.eh.shop.entity.TbCustInfo;

public interface CustInfoLogic extends IBaseLogic {
	/**
	 * 保存注册客户信息
	 * @param custInfo
	 * @return
	 */
	public String saveRegInfo(TbCustInfo custInfo);
	/**
	 * 判断客户名是否存在
	 * @param custCode
	 * @return
	 */
	public boolean custExists(String custCode);
	/**
	 * 登录验证，验证成功返回null字符串，验证失败，返回失败原因
	 * @param custCode
	 * @param pwd
	 * @return
	 */
	public TbCustInfo loginCheck(String custCode,String pwd);
	/**
	 * 改变客户密码
	 * @param cust
	 * @return
	 */
	public void saveChangePwd(TbCustInfo cust);
}
