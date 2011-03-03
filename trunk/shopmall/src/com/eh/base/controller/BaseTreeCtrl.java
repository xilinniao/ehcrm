package com.eh.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.entity.DeptInfo;
import com.eh.base.entity.TreeVo;
import com.eh.exception.BusinessException;

public abstract class BaseTreeCtrl extends BaseCtrl {
	protected Long rootId;
	protected String rootTreeName;
	
	protected void setIsLeaf(List menuList){
		DeptInfo dept = null;
		for (int i = 0, len = menuList.size(); i < len; i++){
			dept = (DeptInfo)menuList.get(i);
			dept.setLeaf(hasChild(menuList, dept.getDeptId()));
		}
	}
	
	protected boolean hasChild(List menuList,Long menuId){
		boolean result = true;
		TreeVo next = null;
		for (int i = 0, len = menuList.size(); i < len; i++){
			next = (TreeVo)menuList.get(i);
			if(next.getParentId()!=null&&menuId.longValue()==next.getParentId().longValue()){
				result=false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param treeList
	 */
	protected void nodeIsLeaf(List treeList){
		TreeVo next = null;
		for (int i = 0, len = treeList.size(); i < len; i++){
			next = (TreeVo)treeList.get(i);
			next.setLeaf(hasChild(treeList, next.getTreeId()));
		}
	}
	
	/**
	 * 判断是否是叶子节点
	 * @param treeList
	 * @param treeId
	 * @return
	 */
	protected boolean nodeHasChild(List treeList,Long treeId){
		boolean result = true;
		TreeVo next = null;
		for (int i = 0, len = treeList.size(); i < len; i++){
			next = (TreeVo)treeList.get(i);
			if(treeId.longValue()==next.getParentId().longValue()){
				result=false;
				break;
			}
		}
		return result;
	}
	/**
	 * 构建树形结构
	 * @param treeList
	 * @param treeId
	 * @param rootTreeId
	 * @param xml
	 * @param loops
	 * @return
	 */
	protected int makeTreeXml(List treeList,Long treeId,Long rootTreeId,StringBuffer xml,int loops)throws BusinessException{
		loops++;
		if(loops>20000){
			throw new BusinessException("菜单数据存在死循环，请调整菜单数据");
		}
		TreeVo next = null;
		for (int i = 0, len = treeList.size(); i < len; i++) {
			next = (TreeVo)treeList.get(i);
			if(next.getTreeId().longValue()==rootTreeId.longValue()){
				continue;
			}
			if(next.getParentId().longValue()==treeId.longValue()){
				xml.append("<li id=\"id_");
				xml.append(next.getTreeId());
				xml.append("\">");
				xml.append("<a href=\"###\">");	
				xml.append(next.getTreeName());
				xml.append("</a>");
				if(!next.isLeaf()){
					xml.append("<ul>\r\n");
				}
				loops = this.makeTreeXml(treeList, next.getTreeId(), rootTreeId, xml, loops);
				if(!next.isLeaf()){
					xml.append("</ul>\r\n");
				}
				xml.append("</li>\r\n");
			}
			
		}
		return loops;
	}
	
	/**
	 * 树状结构
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getXmlTree(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//生成ul li数据		
		List treeList = prepareTree(request,response);
		nodeIsLeaf(treeList);
		StringBuffer treeXml = new StringBuffer("");
		treeXml.append("<ul>");
		treeXml.append("<li id=\"id_");
		treeXml.append(this.rootId);
		treeXml.append("\" class=\"jstree-open\"><a href=\"###\">");
		treeXml.append(this.rootTreeName);
		treeXml.append("</a><ul>");
		makeTreeXml(treeList, this.rootId, this.rootId, treeXml, 1);
		treeXml.append("</ul></li>");
		treeXml.append("</ul>");
		super.rendText(response, treeXml.toString());
		return null;
	}	
	/**
	 * 获取树形结构LIST
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected abstract List prepareTree(HttpServletRequest request,HttpServletResponse response)throws Exception;
}
