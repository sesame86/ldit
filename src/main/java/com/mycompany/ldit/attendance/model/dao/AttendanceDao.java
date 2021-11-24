package com.mycompany.ldit.attendance.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("attDao")
public class AttendanceDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertCheckin(int stfNo) {
		return sqlSession.insert("aboutAtt.insertCheckin", stfNo);
	}
	
	
	
}
