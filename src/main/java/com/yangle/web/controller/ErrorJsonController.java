package com.yangle.web.controller;

import java.util.Date;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yangle.dubbo.vo.CityVo;
import com.yangle.exception.ServiceException;

/**
 * 错误码案例
 */
@RestController
public class ErrorJsonController {

	/**
	 * 获取城市接口
	 * 
	 * @param cityName
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/api/city", method = RequestMethod.GET)
	public CityVo findOneCity(String cityName) throws ServiceException {
		// 入参为空
		if (StringUtils.isEmpty(cityName)) {
			throw new ServiceException("112312312312", "zzzzzzzzzz");
		}
		return new CityVo(1L, 2L, "温岭", null, new Date());
	}
}