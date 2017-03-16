package com.example.dubbo.api.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.example.dubbo.api.DemoApi;
import com.example.dubbo.service.DemoService;

@Component
public class DemoApiImpl implements DemoApi {

	@Resource
	private DemoService demoService;

	@Override
	public Integer getCount(Integer i) {
		// return demoService.getCountResult(i);
		return null;
	}
}
