package com.mhw.space.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhw.space.model.blog.BlogEntity;
import com.mhw.space.model.comment.CommentEntity;
import com.mhw.space.service.blog.IBlogService;
import com.mhw.space.service.comment.ICommentService;
import com.mhw.space.util.common.CommonResp;
import com.mhw.space.util.common.DispatcherConstants;
import com.mhw.space.util.system.exception.BusinessException;
import com.mhw.space.util.system.page.Page;
import com.mhw.space.util.system.validate.Validate;

@Controller
@RequestMapping("study")
public class StudyController {

	@Resource
	private IBlogService blogService;
	
	@Resource
	private ICommentService commentService;
	
	@RequestMapping("insertBlog")
	@ResponseBody
	@Validate(columns={"title,notnull,标题不能为空！", "content,notnull,内容不能为空！"})
	public CommonResp insertBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setTitle(title);
		blogEntity.setContent(content);
		blogService.insertBlog(blogEntity);
		
		return new CommonResp();
	}

	@RequestMapping("selectBlogPage")
	@ResponseBody
	public CommonResp selectBlogPage(Page<BlogEntity> page) {
		return new CommonResp(blogService.selectBlogPage(page));
	}

	@RequestMapping("selectBlogEntity")
	@ResponseBody
	public CommonResp selectBlogEntity(BlogEntity blogEntity) {
		return new CommonResp(blogService.selectBlogEntity(blogEntity));
	}
	
	@RequestMapping("toBlogDetail")
	@Validate(columns={"id,notnull,id不能为空！"})
	public String toBlogDetail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setId(Integer.parseInt(id));
		blogEntity = blogService.selectBlogEntity(blogEntity);
		
		if(blogEntity == null) {
			throw new BusinessException("查询不到该博客");
		}
		request.setAttribute("blog", blogEntity);
		
		return DispatcherConstants.BLOG_DETAIL;
	}
	
	@RequestMapping("doPraiseBlog")
	@ResponseBody
	public CommonResp doPraiseBlog(Integer id) {
		Integer praiseCount = blogService.doPraiseBlog(id);
		return new CommonResp(200, "成功", praiseCount);
	}
	
	@RequestMapping("doComment")
	@ResponseBody
	public CommonResp doComment(@RequestParam Integer blogId, @RequestParam String comment) {
		
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setBlogId(blogId);
		commentEntity.setCommentDetail(comment);
		commentEntity.setUserName("路人甲");
		Integer commentCount = commentService.doComment(commentEntity);
		
		return new CommonResp(200, "成功", commentCount);
	}
	
	@RequestMapping("selectCommentList")
	@ResponseBody
	public CommonResp selectCommentList(@RequestParam Integer blogId){
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setBlogId(blogId);
		List<CommentEntity> commentList = commentService.selectCommentList(commentEntity);
		
		return new CommonResp(commentList);
	}
	
}
