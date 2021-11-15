package com.mycompany.LDIT.team_member.model;

public class team_member {
	private static final long serialVersionUID = 1111L;
	private int team_id;
	private int stf_no;
	
	public team_member() {
		super();
	}

	@Override
	public String toString() {
		return "team_member [team_id=" + team_id + ", stf_no=" + stf_no + "]";
	}
	
	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public int getStf_no() {
		return stf_no;
	}

	public void setStf_no(int stf_no) {
		this.stf_no = stf_no;
	}
}
