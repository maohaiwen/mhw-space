package com.mhw.space.service.study;

import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.util.system.page.Page;

public interface IStudyService {

	void insertBlog(BlogEntity blogEntity);

	Page<BlogEntity> selectBlogPage(Page<BlogEntity> page);

	BlogEntity selectBlogEntity(BlogEntity blogEntity);

}
