package com.mycompany.ldit.team.model.service;

import java.util.List;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.team.model.vo.Team;

public interface TeamService {
	public List<Team> getOneProjectTeam(int pro_no) throws Exception;
	public Project getOneProject(int pro_no) throws Exception;
	public List<Staff> searchPM(String searchWord) throws Exception;
	public List<Staff> searchTeamMember(String searchWord) throws Exception;
	public Staff searchByNo(int searchNo) throws Exception;
	public int insertTeam(Team tvo) throws Exception;
	public int insertTeamMember(Team tvo) throws Exception;
}