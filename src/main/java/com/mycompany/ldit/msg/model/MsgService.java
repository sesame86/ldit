package com.mycompany.ldit.msg.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.msg.model.vo.Msg;

@Service("msgService")
public class MsgService implements MsgServiceInterface{
	@Autowired
	private MsgDao msgDao;
	
	// 쪽지 보내기
	@Override
	public int sendMsg(Msg msg) {
		int result=0;
		try {
			result = msgDao.sendMsg(msg);
			System.out.println("쪽지 보내기 성공 여부 :" + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 쪽지 번호 가져오기
	@Override
	public int checkMNo(Msg msg) {
		return msgDao.checkMNo(msg);
	}
	
	// 보낸 쪽지함 확인
	@Override
	public List<Msg> sendMsgCheck(Msg msg){
		return msgDao.sendMsgCheck(msg);
	}
}
