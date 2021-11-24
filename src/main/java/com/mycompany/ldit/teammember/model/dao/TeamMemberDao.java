package com.mycompany.ldit.teammember.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.ldit.team.model.vo.Team;

@Repository("teamMemberDao")
public class TeamMemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional(rollbackFor = Exception.class)
	public int insertTeamMember(Team tvo) {
		return sqlSession.insert("Team.insertTeamMember", tvo);
	}
}