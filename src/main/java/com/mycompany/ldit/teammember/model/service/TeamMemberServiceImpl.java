package com.mycompany.ldit.teammember.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.team.model.vo.Team;
import com.mycompany.ldit.teammember.model.dao.TeamMemberDao;

@Service("TeamMemberService")
public class TeamMemberServiceImpl implements TeamMemberService{
	@Autowired
	private TeamMemberDao TeamMemberDao;
	@Override
	public int insertTeamMember(Team tvo) throws Exception {
		return TeamMemberDao.insertTeamMember(tvo);
	}
}
