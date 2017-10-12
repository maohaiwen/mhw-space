package com.mhw.space.util.system.exception;

import com.mhw.space.util.common.ExceptionConstants;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private int errorCode = ExceptionConstants.BUSINESS_EXCEPTION;
	
	private String errorMsg;
	
	public BusinessException(BusinessException e) {
		this.errorCode = e.errorCode;
		this.errorMsg = e.errorMsg;
	}
	public BusinessException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
