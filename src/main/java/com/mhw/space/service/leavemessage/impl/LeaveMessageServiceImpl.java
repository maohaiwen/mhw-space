package com.mhw.space.service.leavemessage.impl;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.mhw.space.dao.leavemessage.LeaveMessageDao;
import com.mhw.space.model.leavemessage.LeaveMessageEntity;
import com.mhw.space.service.leavemessage.ILeaveMessageService;
import com.mhw.space.util.common.MailUtil;
@Service
public class LeaveMessageServiceImpl implements ILeaveMessageService{

	@Resource
	private LeaveMessageDao leaveMessageDao;
	
	@Override
	public void addLeaveMessage(LeaveMessageEntity leaveMessage) {
		leaveMessageDao.addLeaveMessage(leaveMessage);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					MailUtil.sendQQMail(leaveMessage.getName() + "给你留言啦", leaveMessage.getContent());
				} catch (MessagingException e) {
					
				}
				
			}
		}).start();
	}

}
