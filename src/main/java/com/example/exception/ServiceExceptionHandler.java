package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.web.entity.result.ResultBody;

/**
 * 统一错误码异常处理
 * 
 * Created by bysocket on 14/03/2017.
 */
@RestControllerAdvice
public class ServiceExceptionHandler {

	@ExceptionHandler(value = ServiceException.class)
	public ResultBody errorHandlerOverJson(HttpServletRequest request,
			ServiceException exception) {
		ResultBody result = new ResultBody(exception.getCode(),
				exception.getMessage());
		return result;
	}

}
