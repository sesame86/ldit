package com.mycompany.ldit.teamaim.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Throwable.class})
	public int postTeamGoal(TeamAim tAimVo) throws Exception {
		return TeamAimDao.postTeamGoal(tAimVo);
	}
	@Override
	public TeamAim getUpdateGoal(int teamId) throws Exception {
		return TeamAimDao.getUpdateGoal(teamId);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Throwable.class})
	public int updateTeamGoal(TeamAim tAimVo) throws Exception {
		return TeamAimDao.updateTeamGoal(tAimVo);
	}
}
