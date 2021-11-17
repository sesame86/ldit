package com.mycompany.ldit.attendance.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Attendance {
	
	private static final long serialVersionUID = 1112L;
	private int attNo;
	private int stfNo;
	private Date attWhen;
	private Date attStart;
	private Date attEnd;
	private int whCode;
	
	public Attendance() {
		super();
	}

	public Attendance(int attNo, int stfNo, Date attWhen, Date attStart, Date attEnd, int whCode) {
		super();
		this.attNo = attNo;
		this.stfNo = stfNo;
		this.attWhen = attWhen;
		this.attStart = attStart;
		this.attEnd = attEnd;
		this.whCode = whCode;
	}
	
	@Override
	public String toString() {
		return "Attendance [attNo=" + attNo + ", stfNo=" + stfNo + ", attWhen=" + attWhen + ", attStart=" + attStart
				+ ", attEnd=" + attEnd + ", whCode=" + whCode + "]";
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

	public Date getAttWhen() {
		return attWhen;
	}

	public void setAttWhen(Date attWhen) {
		this.attWhen = attWhen;
	}

	public Date getAttStart() {
		return attStart;
	}

	public void setAttStart(Date attStart) {
		this.attStart = attStart;
	}

	public Date getAttEnd() {
		return attEnd;
	}

	public void setAttEnd(Date attEnd) {
		this.attEnd = attEnd;
	}

	public int getWhCode() {
		return whCode;
	}

	public void setWhCode(int whCode) {
		this.whCode = whCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
