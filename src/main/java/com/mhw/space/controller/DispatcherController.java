package com.mhw.space.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mhw.space.util.common.DispatcherConstants;

@Controller
@RequestMapping(value="dispatcher")
public class DispatcherController {

	@RequestMapping(value="homePage")
	public String homePage(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin","*");
		return DispatcherConstants.HOME_PAGE;
	}
}
