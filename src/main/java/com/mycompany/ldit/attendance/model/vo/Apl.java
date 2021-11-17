package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Apl {
	
	private static final long serialVersionUID = 1112L;
	private int stfNo;
	private int aplTotal;
	
	public Apl() {
		super();
	}
	
	public Apl(int stfNo, int aplTotal) {
		super();
		this.stfNo = stfNo;
		this.aplTotal = aplTotal;
	}
	
	@Override
	public String toString() {
		return "Apl [stfNo=" + stfNo + ", aplTotal=" + aplTotal + "]";
	}
	
	public int getStfNo() {
		return stfNo;
	}
	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}
	public int getAplTotal() {
		return aplTotal;
	}
	public void setAplTotal(int aplTotal) {
		this.aplTotal = aplTotal;
	}
}
