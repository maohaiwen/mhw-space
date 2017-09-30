package com.mhw.space.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mhw.space.model.leavemessage.LeaveMessageEntity;
import com.mhw.space.service.leavemessage.ILeaveMessageService;
import com.mhw.space.util.common.CommonResp;
import com.mhw.space.util.system.validate.Validate;

@Controller
@RequestMapping(value="leaveMessage")
public class LeaveMessageController {
	
	@Resource
	private ILeaveMessageService leaveMessageService;

	@RequestMapping(value="addLeaveMessage")
	@Validate(columns= {"name, notnull, 姓名不能为空！", "content, notnull, 内容不能为空！"})
	public CommonResp addLeaveMessage(LeaveMessageEntity leaveMessageEntity) {
		boolean success = leaveMessageService.addLeaveMessage(leaveMessageEntity);
		return success ? new CommonResp(200) : new CommonResp(500);
	}
}
