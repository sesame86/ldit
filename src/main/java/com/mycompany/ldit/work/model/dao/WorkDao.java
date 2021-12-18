package com.mycompany.ldit.work.model.dao;

import java.util.List;

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
	public List<Work> getWorkList(int workId) throws Exception {
		return sqlSession.selectList("Work.getWorkList", workId);
	}
	public List<Work> getWorkListToday(int workId) throws Exception {
		return sqlSession.selectList("Work.getWorkListToday", workId);
	}
	public Work getWorkDetial(int workId) throws Exception {
		return sqlSession.selectOne("Work.getWorkDetial", workId);
	}
	public int deleteWork(int workId) throws Exception {
		return sqlSession.delete("Work.deleteWork", workId);
	}
	public int updateWork(Work wvo) throws Exception {
		return sqlSession.update("Work.updateWork", wvo);
	}
}