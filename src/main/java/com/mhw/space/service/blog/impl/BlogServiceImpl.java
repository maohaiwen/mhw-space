package com.mhw.space.service.blog.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhw.space.dao.blog.BlogDao;
import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.service.blog.IBlogService;
import com.mhw.space.util.system.exception.BusinessException;
import com.mhw.space.util.system.page.Page;
@Service
public class BlogServiceImpl implements IBlogService{
	
	@Resource
	private BlogDao blogDao;

	@Override
	public void insertBlog(BlogEntity blogEntity) {
		blogDao.insertBlog(blogEntity);
	}

	@Override
	public Page<BlogEntity> selectBlogPage(Page<BlogEntity> page) {
		return page.setList(blogDao.selectBlogPage(page));
	}

	@Override
	public BlogEntity selectBlogEntity(BlogEntity blogEntity) {
		return blogDao.selectBlogEntity(blogEntity);
	}

	@Override
	public Integer doPraiseBlog(Integer id) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("id", id);
				put("field", "praise_count");
			}
		};
		
		blogDao.doIncreaseBlogCount(paramMap);
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setId(id);
		blogEntity = selectBlogEntity(blogEntity);
		
		if(blogEntity == null) {
			throw new BusinessException("查询不到该帖子！");
		}
		
		return blogEntity.getPraiseCount();
	}

}
