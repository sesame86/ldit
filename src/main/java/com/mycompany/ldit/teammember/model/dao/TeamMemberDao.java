package com.mycompany.ldit.teammember.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.teammember.model.vo.TeamMember;

@Repository("TeamMemberDao")
public class TeamMemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional(rollbackFor = Exception.class)
	public int insertTeamMember(TeamMember tvo) {
		return sqlSession.insert("TeamMember.insertTeamMember", tvo);
	}
	public List<Staff> getTeamMemberUpdate(int teamId) {
		return sqlSession.selectList("TeamMember.getTeamMemberUpdate", teamId);
	}
	public int checkDupidTeamMember(TeamMember tmVo) {
		return sqlSession.selectOne("TeamMember.checkDupidTeamMember", tmVo);
	}
}