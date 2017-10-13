package com.mhw.space.dao.comment;

import java.util.List;

import com.mhw.space.model.comment.CommentEntity;

public interface CommentDao {
	
	List<CommentEntity> selectCommentList(CommentEntity commentEntity);
	
	void insertComment(CommentEntity commentEntity);
}
