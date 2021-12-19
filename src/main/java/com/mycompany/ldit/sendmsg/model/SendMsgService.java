package com.mycompany.ldit.sendmsg.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.sendmsg.model.vo.SendMsg;

@Service("sendmsgService")
public class SendMsgService implements SendMsgServiceInterface{
	@Autowired
	private SendMsgDao sendmsgDao;
	
	// 보낸 쪽지함에 쪽지 등록
	@Override
	public int sendBox(SendMsg sendmsg) {
		int result=0;
		try {
			result=sendmsgDao.sendBox(sendmsg);
			System.out.println("보낸 쪽지함에 쪽지 등록 성공 여부 :" + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 보낸 쪽지 삭제
	@Override
	public int deleteMsg(int sMNo) {
		int result=0;
		try {
			result=sendmsgDao.deleteMsg(sMNo);
			System.out.println("보낸 쪽지 삭제 성공 여부:" + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
