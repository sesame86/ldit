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
	
	public List<ClientNeeds> getUrgentList(int proNo) {
		return sqlSession.selectList("ClientNeeds.getUrgentList", proNo);
	}
	public List<ClientNeeds> getHighList(int proNo) {
		return sqlSession.selectList("ClientNeeds.getHighList", proNo);
	}
	public List<ClientNeeds> getNormalList(int proNo) {
		return sqlSession.selectList("ClientNeeds.getNormalList", proNo);
	}
	public List<ClientNeeds> getLowList(int proNo) {
		return sqlSession.selectList("ClientNeeds.getLowList", proNo);
	}
	public int insertCS(ClientNeeds cvo) throws Exception {
		return sqlSession.insert("ClientNeeds.insertCS", cvo);
	}
	public ClientNeeds getCSDetail(int cnId) throws Exception {
		return sqlSession.selectOne("ClientNeeds.getCSDetail", cnId);
	}
	public int disableCS(int cnId) throws Exception {
		return sqlSession.update("ClientNeeds.disableCS", cnId);
	}
	public int updateCS(ClientNeeds cvo) throws Exception {
		return sqlSession.update("ClientNeeds.updateCS", cvo);
	}
}