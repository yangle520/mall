package com.yangle.web.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangle.dubbo.api.DemoApi;

@Service
public class DemoWebService {

	@Resource(name = "demoApiImpl")
	private DemoApi demoApi;

	public Integer getCount(Integer i) {
		return demoApi.getCount(i);
	}
}
