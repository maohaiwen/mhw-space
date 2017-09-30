package com.mhw.space.service.leavemessage.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhw.space.dao.leavemessage.LeaveMessageDao;
import com.mhw.space.model.leavemessage.LeaveMessageEntity;
import com.mhw.space.service.leavemessage.ILeaveMessageService;
@Service
public class LeaveMessageServiceImpl implements ILeaveMessageService{

	@Resource
	private LeaveMessageDao LeaveMessageDao;
	
	@Override
	public boolean addLeaveMessage(LeaveMessageEntity leaveMessage) {
		return LeaveMessageDao.addLeaveMessage(leaveMessage) == 1 ? true : false;
	}

}
