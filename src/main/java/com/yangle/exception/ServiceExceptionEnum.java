package com.yangle.exception;

/**
 * 应用系统级别的错误码
 * 
 * Created by bysocket on 14/03/2017.
 */
public enum ServiceExceptionEnum {
	SUCCESS("0", "success"), NOT_FOUND("-1", "service not found");

	private String code;

	private String message;

	ServiceExceptionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
