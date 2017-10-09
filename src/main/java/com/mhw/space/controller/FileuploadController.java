package com.mhw.space.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("fileupload")
public class FileuploadController {

	@RequestMapping("doUpload")
	@ResponseBody
	public String doUpload() {
		System.out.println("aaaaaaa");
		return null;
	}
	
}
