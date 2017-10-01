package com.mhw.space.dao.blog;

import java.util.List;

import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.util.system.page.Page;

public interface BlogDao {

	void insertBlog(BlogEntity blogEntity);
	
	List<BlogEntity> selectBlogPage(Page<BlogEntity> page);
	
	BlogEntity selectBlogEntity(BlogEntity blogEntity);
}
