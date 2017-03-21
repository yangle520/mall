package com.yangle.web.entity.result;

import com.yangle.exception.ServiceExceptionEnum;

/**
 * 返回体
 * 
 * Created by bysocket on 14/03/2017.
 */
public class ResultBody {
	/**
	 * 响应代码
	 */
	private String code;

	/**
	 * 响应消息
	 */
	private String message;

	/**
	 * 响应结果
	 */
	private Object result;

	/**
	 * 异常信息赋值
	 * 
	 * @param code
	 * @param message
	 */
	public ResultBody(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 返回结果赋值，有返回结果是代表成功
	 * 
	 * @param result
	 */
	public ResultBody(Object result) {
		this.code = ServiceExceptionEnum.SUCCESS.getCode();
		this.message = ServiceExceptionEnum.SUCCESS.getMessage();
		this.result = result;
	}

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

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
