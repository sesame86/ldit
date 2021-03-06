package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Attendance {
	
	private static final long serialVersionUID = 1112L;
	private int attNo;
	private int stfNo;
	private String attStart;
	private String attEnd;
	private String attRestAll;
	
	public Attendance() {
		super();
	}

	public Attendance(int attNo, int stfNo, String attStart, String attEnd, String attRestAll) {
		super();
		this.attNo = attNo;
		this.stfNo = stfNo;
		this.attStart = attStart;
		this.attEnd = attEnd;
		this.attRestAll = attRestAll;
	}

	@Override
	public String toString() {
		return "Attendance [attNo=" + attNo + ", stfNo=" + stfNo + ", attStart=" + attStart + ", attEnd=" + attEnd
				+"attRestAll"+attRestAll+"]";
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

	public String getAttRestAll() {
		return attRestAll;
	}

	public void setAttRestAll(String attRestAll) {
		this.attRestAll = attRestAll;
	}

}
