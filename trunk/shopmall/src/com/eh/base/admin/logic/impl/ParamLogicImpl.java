package com.eh.base.admin.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.eh.base.admin.logic.ParamLogic;
import com.eh.base.entity.TbBaseParams;
import com.eh.base.entity.TreeVo;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.Constants;

public class ParamLogicImpl extends BaseLogic implements ParamLogic {

	public List<TreeVo> findParamTree(String treeNo) {
		List tmpList = super.baseDao.find("from TbBaseParams t where t.treeNo like ? order by t.treeNo ",treeNo+"%");
		List paramList = new ArrayList();
		for(int i = 0,len = tmpList.size();i<len;i++){
			TbBaseParams paramInfo = (TbBaseParams)tmpList.get(i);
			TreeVo vo = new TreeVo();
			vo.setTreeId(paramInfo.getKeyId());
			vo.setParentId(paramInfo.getParent()!=null?paramInfo.getParent().getKeyId():null);
			vo.setTreeName(paramInfo.getKeyName());
			vo.setTreeNo(paramInfo.getTreeNo());
			paramList.add(vo);
		}
		return paramList;
	}

	public Long saveParamInfo(TbBaseParams param) {
		if(param.getKeyId().longValue()==Long.valueOf(-99)){
			param.setKeyId(null);
			param.setKeyStatus(Constants.YES);
			super.save(param);
			loopParam(param.getParent().getKeyId(),param.getParent().getTreeNo());
		}else{
			super.save(param);
			loopParam(param.getParent().getKeyId(),param.getParent().getTreeNo());
		}
		return param.getKeyId();
	}
	
	private void loopParam(Long pid,String treeNo){
		List childs = super.baseDao.find("from TbBaseParams t where t.parent.keyId = ? order by t.orderNum asc", pid);
		String myTreeNo = "";
		TbBaseParams param = null;
		for(int i = 0,len = childs.size();i<len;i++){
			param = (TbBaseParams)childs.get(i);
			myTreeNo = treeNo+String.valueOf(100+i);
			param.setTreeNo(myTreeNo);
			super.save(param);
			loopParam(param.getKeyId(),param.getTreeNo());
		}
	}
}
