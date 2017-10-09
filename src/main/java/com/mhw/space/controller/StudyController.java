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
import com.mhw.space.util.system.page.Page;

@Controller
@RequestMapping("study")
public class StudyController {

	@Resource
	private IStudyService studyService;
	
	@RequestMapping("insertBlog")
	@ResponseBody
	public CommonResp insertBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String myContent = request.getParameter("myContent");
		System.out.println(title);
		System.out.println(myContent);
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
