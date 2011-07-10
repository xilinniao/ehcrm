/**
 * 
 */
package com.eh.shop.admin.logic.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.eh.base.entity.DeptInfo;
import com.eh.base.entity.TbDeptInfo;
import com.eh.base.entity.TbRoleInfo;
import com.eh.base.entity.TbUdrRel;
import com.eh.base.entity.TbUserInfo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.base.util.CryptUtil;
import com.eh.shop.admin.logic.ShopLogic;
import com.eh.shop.entity.TbShopInfo;
import com.eh.shop.front.vo.ShopRegVo;

/**
 * 
 * 商铺LOGIC
 * 
 * @author zhoucl
 * 
 */
public class ShopLogicImpl extends BaseLogic implements ShopLogic {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eh.shop.admin.logic.ShopLogic#getUserShop(java.lang.Long)
	 */
	public TbShopInfo getUserShop(Long userId) {
		List shopList = super.baseDao.find(
				"from TbShopInfo t where t.admin.userId = ?", userId);
		if (shopList.size() > 0) {
			return (TbShopInfo) shopList.get(0);
		} else {
			return null;
		}
	}

	public boolean userExist(String userCode) {
		int cnt = super.baseDao.count("select count(*) from TbUserInfo t where userCode = ? ", StringUtils.trim(userCode));
		if(cnt==0){
			return false;
		}else{
			return true;
		}
	}

	public String saveCreateShopInfo(ShopRegVo reg) {
		//创建一条角色信息
		List deptList = super.baseDao.find("from TbDeptInfo where deptCode = ? ", Constants.SHOP_DEPT);
		TbDeptInfo dept = (TbDeptInfo)deptList.get(0);
		
		List roleList = super.baseDao.find("from TbRoleInfo where roleCode = ? ", Constants.SHOP_ROLE);
		TbRoleInfo role = (TbRoleInfo)roleList.get(0);
		
		//创建一条用户记录
		TbUserInfo user = new TbUserInfo();
		user.setUserCode(StringUtils.trim(reg.getUserCode()).toUpperCase());
		user.setLoginPwd(CryptUtil.md5(Constants.CRYPT_MD_PREFIX+reg.getLoginPwd()));
		user.setMobile(reg.getLinkTel());
		user.setUserName(reg.getLinkName());
		user.setStatus(Constants.YES);
		user.setDept(super.baseDao.get(DeptInfo.class, dept.getDeptId()));
		super.save(user);
		
		TbUdrRel rel = new TbUdrRel();
		rel.setUserInfo(user);
		rel.setDeptInfo(dept);
		rel.setRoleInfo(role);
		super.save(rel);
		
		//创建一条店铺信息
		TbShopInfo shop = new TbShopInfo();
		shop.setShopName(reg.getShopName());
		shop.setShopDesc(" ");
		shop.setAdmin(user);
		shop.setEmail(reg.getEmail());
		shop.setFoundDate(new Date());
		shop.setModiDate(new Date());
		shop.setShopAddr(reg.getAddress());
		shop.setLinkerMan(reg.getLinkName());
		shop.setLinkerMobile(reg.getLinkTel());
		super.save(shop);
		
		return null;
	}
	
	/**
	 * 查找最新注册的店铺信息
	 */
	public List findLeastRegShop() {
		return super.baseDao.findTopList("select t.shopId from TbShopInfo t order by t.foundDate desc", 10, null);
	}
}
