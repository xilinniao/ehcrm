package com.eh.base.admin.logic;

import java.util.List;

import com.eh.base.admin.web.qo.DeptQuery;
import com.eh.base.entity.TbDeptInfo;
import com.eh.base.logic.IBaseLogic;

public interface DeptLogic extends IBaseLogic {
	public List findDeptTree(DeptQuery qry);	
	/**
     * 根据机构号查询机构信息
     * @param code
     * @return
     * @throws SysException
     */
    public TbDeptInfo findDepByCode(String code);
    /**
     * 保存机构信息
     * @param dept
     * @param parentDeptId
     */
    public Long saveDeptInfo(TbDeptInfo dept,Long parentDeptId);
}
