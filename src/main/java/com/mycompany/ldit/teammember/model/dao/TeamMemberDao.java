package com.mycompany.ldit.teammember.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.ldit.teammember.model.vo.TeamMember;

@Repository("TeamMemberDao")
public class TeamMemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional(rollbackFor = Exception.class)
	public int insertTeamMember(TeamMember tvo) {
		return sqlSession.insert("TeamMember.insertTeamMember", tvo);
	}
}