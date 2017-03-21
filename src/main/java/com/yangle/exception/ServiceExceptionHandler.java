package com.yangle.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yangle.web.entity.result.ResultBody;

/**
 * 统一错误码异常处理
 * 
 * Created by bysocket on 14/03/2017.
 */
@RestControllerAdvice
public class ServiceExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

	@ExceptionHandler(value = ServiceException.class)
	public ResultBody errorHandlerOverJson(HttpServletRequest request, ServiceException exception) {
		ResultBody result = new ResultBody(exception.getCode(), exception.getMessage());
		logger.error(exception.getMessage());
		return result;
	}

}
