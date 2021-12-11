package com.mycompany.ldit.teammember.model.service;

import java.util.List;

import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.teammember.model.vo.TeamMember;

public interface TeamMemberService {
	public int insertTeamMember(TeamMember tvo) throws Exception;
	public List<Staff> getTeamMemberUpdate(int teamId) throws Exception;
	public int checkDupidTeamMember(TeamMember tmVo) throws Exception;
}
