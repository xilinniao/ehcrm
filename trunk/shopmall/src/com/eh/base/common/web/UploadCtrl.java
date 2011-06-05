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
import com.eh.base.util.DateUtil;
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
		String today = DateUtil.getInstance().formateDate(new Date(),DateUtil.DF_YYYYMMDD);
		return Constants.UPLOAD_IMAGE_DIR + today + "/";
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
					this.zoom(saveDir, uuid, imageExtension, "a", saveFile,50,50);
					this.zoom(saveDir, uuid, imageExtension, "b", saveFile,100,100);
					this.zoom(saveDir, uuid, imageExtension, "e", saveFile,130,130);
					this.zoom(saveDir, uuid, imageExtension, "c", saveFile,160,160);
					this.zoom(saveDir, uuid, imageExtension, "d", saveFile,350,350);
				}
				
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put(STATUS, SUCCESS);
				
				String today = DateUtil.getInstance().formateDate(new Date(),DateUtil.DF_YYYYMMDD);
				if("true".equals(zoom)){
					TbAttachment attach = new TbAttachment();
					attach.setAttactType(Constants.ATTACHMENT_GOODS);
					attach.setCreateDate(new Date());
					attach.setUserId(userInfo.getUser().getUserId());
					attach.setFileExtension(imageExtension);
					
					attach.setFilePathA(super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_a."+ imageExtension);
					attach.setFilePathB(super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_b."+ imageExtension);
					attach.setFilePathC(super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_c."+ imageExtension);
					attach.setFilePathD(super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_d."+ imageExtension);
					attach.setFilePathE(super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_e."+ imageExtension);
					attach.setFilePathF(super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"."+ imageExtension);
					
					this.commonLogic.save(attach);
					
					jsonMap.put("imgid", attach.getRecId().toString());
					jsonMap.put("urla", super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_a."+ imageExtension);
					jsonMap.put("urlb", super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_b."+ imageExtension);
					jsonMap.put("urlc", super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_c."+ imageExtension);
					jsonMap.put("urld", super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_d."+ imageExtension);
					jsonMap.put("urle", super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_e."+ imageExtension);
					jsonMap.put("urlf", super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"_f."+ imageExtension);
				}else{
					jsonMap.put("url", super.getContextPath(request)+"/uploads/images/"+today + "/" + uuid +"."+ imageExtension);
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
