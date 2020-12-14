package com.auto.caseentity;

public class Case {
	private String id;
	private String method;
	private String type;
	private String url;
	private String param;
	private String form;
	private String json;
	private String response;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public void setCase(String id,String method,String type,String url,String param,String form,String json,String response) {
		this.id = id;
		this.method = method;
		this.type = type;
		this.url = url;
		this.param = param;
		this.form = form;
		this.json = json;
		this.response = response;
	}
	

}
