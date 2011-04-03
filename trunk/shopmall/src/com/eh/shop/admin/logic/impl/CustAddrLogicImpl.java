package com.eh.shop.admin.logic.impl;

import java.util.List;

import com.eh.base.logic.BaseLogic;
import com.eh.shop.admin.logic.CustAddrLogic;

public class CustAddrLogicImpl extends BaseLogic implements CustAddrLogic {
	/**
	 * 查找客户地址根据客户编号
	 */
	public List findAddrListByCustId(Long custId) {
		return super.baseDao.find("from TbCustAddr t where t.custId = ? ", custId);
	}

}
