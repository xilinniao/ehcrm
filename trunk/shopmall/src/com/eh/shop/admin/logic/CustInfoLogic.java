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
}
