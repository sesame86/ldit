package com.mycompany.ldit.msg.model;

import java.util.List;

import com.mycompany.ldit.msg.model.vo.Msg;

public interface MsgServiceInterface {
	// 쪽지 보내기
	public int sendMsg(Msg msg);
	
	// 쪽지 번호 가져오기
	public int checkMNo(Msg msg);
	
	// 보낸 쪽지함 확인
	public List<Msg> sendMsgCheck(Msg msg);
	
	// 받은 쪽지함 확인
	public List<Msg> receiveMsgCheck(Msg msg);
	
	// 쪽지 상세 내용 확인
	public List<Msg> checkMsg(int mNo);
}
