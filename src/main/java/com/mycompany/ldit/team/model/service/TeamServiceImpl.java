package com.mycompany.ldit.team.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.team.model.dao.TeamDao;
import com.mycompany.ldit.team.model.vo.Team;

@Service("TeamService")
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDao TeamDao;
	
	@Override
	public List<Team> getOneProjectTeam(int proNo) throws Exception {
		return TeamDao.getOneProjectTeam(proNo);
	}
	@Override
	public List<Team> getTeamMemberTeamList(Team tvo) throws Exception {
		return TeamDao.getTeamMemberTeamList(tvo);
	}
	@Override
	public Project getOneProject(int proNo) throws Exception {
		return TeamDao.getOneProject(proNo);
	}
	@Override
	public List<Staff> searchPM(String searchWord) throws Exception {
		return TeamDao.searchPM(searchWord);
	}
	@Override
	public List<Staff> searchTeamMember(String searchWord) throws Exception {
		return TeamDao.searchPM(searchWord);
	}
	@Override
	public Staff searchByNo(int searchNo) throws Exception {
		return TeamDao.searchByNo(searchNo);
	}
	@Override
	public int insertTeam(Team tvo) throws Exception {
		return TeamDao.insertTeam(tvo);
	}
	@Override
	public int getStaffRight(int stfNo) throws Exception {
		return TeamDao.getStaffRight(stfNo);
	}
	@Override
	public Team getTeamUpdate(int proNo) throws Exception {
		return TeamDao.getTeamUpdate(proNo);
	}
}