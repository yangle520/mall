package com.example.exception;

/**
 * 统一错误码异常
 * 
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -2908200514701906384L;

	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceException(String code, String message) {
		this.message = message;
		this.code = code;
	}

}
