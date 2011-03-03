package com.eh.base.admin.logic.impl;

import java.util.List;

import com.eh.base.admin.logic.DeptLogic;
import com.eh.base.admin.web.qo.DeptQuery;
import com.eh.base.entity.TbDeptInfo;
import com.eh.base.entity.TbDeptRel;
import com.eh.base.entity.DeptInfo;
import com.eh.base.logic.BaseLogic;

public class DeptLogicImpl extends BaseLogic implements DeptLogic {

	public List findDeptTree(DeptQuery qry) {
		return super.baseDao
				.find("select new com.eh.base.entity.TreeVo(d.deptId as treeId,d.parent.deptId as parentId,d.deptCode as treeCode,d.deptName as treeName,d.treeNo as treeNo) from DeptInfo d where d.treeNo like ? and d.deptStatus = 0 order by treeNo",new Object[]{qry.getTreeNoLike()});
	}

	/**
     * 根据机构号查询机构信息
     * @param code
     * @return
     * @throws SysException
     */
    public TbDeptInfo findDepByCode(String code){
    	TbDeptInfo result = null;
        String hql = "from DeptInfo as d where d.deptCode=? ";

        List list = this.baseDao.find(hql, new String[] { code});

        if ((list != null) && (list.size() > 0)) {
            result = (TbDeptInfo) list.get(0);
        }

        return result;
    }


	/* (non-Javadoc)
	 * @see com.jcrm.admin.logic.DeptLogic#saveDeptInfo(com.jcrm.entity.DeptInfo, java.lang.Long)
	 */
	public Long saveDeptInfo(TbDeptInfo dept, Long parentDeptId) {
		if(dept.getDeptId().longValue()==Long.valueOf(-99)){
			dept.setDeptId(null);
			super.save(dept);
			
			TbDeptInfo parent = super.load(TbDeptInfo.class, parentDeptId);
			TbDeptRel rel = new TbDeptRel();
			rel.setParent(parent);
			rel.setRelType(Long.valueOf(1));
			rel.setDept(dept);
			
			super.save(rel);
			DeptInfo vparent = super.load(DeptInfo.class, parentDeptId);
			loopDept(parentDeptId,vparent.getTreeNo());
		}else{
			super.save(dept);
			DeptInfo vparent = super.load(DeptInfo.class, parentDeptId);
			loopDept(parentDeptId,vparent.getTreeNo());
		}
		return dept.getDeptId();
	}
	
	private void loopDept(Long pid,String treeNo){
		List childs = super.baseDao.find("from TbDeptRel t where t.parent.deptId = ? order by t.dept.sortNum asc,t.dept.deptId asc", pid);
		String myTreeNo = "";
		TbDeptRel rel = null;
		for(int i = 0,len = childs.size();i<len;i++){
			rel = (TbDeptRel)childs.get(i);
			myTreeNo = treeNo+String.valueOf(100+i);
			rel.setTreeNo(myTreeNo);
			super.save(rel);
			loopDept(rel.getDept().getDeptId(),rel.getTreeNo());
		}
	}
}
