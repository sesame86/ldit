package com.mycompany.ldit.teammember.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.staff.model.vo.Staff;
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
	@Override
	public List<Staff> getTeamMemberUpdate(int teamId) throws Exception {
		return TeamMemberDao.getTeamMemberUpdate(teamId);
	}
	@Override
	public int checkDupidTeamMember(TeamMember tmVo) throws Exception {
		return TeamMemberDao.checkDupidTeamMember(tmVo);
	}
}
