package com.mycompany.ldit.receivemsg.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ReceiveMsg {
	private static final long serialVersionUID = 1111L;
	   private int rMNo;
	   private int stfNo;
	   private int mNo;
	   private String rMTime;
	   private int rMCheck;
	   private String sStfId;
	public int getrMNo() {
		return rMNo;
	}
	public void setrMNo(int rMNo) {
		this.rMNo = rMNo;
	}
	public int getStfNo() {
		return stfNo;
	}
	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getrMTime() {
		return rMTime;
	}
	public void setrMTime(String rMTime) {
		this.rMTime = rMTime;
	}
	public int getrMCheck() {
		return rMCheck;
	}
	public void setrMCheck(int rMCheck) {
		this.rMCheck = rMCheck;
	}
	public String getsStfId() {
		return sStfId;
	}
	public void setsStfId(String sStfId) {
		this.sStfId = sStfId;
	}
	@Override
	public String toString() {
		return "ReceiveMsg [rMNo=" + rMNo + ", stfNo=" + stfNo + ", mNo=" + mNo + ", rMTime=" + rMTime + ", rMCheck="
				+ rMCheck + ", sStfId=" + sStfId + "]";
	}

}
