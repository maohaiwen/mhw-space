package com.mhw.space.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mhw.space.util.common.DispatcherConstants;

@Controller
@RequestMapping("dispatcher")
public class DispatcherController {
	
	@RequestMapping(value="toHomePage")
	public String toHomePage() {
		return DispatcherConstants.HOME_PAGE;
	}
	
	@RequestMapping(value="toWriteBlog")
	public String toWriteBlog() {
		return DispatcherConstants.WRITE_BLOG;
	}
	
	@RequestMapping("toStudy")
	public String toStudy() {
		return DispatcherConstants.STUDY;
	}
}
