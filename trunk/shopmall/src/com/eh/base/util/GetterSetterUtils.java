/**
 * 
 */
package com.eh.base.util;

import java.lang.reflect.Field;

import com.eh.shop.front.cache.TuanShort;

/**
 * 
 */
public class GetterSetterUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Class c = com.routdata.dm.equipment.queryFilter.ChangeQueryFilter.class;
		Class c = TuanShort.class;
		Field[] fields = c.getDeclaredFields();
		for(int i=0,len=fields.length-1;i<=len;i++){
			if("java.lang.Double".equals(fields[i].getType().getName())){				
				System.out.println("public String get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1)+"Str(){");
				System.out.println("return FormateUtil.getInstance().formateDouble(this."+fields[i].getName()+");");
				System.out.println("}");
			}else if("java.util.Date".equals(fields[i].getType().getName())){
				System.out.println("public String get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1)+"Str(){");
				System.out.println("return DateUtil.getInstance().formateDate(this."+fields[i].getName()+");");
				System.out.println("}");
			}
		}
	}

}
