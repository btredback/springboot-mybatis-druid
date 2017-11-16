package com.project.springboot_mybatis_druid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.springboot_mybatis_druid.model.UserInfo;
import com.project.springboot_mybatis_druid.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(){
		return "hello";
	}
	@RequestMapping("/add")
	@ResponseBody
	public String insertUser(UserInfo userInfo){
		if(userInfo == null){
			return "error";
		}
		userService.insertUser(userInfo);
		return "success insert" + userInfo.toString();
	}
	
	@RequestMapping("/search/name/{name}")
	@ResponseBody
	public String searchByname(@PathVariable String name){
		if(name == null){
			return "error";
		}
		UserInfo user = userService.searchByName(name);
		return "success search" + user.toString();
	}
	@RequestMapping("/search/age/{age}")
	@ResponseBody
	public UserInfo[] searchByAge(@PathVariable int age){
		return userService.searchByAge(age);
	}
}
