package com.yangle.dubbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangle.dubbo.dao.DemoDao;

@Service
public class DemoService {

	@Autowired
	private DemoDao demoDao;

	public Integer getCountResult(Integer i) {
		return demoDao.findCount();
	}
}
