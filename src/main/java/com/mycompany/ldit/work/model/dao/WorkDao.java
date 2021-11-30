package com.mycompany.ldit.work.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.work.model.vo.Work;

@Repository("WorkDao")
public class WorkDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertWork(Work wvo) throws Exception {
		return sqlSession.insert("Work.insertWork", wvo);
	}
}