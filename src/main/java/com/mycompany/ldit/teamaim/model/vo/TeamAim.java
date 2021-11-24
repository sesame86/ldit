package com.mycompany.ldit.teamaim.model.vo;

import java.sql.Date;

public class TeamAim {
	private static final long serialVersionUID = 1111L;
	private int aimId;
	private int teamId;
	private String aimTitle;
	private String aimContent;
	private Date aimStart;
	private Date aimEnd;
	private int aimStatus;
	private char aimFinish;
	   
	public TeamAim() {}

	@Override
	public String toString() {
		return "TeamAim [aimId=" + aimId + ", teamId=" + teamId + ", aimTitle=" + aimTitle + ", aimContent="
				+ aimContent + ", aimStart=" + aimStart + ", aimEnd=" + aimEnd + ", aimStatus=" + aimStatus
				+ ", aimFinish=" + aimFinish + "]";
	}

	public int getAimId() {
		return aimId;
	}

	public void setAimId(int aimId) {
		this.aimId = aimId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getAimTitle() {
		return aimTitle;
	}

	public void setAimTitle(String aimTitle) {
		this.aimTitle = aimTitle;
	}

	public String getAimContent() {
		return aimContent;
	}

	public void setAimContent(String aimContent) {
		this.aimContent = aimContent;
	}

	public Date getAimStart() {
		return aimStart;
	}

	public void setAimStart(Date aimStart) {
		this.aimStart = aimStart;
	}

	public Date getAimEnd() {
		return aimEnd;
	}

	public void setAimEnd(Date aimEnd) {
		this.aimEnd = aimEnd;
	}

	public int getAimStatus() {
		return aimStatus;
	}

	public void setAimStatus(int aimStatus) {
		this.aimStatus = aimStatus;
	}

	public char getAimFinish() {
		return aimFinish;
	}

	public void setAimFinish(char aimFinish) {
		this.aimFinish = aimFinish;
	}
}