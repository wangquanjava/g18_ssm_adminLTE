package com.git.domain;

import java.util.Map;

public class AjaxJson {
	private Boolean success;
	private String msg;
	private Map<String, Object> data;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public AjaxJson(Boolean success, String msg, Map<String, Object> data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}
	
	
}
