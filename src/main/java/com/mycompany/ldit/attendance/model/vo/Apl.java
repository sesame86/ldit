package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Apl {
	
	private static final long serialVersionUID = 1112L;
	private int aplNo;
	private int stfNo;
	private String aplDate;
	private String aplState;
	
	public Apl() {
		super();
	}

	public Apl(int aplNo, int stfNo, String aplDate, String aplState) {
		super();
		this.aplNo = aplNo;
		this.stfNo = stfNo;
		this.aplDate = aplDate;
		this.aplState = aplState;
	}

	@Override
	public String toString() {
		return "Apl [aplNo=" + aplNo + ", stfNo=" + stfNo + ", aplDate=" + aplDate + ", aplState=" + aplState + "]";
	}

	public int getAplNo() {
		return aplNo;
	}

	public void setAplNo(int aplNo) {
		this.aplNo = aplNo;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public String getAplDate() {
		return aplDate;
	}

	public void setAplDate(String aplDate) {
		this.aplDate = aplDate;
	}

	public String getAplState() {
		return aplState;
	}

	public void setAplState(String aplState) {
		this.aplState = aplState;
	}
	
}
