package com.mycompany.ldit.teamaim.model.service;


import java.util.List;

import com.mycompany.ldit.teamaim.model.vo.TeamAim;

public interface TeamAimService{
	public List<TeamAim> getTeamGoal(int teamId) throws Exception;
	public TeamAim goalStatusCheck(int teamId) throws Exception;
	public int insertTeamGoal(TeamAim tAimVo) throws Exception;
	public TeamAim getUpdateGoal(int teamId) throws Exception;
	public int updateTeamGoal(TeamAim tAimVo) throws Exception;
	public int disableTeamGoal(int teamId) throws Exception;
}