package com.mycompany.ldit.receivemsg.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;

@Repository("receiveMsgDao")
public class ReceiveMsgDao {
	@Autowired
	private SqlSession sqlSession;
	
	// 받은 쪽지함에 쪽지 등록
	public int receiveBox(ReceiveMsg receivemsg) {
		return sqlSession.insert("ReceiveMsg.receiveBox", receivemsg);
	}
	
	// 받은 쪽지 삭제
	public int deleteMsg(int rMNo) {
		return sqlSession.delete("ReceiveMsg.deleteMsg", rMNo);
	}
}
