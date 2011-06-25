package com.eh.base.util;

import java.util.List;

import com.eh.base.entity.CodeName;

/**
 * html代码生成类
 *
 */
public class HtmlTag {
	/**
	 * 生成选择下拉框
	 * @return
	 */
	public static String generateSelect(String selectStr,String defaultName,String paramType){
		List<CodeName> codes = (List<CodeName>)Constants.params.get(paramType);
		StringBuffer buf = new StringBuffer(selectStr);	
		
		buf.append("<option value=\"\">");
		buf.append(defaultName);
		buf.append("</option>");
		
		for(CodeName next:codes){
			buf.append("<option value=\"");
			buf.append(next.getCode());
			buf.append("\">");
			buf.append(next.getName());
			buf.append("</option>");
		}
		
		buf.append("</select>");
		return buf.toString();
	}	
}
