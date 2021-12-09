package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Xiuxi {
	
	private static final long serialVersionUID = 1112L;
	private String xiuNo;
	private String xiuReason;
	private String xiuState;
	private int xiuAplYesNo;
	
	public Xiuxi() {
	}
	
	public Xiuxi(String xiuNo, String xiuReason, String xiuState, int xiuAplYesNo) {
		super();
		this.xiuNo = xiuNo;
		this.xiuReason = xiuReason;
		this.xiuState = xiuState;
		this.xiuAplYesNo = xiuAplYesNo;
	}
	
	@Override
	public String toString() {
		return "Xiuxi [xiuNo=" + xiuNo + ", xiuReason=" + xiuReason + ", xiuState=" + xiuState + ", xiuAplYesNo="
				+ xiuAplYesNo + "]";
	}

	public String getXiuNo() {
		return xiuNo;
	}
	
	public void setXiuNo(String xiuNo) {
		this.xiuNo = xiuNo;
	}
	
	public String getXiuReason() {
		return xiuReason;
	}
	
	public void setXiuReason(String xiuReason) {
		this.xiuReason = xiuReason;
	}
	
	public String getXiuState() {
		return xiuState;
	}
	
	public void setXiuState(String xiuState) {
		this.xiuState = xiuState;
	}
	
	public int getXiuAplYesNo() {
		return xiuAplYesNo;
	}
	
	public void setXiuAplYesNo(int xiuAplYesNo) {
		this.xiuAplYesNo = xiuAplYesNo;
	}

}
