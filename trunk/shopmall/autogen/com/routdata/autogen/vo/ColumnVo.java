package com.routdata.autogen.vo;

import com.routdata.autogen.util.UpperHandle;

/**
 * 
TABLE_CAT
TABLE_SCHEM
TABLE_NAME
COLUMN_NAME
DATA_TYPE
TYPE_NAME
COLUMN_SIZE
BUFFER_LENGTH
DECIMAL_DIGITS
NUM_PREC_RADIX
NULLABLE
REMARKS
COLUMN_DEF
SQL_DATA_TYPE
SQL_DATETIME_SUB
CHAR_OCTET_LENGTH
ORDINAL_POSITION
IS_NULLABLE
 * @author zhoucl
 *
 */
public class ColumnVo {
	boolean pk;//是否PK
	String columnName;
	String javaName;//java 属性名称
	String javaNameFU;//java 第一个字母大写
	String javaType;//java数据类型
	String typeName;
	String isNullAble;
	String columnSize;
	String remark;
	int datasize;
	int digits;
	String isList;//是否在列表中出现
	String isQry;//是否在查询中出现
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
		int idx = this.columnName.indexOf("_");
		if(idx==1){
			this.javaName = UpperHandle.attrCaseConvert(this.columnName.toLowerCase().substring(++idx));
		}else{
			this.javaName = UpperHandle.attrCaseConvert(this.columnName.toLowerCase());
		}
		this.javaNameFU = UpperHandle.javaCaseConvert(this.javaName);
	}
	
	public String getJavaNameFU() {
		return javaNameFU;
	}
	public void setJavaNameFU(String javaNameFU) {
		this.javaNameFU = javaNameFU;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
		if("NUMBER".equals(typeName)){
			if(this.digits==0){
				this.javaType = "Long";
			}else{
				this.javaType = "Double";
			}
		}if("DOUBLE".equals(typeName)){
			this.javaType = "Double";
		}else if("VARCHAR".equals(typeName)){
			this.javaType = "String";
		}else if("DATE".equals(typeName)||"DATETIME".equals(typeName)){
			this.javaType = "Date";
		}else if("INT".equals(typeName)){
			this.javaType = "Long";
		}else if("TEXT".equals("TEXT")){
			this.javaType = "String";
		}
	}
	public boolean getIsNullAble() {
		return "true".equalsIgnoreCase(isNullAble);
	}
	public void setIsNullAble(String isNullAble) {
		this.isNullAble = isNullAble;
	}
	public String getColumnSize() {
		return columnSize;
	}
	public void setColumnSize(String columnSize) {
		this.columnSize = columnSize;
	}
	public boolean isPk() {
		return pk;
	}
	public void setPk(boolean pk) {
		this.pk = pk;
	}
	public int getDatasize() {
		return datasize;
	}
	public void setDatasize(int datasize) {
		this.datasize = datasize;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public int getDigits() {
		return digits;
	}
	public void setDigits(int digits) {
		this.digits = digits;
	}
	public String getJavaName() {
		return javaName;
	}
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean getIsList() {
		return "YES".equalsIgnoreCase(isList);
	}
	public void setIsList(String isList) {
		this.isList = isList;
	}
	public boolean getIsQry() {
		return "YES".equalsIgnoreCase(isQry);
	}
	public void setIsQry(String isQry) {
		this.isQry = isQry;
	}
}
