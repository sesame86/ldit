package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class WorkingHoursZero {
	
	private static final long serialVersionUID = 1112L;
	private String whmZeroDay;
	private String whmZeroStart;
	private String whmZeroEnd;
	private int whmZeroYesNo;

	public WorkingHoursZero() {
	}

	public WorkingHoursZero(String whmZeroDay, String whmZeroStart, String whmZeroEnd, int whmZeroYesNo) {
		super();
		this.whmZeroDay = whmZeroDay;
		this.whmZeroStart = whmZeroStart;
		this.whmZeroEnd = whmZeroEnd;
		this.whmZeroYesNo = whmZeroYesNo;
	}

	@Override
	public String toString() {
		return "WorkingHoursZero [whmZeroDay=" + whmZeroDay + ", whmZeroStart=" + whmZeroStart + ", whmZeroEnd="
				+ whmZeroEnd + ", whmZeroYesNo=" + whmZeroYesNo + "]";
	}

	public String getWhmZeroDay() {
		return whmZeroDay;
	}

	public void setWhmZeroDay(String whmZeroDay) {
		this.whmZeroDay = whmZeroDay;
	}

	public String getWhmZeroStart() {
		return whmZeroStart;
	}

	public void setWhmZeroStart(String whmZeroStart) {
		this.whmZeroStart = whmZeroStart;
	}

	public String getWhmZeroEnd() {
		return whmZeroEnd;
	}

	public void setWhmZeroEnd(String whmZeroEnd) {
		this.whmZeroEnd = whmZeroEnd;
	}

	public int getWhmZeroYesNo() {
		return whmZeroYesNo;
	}

	public void setWhmZeroYesNo(int whmZeroYesNo) {
		this.whmZeroYesNo = whmZeroYesNo;
	}
	
}
