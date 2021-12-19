package com.mycompany.ldit.receivemsg.model;

import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;

public interface ReceiveMsgServiceInterface {
	//받은 쪽지 함에 쪽지 등록
	public int receiveBox(ReceiveMsg receivemsg);
	
	// 받은 쪽지 삭제
	public int deleteMsg(int sMNo);
}
