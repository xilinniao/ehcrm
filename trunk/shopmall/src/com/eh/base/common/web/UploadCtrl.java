/**
 * 
 */
package com.eh.base.common.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eh.base.common.logic.CommonLogic;
import com.eh.base.controller.BaseCtrl;
import com.eh.base.entity.TbAttachment;
import com.eh.base.util.CommonUtil;
import com.eh.base.util.Constants;
import com.eh.base.util.ImageUtil;
import com.eh.base.vo.UserInfo;

/**
 * 文件上传
 * 
 * @author zhoucl
 * 
 */
public class UploadCtrl extends BaseCtrl {
	/**
	 * 公用LOGIC
	 */
	CommonLogic commonLogic;
	
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
				
				//是否需要生成缩略图
				String zoom = multipartRequest.getParameter("zoom");
				if("true".equals(zoom)){
					this.zoom(saveDir, uuid, imageExtension, "ss", saveFile,50,50);
					this.zoom(saveDir, uuid, imageExtension, "s", saveFile,150,150);					
				}
				
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put(STATUS, SUCCESS);
				if("true".equals(zoom)){
					TbAttachment attach = new TbAttachment();
					attach.setAttactType(Constants.ATTACHMENT_GOODS);
					attach.setCreateDate(new Date());
					attach.setUserId(userInfo.getUser().getUserId());
					attach.setFileExtension(imageExtension);
					attach.setFileLoaction("/uploads/images/"+userInfo.getShopInfo().getShopId() + "/" + uuid );
					//attach.setFileName(fileName)
					this.commonLogic.save(attach);
					
					jsonMap.put("imagesId", attach.getRecId().toString());
					jsonMap.put("url", super.getContextPath(request)+"/uploads/images/"+userInfo.getShopInfo().getShopId() + "/" + uuid +"_s."+ imageExtension);					
				}else{
					jsonMap.put("url", super.getContextPath(request)+"/uploads/images/"+userInfo.getShopInfo().getShopId() + "/" + uuid +"."+ imageExtension);
				}
				
				
				
				super.renderJson(response, JSONObject.fromObject(jsonMap).toString());
			}
		}
		return null;
	}
	
	
	private void zoom(String saveDir,String uuid,String imageExtension,String another,File saveFile,int width,int height) throws IOException{
		//50*50
		String destFilePath = saveDir + uuid +"_"+another+"."+ imageExtension;
		File destFile = new File(destFilePath);
		BufferedImage srcBufferedImage = ImageIO.read(saveFile);
		ImageUtil.zoom(srcBufferedImage,destFile,width,height);
	}

	public CommonLogic getCommonLogic() {
		return commonLogic;
	}

	public void setCommonLogic(CommonLogic commonLogic) {
		this.commonLogic = commonLogic;
	}
	
	
	
}
