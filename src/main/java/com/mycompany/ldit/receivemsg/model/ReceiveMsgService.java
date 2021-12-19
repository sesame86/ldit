package com.mycompany.ldit.receivemsg.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;

@Service("receiveMsgService")
public class ReceiveMsgService implements ReceiveMsgServiceInterface{
	@Autowired
	private ReceiveMsgDao receivemsgdao;
	
	// 받은 쪽지함에 쪽지 등록
	@Override
	public int receiveBox(ReceiveMsg receivemsg) {
		int result=0;
		try {
			result=receivemsgdao.receiveBox(receivemsg);
			System.out.println("받은 쪽지함에 쪽지 등록 성공 여부:" + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 받은 쪽지 삭제
	@Override
	public int deleteMsg(int rMNo) {
		int result=0;
		try {
			result=receivemsgdao.deleteMsg(rMNo);
			System.out.println("받은 쪽지 삭제 성공 여부: " + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
