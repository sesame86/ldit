package com.mycompany.ldit.main.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.project.model.vo.Project;

@Repository("MainDao")
public class MainDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Attendance getAttendance(int stfNo) {
		Attendance result = sqlSession.selectOne("Main.getAttendance", stfNo);
		System.out.println(result);
		return result;
	}
	public List<Project> getUserProject(int stfNo) {
		return sqlSession.selectList("Main.getUserProject", stfNo);
	}
}
