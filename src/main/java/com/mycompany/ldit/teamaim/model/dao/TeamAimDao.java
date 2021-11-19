package com.mycompany.ldit.teamaim.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.teamaim.model.vo.TeamAim;

@Repository("teamAimDao")
public class TeamAimDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<TeamAim> getTeamGoal(int teamId) {
		return sqlSession.selectList("TeamAim.getTeamGoal", teamId);
	}
	public String goalStatusCheck(int teamId) {
		return sqlSession.selectOne("TeamAim.goalStatusCheck", teamId);
	}
}