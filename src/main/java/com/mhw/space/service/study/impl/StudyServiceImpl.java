package com.mhw.space.service.study.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhw.space.dao.blog.BlogDao;
import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.service.study.IStudyService;
import com.mhw.space.util.system.page.Page;
@Service
public class StudyServiceImpl implements IStudyService{
	
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

}
