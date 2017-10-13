package com.mhw.space.service.comment;

import java.util.List;

import com.mhw.space.model.comment.CommentEntity;

public interface ICommentService {

	List<CommentEntity> selectCommentList(CommentEntity commentEntity);

	Integer doComment(CommentEntity commentEntity);
}
