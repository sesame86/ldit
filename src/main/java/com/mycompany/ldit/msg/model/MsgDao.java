package com.mycompany.ldit.msg.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.msg.model.vo.Msg;

@Repository("msgDao")
public class MsgDao {
	@Autowired
	private SqlSession sqlSession;
	
	// 쪽지 보내기
	public int sendMsg(Msg msg) {
		return sqlSession.insert("Msg.sendMsg", msg);
	}
	
	// 쪽지 번호 가져오기
	public int checkMNo(Msg msg) {
		return sqlSession.selectOne("Msg.checkMNo", msg);
	}
	
	// 보낸 쪽지함 확인
	public List<Msg> sendMsgCheck(Msg msg){
		return sqlSession.selectList("Msg.sendMsgCheck", msg);
	}
}
