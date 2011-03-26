package com.eh.shop.admin.logic.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CryptUtil;
import com.eh.shop.entity.TbCustInfo;
import com.eh.shop.entity.TbCustScoreFlow;

public class CustInfoLogic extends BaseLogic implements
		com.eh.shop.admin.logic.CustInfoLogic {
	/**
	 * 加密密码串
	 * @param pwd
	 * @return
	 */
	private String cryptPwd(String pwd){
		return CryptUtil.md5(Constants.CRYPT_MD_PREFIX+pwd);
	}
	
	/**
	 * 保存注册信息
	 */
	public String saveRegInfo(TbCustInfo custInfo) {
		if(!this.custExists(custInfo.getCustCode())){
			return "改用户名已存在，请重新选择用户名";
		}else{
			//保存注册注册信息
			custInfo.setCustPwd(this.cryptPwd(custInfo.getCustPwd()));
			custInfo.setLastLoginTime(new Date());
			custInfo.setCreateTime(new Date());
			super.save(custInfo);			
			//增加一条积分流水记录			
			TbCustScoreFlow flow = new TbCustScoreFlow();
			flow.setCustInfo(custInfo);
			flow.setCreateTime(new Date());
			flow.setFlowRemark("用户注册赠送积分");
			flow.setScoreNum(Long.valueOf(500));
			super.save(flow);
			return "";
		}		
	}

	/**
	 * 判断客户名是否存在，如果存在则提示用户注册不成功
	 */
	public boolean custExists(String custCode) {
		int cnt = super.baseDao.count("select count(*) from TbCustInfo t where t.custCode = ? ", StringUtils.trim(custCode));
		if(cnt==0){
			return false;
		}else{
			return true;
		}
	}	
}
