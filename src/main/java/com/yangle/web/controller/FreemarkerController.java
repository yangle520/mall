package com.yangle.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {

	@RequestMapping("/hello")
	public String index(ModelMap map) {
		map.put("name", "yangle");
		return "hello";
	}
}
