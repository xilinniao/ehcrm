package com.routdata.autogen.vo;

import com.routdata.autogen.util.UpperHandle;

public class GobalVo {
	String tableName;
	String seqName;
	String entityName;
	String defaultPackage;
	String entityPackage;
	String hbmFilePath;
	String moduleNameEn;
	String moduleNameEnJava;
	String moduleNameChn;
	String jspFilePath;
	String url;
	ColumnVo pk;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
		int idx = this.tableName.indexOf("_");
		this.seqName = this.tableName.substring(++idx);
		this.tableName = tableName;
	}
	public String getDefaultPackage() {
		return defaultPackage;
	}
	public void setDefaultPackage(String defaultPackage) {
		this.defaultPackage = defaultPackage;
	}
	public String getEntityPackage() {
		return entityPackage;
	}
	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}
	public String getHbmFilePath() {
		return hbmFilePath;
	}
	public void setHbmFilePath(String hbmFilePath) {
		this.hbmFilePath = hbmFilePath;
	}
	public String getModuleNameEn() {
		return moduleNameEn;
	}
	public void setModuleNameEn(String moduleNameEn) {
		this.moduleNameEn = moduleNameEn;
		this.moduleNameEnJava = UpperHandle.javaCaseConvert(this.moduleNameEn);
	}
	public String getModuleNameChn() {
		return moduleNameChn;
	}
	public void setModuleNameChn(String moduleNameChn) {
		this.moduleNameChn = moduleNameChn;
	}
	public String getJspFilePath() {
		return jspFilePath;
	}
	public void setJspFilePath(String jspFilePath) {
		this.jspFilePath = jspFilePath;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getSeqName() {
		return seqName;
	}
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
	public String getModuleNameEnJava() {
		return moduleNameEnJava;
	}
	public void setModuleNameEnJava(String moduleNameEnJava) {
		this.moduleNameEnJava = moduleNameEnJava;
	}
	public ColumnVo getPk() {
		return pk;
	}
	public void setPk(ColumnVo pk) {
		this.pk = pk;
	}
	
}
