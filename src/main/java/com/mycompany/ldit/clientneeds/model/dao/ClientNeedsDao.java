package com.mycompany.ldit.clientneeds.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.clientneeds.model.vo.ClientNeeds;

@Repository("clientNeedsDao")
public class ClientNeedsDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ClientNeeds> getUrgentList(int pro_no) {
		return sqlSession.selectList("ClientNeeds.getUrgentList", pro_no);
	}
	public List<ClientNeeds> getHighList(int pro_no) {
		return sqlSession.selectList("ClientNeeds.getHighList", pro_no);
	}
	public List<ClientNeeds> getNormalList(int pro_no) {
		return sqlSession.selectList("ClientNeeds.getNormalList", pro_no);
	}
	public List<ClientNeeds> getLowList(int pro_no) {
		return sqlSession.selectList("ClientNeeds.getLowList", pro_no);
	}
}