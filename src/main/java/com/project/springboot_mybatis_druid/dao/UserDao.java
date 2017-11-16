package com.project.springboot_mybatis_druid.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.springboot_mybatis_druid.model.UserInfo;

@Mapper
public interface UserDao {
	int instertUser(@Param("user")UserInfo user);//插入数据
	UserInfo searchUserByName(String name);
	UserInfo[] searchUsersByAge(int age);
}
