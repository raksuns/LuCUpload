package com.luxsky.chat.upload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.luxsky.chat.common.BaseAction;
import com.luxsky.chat.common.ConstField;


/**
 * 사용자 프로필 이미지 설정.
 */

public class ChatImageUploadAction extends BaseAction implements ServletRequestAware {
	
	private static final long serialVersionUID = 4875717676369370044L;
	
	private HttpServletRequest servletRequest;
	private String talk_room_id;
	private File originImage;
	private String originImageFileName;
	private File thumbImage;
	private String thumbImageFileName;
	private int thumbSizeWidth;
	private int thumbSizeHeight;
	
	@Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }
	
	public String upload() {
		
		Map<String, Object> map = new HashMap<String, Object>();

		try {			
			accessLogger.info("*******************************************************************");
			accessLogger.info("[ChatImageUploadAction : Client -> Server]");
			accessLogger.info("uploadDir : " + uploadChatDir);
			accessLogger.info("rood_id : " + this.talk_room_id);
			accessLogger.info("originImage : " + this.originImage);
			accessLogger.info("originImageFileName : " + this.originImageFileName);
			accessLogger.info("thumbImage : " + this.thumbImage);
			accessLogger.info("thumbImageFileName : " + this.thumbImageFileName);
			
			uploadChatDir = uploadChatDir + talk_room_id;
			
			accessLogger.info("Chat Dir : " + uploadChatDir);
			File orgFile = new File(uploadChatDir, originImageFileName);
			FileUtils.copyFile(originImage, orgFile);
			
			File thumbFile = new File(uploadChatDir, thumbImageFileName);
			FileUtils.copyFile(thumbImage, thumbFile);
			
			map.put("status", 0);
			map.put("origUrl", serverHost + webChatPath + talk_room_id + "/" + originImageFileName);
			map.put("thumbUrl", serverHost + webChatPath + talk_room_id + "/" + thumbImageFileName);
			map.put("thumbSizeWidth", thumbSizeWidth);
			map.put("thumbSizeHeight", thumbSizeHeight);
			
			jsonResult = JSONObject.fromObject(map);
			
			accessLogger.info("[ChatImageUploadAction : Server -> Client]");
			accessLogger.info("[" + jsonResult.toString() + "]");
		}
		catch(Exception e){
			errorLogger.error("", e);
			map.put("status", ConstField.ERROR_FILEUPLOAD);
			jsonResult = JSONObject.fromObject(map);
			super.setMessage(e.getMessage());
		}
		return SUCCESS;
	}

	public String getTalk_room_id() {
		return talk_room_id;
	}

	public void setTalk_room_id(String rood_id) {
		this.talk_room_id = rood_id;
	}

	public File getOriginImage() {
		return originImage;
	}

	public void setOriginImage(File originImage) {
		this.originImage = originImage;
	}

	public String getOriginImageFileName() {
		return originImageFileName;
	}

	public void setOriginImageFileName(String originImageFileName) {
		this.originImageFileName = originImageFileName;
	}

	public File getThumbImage() {
		return thumbImage;
	}

	public void setThumbImage(File thumbImage) {
		this.thumbImage = thumbImage;
	}

	public String getThumbImageFileName() {
		return thumbImageFileName;
	}

	public void setThumbImageFileName(String thumbImageFileName) {
		this.thumbImageFileName = thumbImageFileName;
	}

	public int getThumbSizeWidth() {
		return thumbSizeWidth;
	}

	public void setThumbSizeWidth(int thumbSizeWidth) {
		this.thumbSizeWidth = thumbSizeWidth;
	}

	public int getThumbSizeHeight() {
		return thumbSizeHeight;
	}

	public void setThumbSizeHeight(int thumbSizeHeight) {
		this.thumbSizeHeight = thumbSizeHeight;
	}
	
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

}
