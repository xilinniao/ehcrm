package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.logic.IBaseLogic;

public interface CustAddrLogic extends IBaseLogic {
	/**
	 * 查找客户地址根据客户编号
	 * @param custId
	 * @return
	 */
	public List findAddrListByCustId(Long custId);
}
