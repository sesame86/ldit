package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class WHKinds {
	
	private static final long serialVersionUID = 1112L;
	private int whCode;
	private String whName;

	public WHKinds() {
		super();
	}

	public WHKinds(int whCode, String whName) {
		super();
		this.whCode = whCode;
		this.whName = whName;
	}

	@Override
	public String toString() {
		return "WorkingHoursKinds [whCode=" + whCode + ", whName=" + whName + "]";
	}

	public int getWhCode() {
		return whCode;
	}

	public void setWhCode(int whCode) {
		this.whCode = whCode;
	}

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

}
