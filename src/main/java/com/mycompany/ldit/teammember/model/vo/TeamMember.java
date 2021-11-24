package com.mycompany.ldit.teammember.model.vo;

import org.springframework.stereotype.Component;

@Component
public class TeamMember {
	private static final long serialVersionUID = 1111L;
	   private int teamId;
	   private int stfNo;
	   
	   public TeamMember() {
	      super();
	   }

	@Override
	public String toString() {
		return "TeamMember [teamId=" + teamId + ", stfNo=" + stfNo + "]";
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

}