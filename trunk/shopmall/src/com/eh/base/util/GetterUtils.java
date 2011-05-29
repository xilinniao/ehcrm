/**
 * 
 */
package com.eh.base.util;

import java.lang.reflect.Field;

import com.eh.shop.entity.TbShopInfo;


/**
 * @author jcrm
 *
 */
public class GetterUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class c = TbShopInfo.class;
		Field[] fields = c.getDeclaredFields();
		for(int i=0,len=fields.length-1;i<=len;i++){
			if("java.lang.xhtmluble".equals(fields[i].getType().getName())){				
				System.out.println("public String get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1)+"Str(){");
				System.out.println("return FormateUtil.getInstance().formateDouble(this."+fields[i].getName()+",null);");
				System.out.println("}");
			}else if("java.util.Date".equals(fields[i].getType().getName())){
				System.out.println("public String get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1)+"Str(){");
				System.out.println("return DateUtil.getInstance().formateDate(this."+fields[i].getName()+",DateUtil.DF_YYYY_MM_DD_HH_MM);");
				System.out.println("}");
			}
			//System.out.println("\""+fields[i].getName()+"\":\"${"+fields[i].getName()+"!''}\",");
			//System.out.println("\"${"+fields[i].getName()+"!''}\",");
		}
		
		
		for(int i=0,len=fields.length-1;i<=len;i++){		
			//$('#deptName').val(data.deptName);
			//System.out.println("$('#"+fields[i].getName()+"').val(data."+fields[i].getName()+");");
		}

	}

}
