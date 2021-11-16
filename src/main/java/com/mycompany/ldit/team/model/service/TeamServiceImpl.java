package com.mycompany.ldit.team.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.team.model.dao.TeamDao;

@Service("TeamService")
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDao TeamDao;
	
	@Override
	public Project getOneProject(int pro_no) throws Exception {
		return TeamDao.getOneProject(pro_no);
	}
}