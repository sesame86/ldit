package com.mycompany.ldit.team.model.vo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.teamaim.model.vo.TeamAim;

@Component
public class Team {
	private static final long serialVersionUID = 1111L;
	private int teamId;
	private int proNo;
	private String teamTitle;
	private int teamManager;
	private TeamAim teamAim;
	private Staff staff;
	private ArrayList<Staff> staffList;
	
	public Team() {}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", proNo=" + proNo + ", teamTitle=" + teamTitle + ", teamManager="
				+ teamManager + ", teamAim=" + teamAim + ", staff=" + staff + ", staffList=" + staffList + "]";
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getTeamTitle() {
		return teamTitle;
	}

	public void setTeamTitle(String teamTitle) {
		this.teamTitle = teamTitle;
	}

	public int getTeamManager() {
		return teamManager;
	}

	public void setTeamManager(int teamManager) {
		this.teamManager = teamManager;
	}

	public TeamAim getTeamAim() {
		return teamAim;
	}

	public void setTeamAim(TeamAim teamAim) {
		this.teamAim = teamAim;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}
}