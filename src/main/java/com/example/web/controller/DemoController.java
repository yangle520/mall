package com.example.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dubbo.dao.TestDao;

@Controller
public class DemoController {

	private Logger logger = Logger.getLogger(DemoController.class);

	// @Resource
	// private DemoWebService demoWebService;

	@Autowired
	private TestDao testDao;

	@ResponseBody
	@RequestMapping("/")
	public String hh() {
		logger.info("hhhhhh");
		Integer result = testDao.findCount();
		logger.info(result);
		// List<String> tables = testDao.findTableName();
		// logger.info("数量：" + tables.size());
		// logger.info("表名：" + tables);
		return "hhhhhhhhhhh:" + result;
	}
}
