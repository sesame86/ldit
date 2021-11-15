package com.mycompany.ldit.team.model;

public class Team {
	private static final long serialVersionUID = 1111L;
	private int team_id;
	private int pro_no;
	private String team_title;
	private int team_manager;
	
	public Team() {
		super();
	}

	@Override
	public String toString() {
		return "team [team_id=" + team_id + ", pro_no=" + pro_no + ", team_title=" + team_title + ", team_manager="
				+ team_manager + "]";
	}
	
	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public String getTeam_title() {
		return team_title;
	}

	public void setTeam_title(String team_title) {
		this.team_title = team_title;
	}

	public int getTeam_manager() {
		return team_manager;
	}

	public void setTeam_manager(int team_manager) {
		this.team_manager = team_manager;
	}	
}
