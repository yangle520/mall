package com.yangle.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangle.dubbo.api.DemoApi;

@Service
public class DemoWebService {

	@Autowired
	private DemoApi demoApi;

	public Integer getCount(Integer i) {
		return demoApi.getCount(i);
	}
}
