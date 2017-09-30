package com.mhw.space.model.leavemessage;

import java.util.Date;

public class LeaveMessageEntity {

	private Integer id;
	
	private String name;
	
	private String content;
	
	private Date addTime;
	
	public LeaveMessageEntity(){
		
	}
	
	public LeaveMessageEntity(String name, String content) {
		this.name = name;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
