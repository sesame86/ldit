package com.mycompany.ldit.teammember.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.teammember.model.dao.TeamMemberDao;
import com.mycompany.ldit.teammember.model.vo.TeamMember;

@Service("TeamMemberService")
public class TeamMemberServiceImpl implements TeamMemberService{
	@Autowired
	private TeamMemberDao TeamMemberDao;
	@Override
	public int insertTeamMember(TeamMember tvo) throws Exception {
		return TeamMemberDao.insertTeamMember(tvo);
	}
}
