package com.eh.base.common.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.WebUtils;

import com.eh.base.util.Constants;
import com.eh.base.util.VelocityUtils;

public class InitConfigServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		InputStream is = null;
		// 读取配置文件
		Properties p = loadGobalSetting();
		String fileUploadPath = p.getProperty("file_upload_path");
		if (StringUtils.isBlank(fileUploadPath)) {
			try {
				fileUploadPath = WebUtils.getRealPath(
						super.getServletContext(), "/uploads");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		Constants.FILE_UPLOAD_PATH = fileUploadPath;
		
		Constants.UPLOAD_IMAGE_DIR = fileUploadPath+"/images/";
		Constants.UPLOAD_MEDIA_DIR = fileUploadPath+"/media/";
		Constants.UPLOAD_FILE_DIR = fileUploadPath+"/files/";		
		Constants.APP_PATH = p.getProperty("app_path");

		// 导入velocity配置信息
		try {
			String velocityPath = WebUtils.getRealPath(super.getServletContext(), "/WEB-INF/classes/config/velocity");
			VelocityUtils.velocityPath = velocityPath;
			VelocityUtils.loadConfigs();
		} catch (FileNotFoundException e) {
		}
	}

	private Properties loadGobalSetting() {
		InputStream is = null;
		try {
			Properties globalSetting = new Properties();
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			is = cl.getResourceAsStream("config/config_mysql.properties");
			globalSetting.load(is);
			return globalSetting;
		} catch (IOException e) {
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
