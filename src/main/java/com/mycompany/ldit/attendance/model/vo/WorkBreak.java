package com.mycompany.ldit.attendance.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class WorkBreak {
	
	private static final long serialVersionUID = 1112L;
	private int brNo;
	private int attNo;
	private int stfNo;
	private String brStart;
	private String brEnd;
	
	public WorkBreak() {
		super();
	}
	
	

	public WorkBreak(int brNo, int attNo, int stfNo, String brStart, String brEnd) {
		super();
		this.brNo = brNo;
		this.attNo = attNo;
		this.stfNo = stfNo;
		this.brStart = brStart;
		this.brEnd = brEnd;
	}



	@Override
	public String toString() {
		return "WorkBreak [brNo=" + brNo + ", attNo=" + attNo + ", stfNo=" + stfNo + ", brStart=" + brStart + ", brEnd="
				+ brEnd + "]";
	}



	public int getBrNo() {
		return brNo;
	}

	public void setBrNo(int brNo) {
		this.brNo = brNo;
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

	public String getBrStart() {
		return brStart;
	}

	public void setBrStart(String brStart) {
		this.brStart = brStart;
	}

	public String getBrEnd() {
		return brEnd;
	}

	public void setBrEnd(String brEnd) {
		this.brEnd = brEnd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
