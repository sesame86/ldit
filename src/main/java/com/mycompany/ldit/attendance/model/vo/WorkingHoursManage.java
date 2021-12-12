package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class WorkingHoursManage {
	
	private static final long serialVersionUID = 1112L;
	private String whmCode;
	private String whmRestCode;
	
	public WorkingHoursManage() {
		super();
	}

	public WorkingHoursManage(String whmCode, String whmRestCode) {
		super();
		this.whmCode = whmCode;
		this.whmRestCode = whmRestCode;
	}

	@Override
	public String toString() {
		return "WorkingHoursManage [whmCode=" + whmCode + ", whmRestCode=" + whmRestCode + "]";
	}

	public String getWhmCode() {
		return whmCode;
	}
	
	public void setWhmCode(String whmCode) {
		this.whmCode = whmCode;
	}

	public String getWhmRestCode() {
		return whmRestCode;
	}

	public void setWhmRestCode(String whmRestCode) {
		this.whmRestCode = whmRestCode;
	}
	
}
