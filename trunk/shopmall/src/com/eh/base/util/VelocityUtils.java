package com.eh.base.util;

import java.io.File;
import java.io.FileFilter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.FastHashMap;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用Velocity生成内容的工具类.
 * 
 * @author calvin
 */
public class VelocityUtils {

	static {
		try {
			Velocity.init();
		} catch (Exception e) {
			throw new RuntimeException(
					"Exception occurs while initialize the velociy.", e);
		}
	}
	
	/**
	 * velocityPath 路径
	 */
	public static String velocityPath;
	/**
	 * 配置信息
	 */
	public static FastHashMap configs = new FastHashMap();	
	/**
	 * 导入配置信息
	 * @param velocityPath
	 */
	public static void loadConfigs() {
		File dir = new File(velocityPath);
		File file[] = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return false;
				}
				String name = file.getName();
				int idx = name.lastIndexOf(".");
				if (idx == -1) {
					return false;
				} else if (idx == name.length() - 1) {
					return false;
				} else {
					return "xml".equalsIgnoreCase(name.substring(idx + 1));
				}
			}

		});

		for (int i = 0; i < file.length; i++) {
			// 解释XML
			Document document = null;
			try {
				SAXReader saxReader = new SAXReader();
				document = saxReader.read(file[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List loadconfigs = document.selectNodes("/root/velocity");
			Element elm = null;
			for (int j = 0, lenj = loadconfigs.size(); j < lenj; j++) {
				elm = (Element) loadconfigs.get(j);
				configs.put(elm.attribute("name").getText(), elm.getTextTrim());
			}
		}
	}
	/**
	 * 渲染内容.
	 * 
	 * @param template
	 *            模板内容.
	 * @param model
	 *            变量Map.
	 */
	public static String render(String templateName, Map<String, ?> model) {
		loadConfigs();
		String template =(String) configs.get(templateName);
		try {
			VelocityContext velocityContext = new VelocityContext(model);
			StringWriter result = new StringWriter();
			Velocity.evaluate(velocityContext, result, "", template);
			return result.toString();
		} catch (Exception e) {
			throw new RuntimeException("Parse template failed.", e);
		}
	}
}
