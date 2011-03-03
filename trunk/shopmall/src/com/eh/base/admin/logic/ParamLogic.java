package com.eh.base.admin.logic;

import java.util.List;

import com.eh.base.entity.TbBaseParams;
import com.eh.base.logic.IBaseLogic;

public interface ParamLogic extends IBaseLogic {
	public List findParamTree(String treeNo);
	public Long saveParamInfo(TbBaseParams  param);
}
