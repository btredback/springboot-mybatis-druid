package com.project.springboot_mybatis_druid.model;

public class UserInfo {
	private int userId;
	private String userName;
	private int userAge;
	
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName +",userAge" + userAge + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

}
