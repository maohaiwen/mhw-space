package com.mhw.space.model.user;

public class UserEntity {

	private String userName;
	
	private String realName;
	
	private String passWord;
	
	public UserEntity() {
		
	}
	
	public UserEntity(String userName, String realName, String passWord) {
		this.userName = userName;
		this.realName = realName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
