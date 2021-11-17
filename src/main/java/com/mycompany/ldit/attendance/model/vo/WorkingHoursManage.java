package com.mycompany.ldit.attendance.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class WorkingHoursManage {
	
	private static final long serialVersionUID = 1112L;
	private int whDate;
	private int whCode;
	private Date whStart;
	private Date whEnd;
	private int whTotal;

	public WorkingHoursManage() {
	}

	public WorkingHoursManage(int whDate, int whCode, Date whStart, Date whEnd, int whTotal) {
		super();
		this.whDate = whDate;
		this.whCode = whCode;
		this.whStart = whStart;
		this.whEnd = whEnd;
		this.whTotal = whTotal;
	}

	@Override
	public String toString() {
		return "WorkingHoursManage [whDate=" + whDate + ", whCode=" + whCode + ", whStart=" + whStart + ", whEnd="
				+ whEnd + ", whTotal=" + whTotal + "]";
	}

	public int getWhDate() {
		return whDate;
	}

	public void setWhDate(int whDate) {
		this.whDate = whDate;
	}

	public int getWhCode() {
		return whCode;
	}

	public void setWhCode(int whCode) {
		this.whCode = whCode;
	}

	public Date getWhStart() {
		return whStart;
	}

	public void setWhStart(Date whStart) {
		this.whStart = whStart;
	}

	public Date getWhEnd() {
		return whEnd;
	}

	public void setWhEnd(Date whEnd) {
		this.whEnd = whEnd;
	}

	public int getWhTotal() {
		return whTotal;
	}

	public void setWhTotal(int whTotal) {
		this.whTotal = whTotal;
	}

}
