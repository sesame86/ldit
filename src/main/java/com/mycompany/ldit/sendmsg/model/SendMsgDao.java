package com.mycompany.ldit.sendmsg.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.sendmsg.model.vo.SendMsg;

@Repository("sendMsgDao")
public class SendMsgDao {
	@Autowired
	private SqlSession sqlSession;
	
	// 보낸 쪽지함에 쪽지 등록
	public int sendBox(SendMsg sendmsg) {
		return sqlSession.insert("SendMsg.sendBox", sendmsg);
	}
	
	// 보낸 쪽지 삭제
	public int deleteMsg(int sMNo) {
		return sqlSession.delete("SendMsg.deleteMsg", sMNo);
	}
}