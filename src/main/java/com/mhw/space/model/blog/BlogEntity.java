package com.mhw.space.model.blog;

import java.util.Date;

import com.mhw.space.util.common.DateUtil;

public class BlogEntity {

	private Integer id;
	
	private String title;
	
	private String content;
	
	private Integer seeAble;
	
	private Integer praiseCount;
	
	private Integer commentCount;
	
	private Integer isStick;
	
	private Date addTime;
	
	private Date updateTime;
	
	private String addTimeStr;
	
	private String addTimeAgo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSeeAble() {
		return seeAble;
	}

	public void setSeeAble(Integer seeAble) {
		this.seeAble = seeAble;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getIsStick() {
		return isStick;
	}

	public void setIsStick(Integer isStick) {
		this.isStick = isStick;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAddTimeStr() {
		addTimeStr = DateUtil.formatDate(addTime, DateUtil.FORMAT_DATE_TIME);
		return addTimeStr;
	}

	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}

	public String getAddTimeAgo() {
		addTimeAgo = DateUtil.formatToAgo(addTime);
		return addTimeAgo;
	}

	public void setAddTimeAgo(String addTimeAgo) {
		this.addTimeAgo = addTimeAgo;
	}
	
}
