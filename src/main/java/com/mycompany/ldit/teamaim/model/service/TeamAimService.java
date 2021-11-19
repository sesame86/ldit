package com.mycompany.ldit.teamaim.model.service;


import java.util.List;

import com.mycompany.ldit.teamaim.model.vo.TeamAim;

public interface TeamAimService{
	public List<TeamAim> getTeamGoal(int teamId) throws Exception;
	public String goalStatusCheck(int teamId) throws Exception;
	public int postTeamGoal(TeamAim tAimVo) throws Exception;
}
