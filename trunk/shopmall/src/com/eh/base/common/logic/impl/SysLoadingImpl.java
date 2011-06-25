/**
 * 
 */
package com.eh.base.common.logic.impl;

import java.util.List;

import com.eh.base.entity.CodeName;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;

/**
 * 系统启动时数据导入
 */
public class SysLoadingImpl extends BaseLogic{	
	/**
	 * 载入系统所需数据
	 */
	public synchronized void loadData() {
		List<String> paramList = baseDao.find("select t.kindCode from TbParamKind t");
		for(String next:paramList){
			Constants.params.put(next, this.findParamItemList(next));
		}
	}
	
	/**
	 * 查找参数列表信息
	 * @param paramKind
	 * @return
	 */
	protected List<CodeName> findParamItemList(String paramKind){
		return (List<CodeName>)super.find("select new com.eh.base.entity.CodeName(t.itemCode as code,t.itemName as name) from TbParamItem t where t.kindCode = ? order by t.orderNum asc ",paramKind);
	}
}
