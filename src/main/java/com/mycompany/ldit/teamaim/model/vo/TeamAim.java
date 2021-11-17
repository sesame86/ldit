package com.mycompany.ldit.teamaim.model.vo;

import java.sql.Date;

public class TeamAim {
	private static final long serialVersionUID = 1111L;
	private int aim_id;
	private int team_id;
	private String aim_title;
	private String aim_content;
	private Date aim_start;
	private Date aim_end;
	private int aim_status;
	   
	public TeamAim() {}
	
	@Override
	public String toString() {
		return "TeamAim [aim_id=" + aim_id + ", team_id=" + team_id + ", aim_title=" + aim_title + ", aim_content="
				+ aim_content + ", aim_start=" + aim_start + ", aim_end=" + aim_end + ", aim_status=" + aim_status
				+ "]";
	}

	public int getAim_id() {
		return aim_id;
	}

	public void setAim_id(int aim_id) {
		this.aim_id = aim_id;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getAim_title() {
		return aim_title;
	}

	public void setAim_title(String aim_title) {
		this.aim_title = aim_title;
	}

	public String getAim_content() {
		return aim_content;
	}

	public void setAim_content(String aim_content) {
		this.aim_content = aim_content;
	}

	public Date getAim_start() {
		return aim_start;
	}

	public void setAim_start(Date aim_start) {
		this.aim_start = aim_start;
	}

	public Date getAim_end() {
		return aim_end;
	}

	public void setAim_end(Date aim_end) {
		this.aim_end = aim_end;
	}

	public int getAim_status() {
		return aim_status;
	}

	public void setAim_status(int aim_status) {
		this.aim_status = aim_status;
	}
	
}
