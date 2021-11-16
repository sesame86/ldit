package com.mycompany.ldit.team.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.team.model.dao.TeamDao;
import com.mycompany.ldit.team.model.vo.TeamJoinAim;

@Service("TeamService")
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDao TeamDao;
	
	@Override
	public List<TeamJoinAim> getOneProjectTeam(int pro_no) throws Exception {
		return TeamDao.getOneProjectTeam(pro_no);
	}
	@Override
	public Project getOneProject(int pro_no) throws Exception {
		return TeamDao.getOneProject(pro_no);
	}
}