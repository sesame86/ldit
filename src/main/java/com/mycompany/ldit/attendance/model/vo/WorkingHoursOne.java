package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class WorkingHoursOne {
	
	private static final long serialVersionUID = 1112L;
	private int whmOneCode;
	
	public WorkingHoursOne() {
	}

	public WorkingHoursOne(int whmOneCode) {
		super();
		this.whmOneCode = whmOneCode;
	}

	@Override
	public String toString() {
		return "WorkingHoursOne [whmOneCode=" + whmOneCode + "]";
	}

	public int getWhmOneCode() {
		return whmOneCode;
	}

	public void setWhmOneCode(int whmOneCode) {
		this.whmOneCode = whmOneCode;
	}
	
}
