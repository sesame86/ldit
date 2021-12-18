package com.mycompany.ldit.sendmsg.model;

import com.mycompany.ldit.sendmsg.model.vo.SendMsg;

public interface SendMsgServiceInterface {
	// 보낸 쪽지함에 쪽지 등록
	public int sendBox(SendMsg sendMsg);
}
