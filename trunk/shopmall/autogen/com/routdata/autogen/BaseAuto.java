package com.routdata.autogen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.routdata.autogen.util.UpperHandle;
import com.routdata.autogen.vo.ColumnVo;
import com.routdata.autogen.vo.GobalVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class BaseAuto extends TestCase {
	private Configuration freemarkerCfg = null;
	Connection conn = null;
	
	/**
	 * 初始化FreeMaker
	 * @return
	 */
	protected Configuration getFreeMarkerCfg() {
		if (freemarkerCfg == null) {
			freemarkerCfg = new Configuration();
			freemarkerCfg.setBooleanFormat("true,false");
            freemarkerCfg.setDefaultEncoding("UTF-8");
			freemarkerCfg.setClassForTemplateLoading(this.getClass(), getTemplatePath());
		}
		return freemarkerCfg;
	}
	
	/**
	 * 生成静态文件.
	 * 
	 * @param templateFileName
	 *            模板文件名,相对htmlskin路径,例如"/tpxw/view.ftl"
	 * @param propMap
	 *            用于处理模板的属性Object映射
	 * @param htmlFilePath
	 *            要生成的静态文件的路径,相对设置中的根路径,例如 "/tpxw/1/2005/4/"
	 * @param htmlFileName
	 *            要生成的文件名,例如 "1.htm"
	 */
	public boolean generateFile(String templateFileName, Map propMap,
			String htmlFilePath, String htmlFileName) {
		String sRootDir = "E:/work/shopmall/build";

		try {
			Template t = getFreeMarkerCfg().getTemplate(templateFileName);

			// 如果根路径存在,则递归创建子目录
			creatDirs(sRootDir, htmlFilePath);
			
			File dir= new File(sRootDir + "/" + htmlFilePath );
			if(!dir.exists()){
				dir.mkdir();
			}

			File afile = new File(sRootDir + "/" + htmlFilePath + "/"
					+ htmlFileName);

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(afile),"UTF-8"));

			t.process(propMap, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean creatDirs(String aParentDir, String aSubDir) {
		File aFile = new File(aParentDir);
		if (aFile.exists()) {
			File aSubFile = new File(aParentDir + "/" + aSubDir);
			if (!aSubFile.exists()) {
				return aSubFile.mkdirs();
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public String getTemplatePath(){
		return "/fmt/crud/files";
	}
	public String getXmlPath(){
		return "E:\\work\\shopmall\\autogen\\fmt\\crud\\config.xml";
	}
	
	Map data = null;
	GobalVo gobalVo = null;
	
	//获取列信息http://www.java2s.com/CN/Code/Java/Database-SQL-JDBC/GetColumnNamesFromResultSetforOracle.htm
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String jdbc_url="jdbc:mysql://localhost:3306/shopmall?user=root";
		conn = DriverManager.getConnection(jdbc_url);
		
		//1、读取配置信息
		String xmlPath = getXmlPath();
		Document doc = this.getDocument(xmlPath);
		Element root = doc.getRootElement();
		Element gobal = root.getChild("gobal");
		Element elmColumns = root.getChild("columns");
		
		gobalVo = new GobalVo();
		gobalVo.setTableName(gobal.getChild("table_name").getText());
		gobalVo.setDefaultPackage(gobal.getChild("default_package").getText());
		gobalVo.setEntityPackage(gobal.getChild("entity_package").getText());
		gobalVo.setHbmFilePath(gobal.getChild("hbm_file_path").getText());
		gobalVo.setModuleNameEn(gobal.getChild("module_name_en").getText());
		gobalVo.setModuleNameChn(gobal.getChild("module_name_chn").getText());
		gobalVo.setJspFilePath(gobal.getChild("jsp_file_path").getText());
		gobalVo.setUrl(gobal.getChild("url").getText());
		gobalVo.setEntityName(UpperHandle.javaCaseConvert(gobalVo.getTableName().toLowerCase()));
		
		DatabaseMetaData  dbMeta = conn.getMetaData();
		ResultSet rs = dbMeta.getColumns(null,"LYFX",gobalVo.getTableName().trim().toUpperCase(),null);
		
		ResultSet rss = dbMeta.getPrimaryKeys(null, null, gobalVo.getTableName().trim().toUpperCase());
		String pk = "";
		while(rss!=null && rss.next()){
			pk +=rss.getString("COLUMN_NAME");			
		}
		
		
		//获取列数据信息 
		/*ResultSetMetaData md = rs.getMetaData();
		int cloumCount = md.getColumnCount();
		for(int i=1;i<=cloumCount;i++){
			String type = md.getColumnTypeName(i);
			System.out.println(md.getColumnName(i));
		}*/
		
		List<ColumnVo> colList = new ArrayList();
		while(rs!=null && rs.next()){
			ColumnVo columnVo = new ColumnVo();
			columnVo.setColumnName(rs.getString("COLUMN_NAME"));
			columnVo.setIsNullAble(rs.getString("IS_NULLABLE"));
			columnVo.setColumnSize(rs.getString("COLUMN_SIZE"));
			columnVo.setDatasize(rs.getInt("COLUMN_SIZE"));
			columnVo.setDigits(rs.getInt("DECIMAL_DIGITS"));
			columnVo.setPk(StringUtils.contains(pk, rs.getString("COLUMN_NAME")));
			columnVo.setTypeName(rs.getString("TYPE_NAME"));
			columnVo.setRemark(rs.getString("REMARKS"));
			colList.add(columnVo);
		}
		
		for(ColumnVo next:colList){
			if(next.isPk()){
				gobalVo.setPk(next);
				break;
			}
		}
		
		Element columns = new Element("columns");		
		for(ColumnVo next:colList){
			Element column = new Element("column");
			column.setAttribute(new Attribute("pk",String.valueOf(next.isPk())));
			column.setAttribute(new Attribute("columnName",String.valueOf(next.getColumnName())));
			//column.setAttribute(new Attribute("javaName",String.valueOf(next.getJavaName())));
			//column.setAttribute(new Attribute("javaNameFU",String.valueOf(next.getJavaNameFU())));
			column.setAttribute(new Attribute("javaType",String.valueOf(next.getJavaType())));
			column.setAttribute(new Attribute("typeName",String.valueOf(next.getTypeName())));
			column.setAttribute(new Attribute("isNullAble",String.valueOf(next.getIsNullAble())));
			column.setAttribute(new Attribute("columnSize",String.valueOf(next.getColumnSize())));
			column.setAttribute(new Attribute("remark",String.valueOf(next.getRemark())));
			column.setAttribute(new Attribute("datasize",String.valueOf(next.getDatasize())));
			column.setAttribute(new Attribute("digits",String.valueOf(next.getDigits())));
			column.setAttribute(new Attribute("isList","YES"));
			column.setAttribute(new Attribute("isQry","NO"));
			columns.addContent(column);
		}
		root.addContent(columns);
		
		Format f = Format.getPrettyFormat();
		f.setEncoding("UTF-8");
		XMLOutputter output = new XMLOutputter();
		output.setFormat(f);
		output.output(doc,new FileOutputStream(this.getXmlPath()+"cfg"));
		
		//重新读取列数值
		
		List<ColumnVo> colList2 = new ArrayList();
		if(elmColumns!=null){
		List<Element> colunmList = elmColumns.getChildren("column");
			for(Element next:colunmList){
				ColumnVo columnVo = new ColumnVo();				 
				columnVo.setColumnName(next.getAttributeValue("columnName"));
				columnVo.setIsNullAble(next.getAttributeValue("isNullAble"));
				columnVo.setColumnSize(next.getAttributeValue("columnSize"));
				columnVo.setDatasize(Integer.parseInt(next.getAttributeValue("datasize")));
				columnVo.setDigits(Integer.parseInt(next.getAttributeValue("digits")));
				columnVo.setPk(Boolean.parseBoolean(next.getAttributeValue("pk")));
				columnVo.setTypeName(next.getAttributeValue("typeName"));
				columnVo.setRemark(next.getAttributeValue("remark"));
				columnVo.setIsList(next.getAttributeValue("isList"));
				columnVo.setIsQry(next.getAttributeValue("isQry"));
				colList2.add(columnVo);
			}
		}
		data = new HashMap();
		data.put("gobalVo", gobalVo);
		data.put("colList", colList2);
	}
	
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		conn.close();
	}
	
	public void testTree() throws Exception {
		generateFile("hbm.xml.fmt",data,"src/"+StringUtils.replace(gobalVo.getHbmFilePath(), ".", "/"),UpperHandle.javaCaseConvert(gobalVo.getTableName().toLowerCase())+".hbm.xml");
		generateFile("entity.java.fmt",data,"src/"+StringUtils.replace(gobalVo.getEntityPackage(), ".", "/"),UpperHandle.javaCaseConvert(gobalVo.getTableName().toLowerCase())+".java");
		generateFile("ctrl.java.fmt",data,"src/"+StringUtils.replace(gobalVo.getDefaultPackage(), ".", "/")+"/web",UpperHandle.javaCaseConvert(gobalVo.getModuleNameEnJava())+"Ctrl.java");
		generateFile("qry.java.fmt",data,"src/"+StringUtils.replace(gobalVo.getDefaultPackage(), ".", "/")+"/web/qry",UpperHandle.javaCaseConvert(gobalVo.getModuleNameEnJava())+"Qry.java");
		generateFile("Logic.java.fmt",data,"src/"+StringUtils.replace(gobalVo.getDefaultPackage(), ".", "/")+"/logic",UpperHandle.javaCaseConvert(gobalVo.getModuleNameEnJava())+"Logic.java");
		generateFile("LogicImpl.java.fmt",data,"src/"+StringUtils.replace(gobalVo.getDefaultPackage(), ".", "/")+"/logic/impl",UpperHandle.javaCaseConvert(gobalVo.getModuleNameEnJava())+"LogicImpl.java");
		generateFile("index.jsp.fmt",data,"WebRoot/"+gobalVo.getJspFilePath(),"index.jsp");
		generateFile("edit.jsp.fmt",data,"WebRoot/"+gobalVo.getJspFilePath(),"edit.jsp");
		generateFile("spring.xml.fmt",data,"src/config/spring/","application-"+gobalVo.getModuleNameEn()+".xml");
	}
	
	/**
	 * 获取文档
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Document getDocument(String xmlPath) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(xmlPath);
		return document;
	}
}
