package com.mycompany.ldit.team.model.vo;

public class TeamJoinAim {
	private int team_id;
	private int pro_no;
	private String team_title;
	private int team_manager;
	private int aim_id;
	private int aim_status;
	
	public TeamJoinAim() {}

	@Override
	public String toString() {
		return "TeamJoinAim [team_id=" + team_id + ", pro_no=" + pro_no + ", team_title=" + team_title
				+ ", team_manager=" + team_manager + ", aim_id=" + aim_id + ", aim_status="
				+ aim_status + "]";
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

	public int getAim_id() {
		return aim_id;
	}

	public void setAim_id(int aim_id) {
		this.aim_id = aim_id;
	}

	public int getAim_status() {
		return aim_status;
	}

	public void setAim_status(int aim_status) {
		this.aim_status = aim_status;
	}
}