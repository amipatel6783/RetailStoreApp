package com.retailstore.model;

import java.util.Date;


import com.retailstore.enumeration.UserTypes;

public class User {
	
	private int userId;
	private String userName;
	private Date createdOn;
	private UserTypes userType;
	
	
	public User(int userId, String userName, UserTypes userType, Date createdOn) {
		super();
		this.userId = userId;
		//this.userId = (int) Math.random();
		this.userName = userName;
		this.userType = userType;
		this.createdOn = createdOn;
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


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public UserTypes getUserType() {
		return userType;
	}


	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", userName=" + userName + ", createdOn=" + createdOn + ", userType="
				+ userType + "]";
	}
	
	
	

}
