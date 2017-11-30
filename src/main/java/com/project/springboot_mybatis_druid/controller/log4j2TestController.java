package com.project.springboot_mybatis_druid.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class log4j2TestController {
	
	private static final Logger logger = LogManager.getLogger(log4j2TestController.class);
	
	@RequestMapping("/logtest")
	@ResponseBody
	public String outLog(){
		System.out.println("----------------logtest-----------------");
		logger.debug("debug message test");
		logger.info("info message test");
		logger.error("error message", new NullPointerException("null error"));
		return "out log";
	}
}
