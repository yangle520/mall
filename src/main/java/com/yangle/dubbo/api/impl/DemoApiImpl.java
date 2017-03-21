package com.yangle.dubbo.api.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yangle.dubbo.api.DemoApi;
import com.yangle.dubbo.service.DemoService;

@Component
public class DemoApiImpl implements DemoApi {

	@Resource
	private DemoService demoService;

	@Override
	public Integer getCount(Integer i) {
		return null;
	}

}
