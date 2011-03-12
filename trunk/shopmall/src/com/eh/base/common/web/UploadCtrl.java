/**
 * 
 */
package com.eh.base.common.web;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.eh.base.controller.BaseCtrl;
import com.eh.base.util.CommonUtil;
import com.eh.base.util.Constants;
import com.eh.base.vo.UserInfo;

/**
 * 文件上传
 * 
 * @author zhoucl
 * 
 */
public class UploadCtrl extends BaseCtrl {
	public String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, 8) + uuid.substring(9, 13)
				+ uuid.substring(14, 18) + uuid.substring(19, 23)
				+ uuid.substring(24);
	}

	/**
	 * 获取图片保存路径
	 * 
	 * @param userInfo
	 * @return
	 */
	private String getImagePath(UserInfo userInfo) {
		if (userInfo.getShopInfo() != null) {
			return Constants.UPLOAD_IMAGE_DIR
					+ userInfo.getShopInfo().getShopId() + "/";
		} else {
			return Constants.UPLOAD_IMAGE_DIR + "public/";
		}
	}

	/**
	 * 上传图片文件
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView image(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo userInfo = super.getUserInfo(request);
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("upload");
			
			String imageExtension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".").toLowerCase();
			if (file != null && file.getSize() > Long.valueOf(0)) {
				String saveDir = getImagePath(userInfo);
				File uploadImageDir = new File(saveDir);
				if (!uploadImageDir.exists()) {
					uploadImageDir.mkdirs();
				}
				String uuid = CommonUtil.getUUID();
				String saveFilePath = saveDir + uuid +"."+ imageExtension;
				File saveFile = new File(saveFilePath);
				file.transferTo(saveFile);
				
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put(STATUS, SUCCESS);
				jsonMap.put("url", super.getContextPath(request)+"/uploads/images/1/"+ uuid +"."+ imageExtension);
				super.renderJson(response, JSONObject.fromObject(jsonMap).toString());
			}
		}
		return null;
	}
}
