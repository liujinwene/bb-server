package com.example.base;

public class RestResp {
	private String version;
	private String scope;
	private Integer status;
	private String errorMsg;
	private Object response;
	
	public RestResp() {
		version = ErrorCodes.VERSION_1;
		scope = ErrorCodes.SCOPE_GENERAL;
		status = ErrorCodes.SUCCESS;
	}
	
	public RestResp(String errorMsg) {
		version = ErrorCodes.VERSION_1;
		scope = ErrorCodes.SCOPE_GENERAL;
		status = ErrorCodes.ERROR_GENERAL_EXCEPTION;
		this.errorMsg = errorMsg;
	}
	
	public RestResp(Object response) {
		version = ErrorCodes.VERSION_1;
		scope = ErrorCodes.SCOPE_GENERAL;
		status = ErrorCodes.SUCCESS;
		this.response = response;
	}
	
	public RestResp(String scope, Integer status, String errorMsg) {
		version = ErrorCodes.VERSION_1;
		this.scope = scope;
		this.status = status;
		this.errorMsg = errorMsg;
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}

}
