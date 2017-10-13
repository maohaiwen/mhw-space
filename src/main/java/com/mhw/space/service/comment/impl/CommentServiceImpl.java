package com.mhw.space.service.comment.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhw.space.dao.blog.BlogDao;
import com.mhw.space.dao.comment.CommentDao;
import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.model.comment.CommentEntity;
import com.mhw.space.service.comment.ICommentService;
import com.mhw.space.util.system.exception.BusinessException;
@Service
public class CommentServiceImpl implements ICommentService{
	
	@Resource
	private CommentDao commentDao;
	
	@Resource
	private BlogDao blogDao;

	@Override
	public List<CommentEntity> selectCommentList(CommentEntity commentEntity) {
		return commentDao.selectCommentList(commentEntity);
	}

	@Override
	public Integer doComment(CommentEntity commentEntity) {
		
		commentDao.insertComment(commentEntity);
		
		Map<String, Object> paramMap = new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("id", commentEntity.getBlogId());
				put("field", "comment_count");
			}
		};
		blogDao.doIncreaseBlogCount(paramMap);
		
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setId(commentEntity.getBlogId());
		blogEntity = blogDao.selectBlogEntity(blogEntity);
		
		if(blogEntity == null) {
			throw new BusinessException("找不到该博客！");
		}
		
		return blogEntity.getCommentCount();
	}

}
