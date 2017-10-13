package com.mhw.space.model.comment;

import java.util.Date;

import com.mhw.space.util.common.DateUtil;

public class CommentEntity {

	private Integer id;
	
	private Integer blogId;
	
	private String userName;
	
	private String commentDetail;
	
	private Integer parentCommentId;
	
	private Date addTime;
	
	private Date updateTime;
	
	private String addTimeAgo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommentDetail() {
		return commentDetail;
	}

	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}

	public Integer getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
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

	public String getAddTimeAgo() {
		addTimeAgo = DateUtil.formatToAgo(addTime);
		return addTimeAgo;
	}

	public void setAddTimeAgo(String addTimeAgo) {
		this.addTimeAgo = addTimeAgo;
	}
	
}
