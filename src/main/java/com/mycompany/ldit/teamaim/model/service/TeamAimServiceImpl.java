package com.mycompany.ldit.teamaim.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.teamaim.model.dao.TeamAimDao;
import com.mycompany.ldit.teamaim.model.vo.TeamAim;

@Service("TeamAimService")
public class TeamAimServiceImpl implements TeamAimService{
	@Autowired
	private TeamAimDao TeamAimDao;
	
	@Override
	public List<TeamAim> getTeamGoal(int teamId) throws Exception {
		return TeamAimDao.getTeamGoal(teamId);
	}
	@Override
	public String goalStatusCheck(int teamId) throws Exception {
		return TeamAimDao.goalStatusCheck(teamId);
	}
}
