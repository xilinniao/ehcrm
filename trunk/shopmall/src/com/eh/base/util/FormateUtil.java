package com.eh.base.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import com.eh.base.entity.CodeName;

public class FormateUtil {
	private static FormateUtil instance;
	public final NumberFormat MONEY_FORMATE = new DecimalFormat("##0.00");

	public static FormateUtil getInstance() {
		if (instance == null) {
			instance = new FormateUtil();
		}
		return instance;
	}

	public String formateDouble(Double value) {
		return this.formateDouble(value, "");
	}
	
	/**
	 * 格式化DOUBLE
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public String formateDouble(Double value, String defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			return MONEY_FORMATE.format(value);
		}
	}
	
	/**
	 * 得到参数中文名
	 * @param cns
	 * @param val
	 * @return
	 */
	public String getNameByCode(String paramType,String paramCode){
		List<CodeName> codes = (List<CodeName>)Constants.params.get(paramType);
		String ret = "";
		if(paramCode!=null&&codes!=null){
			for(CodeName next:codes){
				if(paramCode.equals(next.getCode())){
					ret = next.getName();
					break;
				}
			}
		}
		return ret;
	}
}
