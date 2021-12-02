package com.mycompany.ldit.attendance.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Attendance {
	
	private static final long serialVersionUID = 1112L;
	private int attNo;
	private int stfNo;
	private String attStart;
	private String attEnd;
	
	public Attendance() {
		super();
	}
	

	public Attendance(int attNo, int stfNo, String attStart, String attEnd) {
		super();
		this.attNo = attNo;
		this.stfNo = stfNo;
		this.attStart = attStart;
		this.attEnd = attEnd;
	}


	public int getAttNo() {
		return attNo;
	}

	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public String getAttStart() {
		return attStart;
	}

	public void setAttStart(String attStart) {
		this.attStart = attStart;
	}

	public String getAttEnd() {
		return attEnd;
	}

	public void setAttEnd(String attEnd) {
		this.attEnd = attEnd;
	}

	
}
