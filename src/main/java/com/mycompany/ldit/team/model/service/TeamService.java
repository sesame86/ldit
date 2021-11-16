package com.mycompany.ldit.team.model.service;

import java.util.List;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.team.model.vo.TeamJoinAim;

public interface TeamService {
	public List<TeamJoinAim> getOneProjectTeam(int pro_no) throws Exception;
	public Project getOneProject(int pro_no) throws Exception;
}