package com.mhw.space.service.blog;

import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.util.system.page.Page;

public interface IBlogService {

	void insertBlog(BlogEntity blogEntity);

	Page<BlogEntity> selectBlogPage(Page<BlogEntity> page);

	BlogEntity selectBlogEntity(BlogEntity blogEntity);

	Integer doPraiseBlog(Integer id);

}
