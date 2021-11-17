package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class PlusWork {
	
	private static final long serialVersionUID = 1112L;
	private int attNo;
	private int stfNo;
	private int whCode;
	private int pwHours;

	public PlusWork() {
	}

	public PlusWork(int attNo, int stfNo, int whCode, int pwHours) {
		super();
		this.attNo = attNo;
		this.stfNo = stfNo;
		this.whCode = whCode;
		this.pwHours = pwHours;
	}

	@Override
	public String toString() {
		return "PlusWork [attNo=" + attNo + ", stfNo=" + stfNo + ", whCode=" + whCode + ", pwHours=" + pwHours + "]";
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

	public int getWhCode() {
		return whCode;
	}

	public void setWhCode(int whCode) {
		this.whCode = whCode;
	}

	public int getPwHours() {
		return pwHours;
	}

	public void setPwHours(int pwHours) {
		this.pwHours = pwHours;
	}
}
