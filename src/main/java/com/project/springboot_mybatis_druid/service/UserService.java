package com.project.springboot_mybatis_druid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot_mybatis_druid.dao.UserDao;
import com.project.springboot_mybatis_druid.model.UserInfo;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	public int insertUser(UserInfo userInfo){
		return userDao.instertUser(userInfo);
	}
	public UserInfo searchByName(String name){
		return userDao.searchUserByName(name);
	}
	public UserInfo[] searchByAge(int age){
		return userDao.searchUsersByAge(age);
	}
}
