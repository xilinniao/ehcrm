package com.eh.shop.admin.logic.impl;

import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;
import com.eh.shop.admin.logic.BrandInfoLogic;
import com.eh.shop.entity.TbBrandInfo;

public class BrandInfoLogicImpl extends BaseLogic implements BrandInfoLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.BrandInfoLogic#saveBrandInfo(com.eh.shop.entity.TbBrandInfo)
	 */
	public String saveBrandInfo(TbBrandInfo entity) {
		if(entity.getBrandId().longValue()==Constants.ADD_PK_ID.longValue()){
			//新增操作
			entity.setBrandId(null);
		}
		super.save(entity);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.BrandInfoLogic#deleteBrandInfo(com.eh.shop.entity.TbBrandInfo)
	 */
	public String deleteBrandInfo(TbBrandInfo entity) {
		int cnt = super.baseDao.count("select count(*) from TbGoodsInfo t where t.brandInfo = ? ", entity);
		if(cnt>0){
			return "发现该品牌下有"+cnt+"个商品，不能删除该品牌"; 
		}else{
			super.remove(entity);
			return null;
		}
	}
	
	
}
