package com.example.base.exception;

import com.example.base.constant.ErrorCodes;

public class RestRunningException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1630953127111065759L;
	
	private String scope;
	private Integer status;
	private String errorMsg;
	
	public RestRunningException(String scope, Integer status, String errorMsg) {
		super(errorMsg);
		this.scope = scope;
		this.status = status;
		this.errorMsg = errorMsg;
	}
	
	public static RestRunningException error(String errorMsg) {
		return new RestRunningException(ErrorCodes.SCOPE_GENERAL, ErrorCodes.ERROR_GENERAL_EXCEPTION, errorMsg);
	}
	
	public static RestRunningException error(String scope, Integer status, String errorMsg) {
		return new RestRunningException(scope, status, errorMsg);
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
}
