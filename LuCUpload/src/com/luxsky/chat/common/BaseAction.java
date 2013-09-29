
package com.luxsky.chat.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	
	/** JSON Result 객체 */
	protected JSONObject		jsonResult;

	protected String			message	= "";
	
	protected static Logger accessLogger =  Logger.getLogger("ACCESS");
	protected static Logger errorLogger =  Logger.getLogger("ERROR");
	
	protected String serverHost = Property.getInstance().getPropertyValue("server.host");
	
	protected String webChatPath = Property.getInstance().getPropertyValue("server.chat.image.path");
	protected String uploadChatDir = Property.getInstance().getPropertyValue("luxsky.chat.image.path");

	/**
	 * JSON 결과 데이타 getter
	 * @return JSONObject 객체
	 */
	public JSONObject getJsonResult() {
		return this.jsonResult;
	}

	/**
	 * JSON 결과 데이타 setter
	 * @param jsonResult JSONObject 객체
	 */
	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	protected String getParameter(String parameterName) {
		return ServletActionContext.getRequest().getParameter(parameterName);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSession(String connector) {
		String sessionName = (String)getSession().getAttribute("connector");
		
		if(sessionName != null && sessionName.equals(connector)) {
			return true;
		}
		return false;
	}

}
