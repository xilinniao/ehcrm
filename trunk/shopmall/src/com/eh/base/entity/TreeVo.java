/**
 * 
 */
package com.eh.base.entity;

/**
 * 树形结构VO对象
 * Oct 25, 2010
 */
public class TreeVo {
	/**
	 * ID
	 */
	Long treeId;
	/**
	 * 上级树结构ID
	 */
	Long parentId;
	/**
	 * 树状机构编码
	 */
	String treeCode;
	/**
	 * 树形结构名称
	 */
	String treeName;
	/**
	 * 数编码
	 */
	String treeNo;
	/**
	 * 更多其他信息
	 */
	String addOn;
	/**
	 * 是否是叶子节点
	 */
	boolean isLeaf;	
	
	public Long getTreeId() {
		return treeId;
	}
	public void setTreeId(Long treeId) {
		this.treeId = treeId;
	}
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public String getTreeNo() {
		return treeNo;
	}
	public void setTreeNo(String treeNo) {
		this.treeNo = treeNo;
	}
	public String getAddOn() {
		return addOn;
	}
	public void setAddOn(String addOn) {
		this.addOn = addOn;
	}
	
	public String getTreeCode() {
		return treeCode;
	}
	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public TreeVo(Long treeId, Long parentId, String treeCode, String treeName,
			String treeNo) {
		super();
		this.treeId = treeId;
		this.parentId = parentId;
		this.treeCode = treeCode;
		this.treeName = treeName;
		this.treeNo = treeNo;
	}
	public TreeVo() {
		super();
	}
	
	
}
