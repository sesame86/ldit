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
	public TeamAim goalStatusCheck(int teamId) {
		return sqlSession.selectOne("TeamAim.goalStatusCheck", teamId);
	}
	public int insertTeamGoal(TeamAim tAimVo) {
		return sqlSession.insert("TeamAim.insertTeamGoal", tAimVo);
	}
	public TeamAim getUpdateGoal(int teamId) {
		return sqlSession.selectOne("TeamAim.getUpdateGoal", teamId);
	}
	public int updateTeamGoal(TeamAim tAimVo) {
		return sqlSession.update("TeamAim.updateTeamGoal", tAimVo);
	}
	public int disableTeamGoal(int teamId) {
		return sqlSession.update("TeamAim.disableTeamGoal", teamId);
	}
}