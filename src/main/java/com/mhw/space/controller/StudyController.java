package com.mhw.space.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.service.study.IStudyService;
import com.mhw.space.util.common.CommonResp;
import com.mhw.space.util.common.DispatcherConstants;
import com.mhw.space.util.system.page.Page;
import com.mhw.space.util.system.validate.Validate;

@Controller
@RequestMapping("study")
public class StudyController {

	@Resource
	private IStudyService studyService;
	
	@RequestMapping("insertBlog")
	@ResponseBody
	@Validate(columns={"title,notnull,标题不能为空！", "content,notnull,内容不能为空！"})
	public CommonResp insertBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setTitle(title);
		blogEntity.setContent(content);
		studyService.insertBlog(blogEntity);
		
		return new CommonResp();
	}

	@RequestMapping("selectBlogPage")
	@ResponseBody
	public CommonResp selectBlogPage(Page<BlogEntity> page) {
		return new CommonResp(studyService.selectBlogPage(page));
	}

	@RequestMapping("selectBlogEntity")
	@ResponseBody
	public CommonResp selectBlogEntity(BlogEntity blogEntity) {
		return new CommonResp(studyService.selectBlogEntity(blogEntity));
	}
}
