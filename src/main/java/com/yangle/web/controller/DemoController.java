package com.yangle.web.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangle.web.entity.bean.ConfigBean;
import com.yangle.web.entity.bean.ConfigBean2;
import com.yangle.web.service.DemoWebService;

@Controller
public class DemoController {

	private Logger logger = Logger.getLogger(DemoController.class);

	@Resource
	private DemoWebService demoWebService;
	@Autowired
	private ConfigBean conf1;

	@Autowired
	private ConfigBean2 conf2;

	@ResponseBody
	@RequestMapping("/")
	public String hh() {
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
		Integer i = demoWebService.getCount(1);
		return "hhhhhhhhhhh:" + i + " " + conf1.getName();
	}
}
