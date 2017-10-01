package com.mhw.space.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhw.space.model.user.UserEntity;
import com.mhw.space.util.common.CommonResp;
import com.mhw.space.util.common.ExceptionConstants;

@RequestMapping(value="user")
@Controller
public class UserController {
	
	private static final String MANAGER_NAME = "毛海文";

	@RequestMapping(value="doLogin")
	@ResponseBody
	public CommonResp doLogin(String userName, String passWord, HttpSession session) {
		if(userName.equals("maohaiwen") && passWord.equals("mhw12345")) {
			session.setAttribute("user", new UserEntity(userName, MANAGER_NAME, passWord));
			return new CommonResp("登录成功");
		}else {
			return new CommonResp(ExceptionConstants.User.LOGIN_FAIL, "登录失败，请检查用户名或密码。");
		}
	}
	
	@RequestMapping(value="getUserFromSession")
	@ResponseBody
	public CommonResp getUserFromSession(HttpSession httpSession) {
		UserEntity user = (UserEntity) httpSession.getAttribute("user");
		if(user == null) {
			return new CommonResp(ExceptionConstants.User.UN_LOGIN, "未登录");
		}else {
			return new CommonResp(user);
		}
	}
}