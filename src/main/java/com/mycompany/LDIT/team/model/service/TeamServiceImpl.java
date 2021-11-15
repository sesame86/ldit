package com.mycompany.LDIT.team.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.LDIT.project.model.project;
import com.mycompany.LDIT.team.model.dao.TeamDao;

@Service("TeamService")
@Transactional(rollbackFor = Exception.class)
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDao TeamDao;
	
	@Override
	public project getOneProject(int pro_no) throws Exception {
		return TeamDao.getOneProject(pro_no);
	}
}