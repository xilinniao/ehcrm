package com.eh.base.entity;



/**
 * RoleInfo generated by MyEclipse Persistence Tools
 */

public class TbRoleInfo  implements java.io.Serializable {
	public static final Long ROLE_ROOT_ID = Long.valueOf(1);
    // Fields    

     private Long roleId;
     private TbRoleInfo parent;
     private String roleCode;
     private String roleName;
     private String roleDesc;
     private Long status;
     private Long sortNum;
     private String treeNo;


    // Constructors

    /** default constructor */
    public TbRoleInfo() {
    }

    
    /** full constructor */
    public TbRoleInfo(TbRoleInfo parent, String roleName, String roleDesc, Long status, Long sortNum, String treeNo) {
        this.parent = parent;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.status = status;
        this.sortNum = sortNum;
        this.treeNo = treeNo;
    }

   
    // Property accessors

    public Long getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public TbRoleInfo getParent() {
        return this.parent;
    }
    
    public void setParent(TbRoleInfo parent) {
        this.parent = parent;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Long getStatus() {
        return this.status;
    }
    
    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getSortNum() {
        return this.sortNum;
    }
    
    public void setSortNum(Long sortNum) {
        this.sortNum = sortNum;
    }

    public String getTreeNo() {
        return this.treeNo;
    }
    
    public void setTreeNo(String treeNo) {
        this.treeNo = treeNo;
    }


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
   








}