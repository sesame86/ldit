package com.mycompany.ldit.main.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;
import com.mycompany.ldit.sendmsg.model.vo.SendMsg;

@Repository("MainDao")
public class MainDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Attendance getAttendance(int stfNo) {
		return sqlSession.selectOne("Main.getAttendance", stfNo);
	}
	public List<Project> getUserProject(int stfNo) {
		return sqlSession.selectList("Main.getUserProject", stfNo);
	}
	public List<ReceiveMsg> getReceiveMsg(int stfNo) {
		return sqlSession.selectList("Main.getReceiveMsg", stfNo);
	}
}
