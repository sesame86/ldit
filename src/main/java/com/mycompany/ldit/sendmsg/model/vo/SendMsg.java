package com.mycompany.ldit.sendmsg.model.vo;

import org.springframework.stereotype.Component;

@Component
public class SendMsg {
	private static final long serialVersionUID = 1111L;
	private int sMNo;
	private int stfNo;
	private int mNo;
	private String sMTime;
	private String rStfId;
	public int getsMNo() {
		return sMNo;
	}
	public void setsMNo(int sMNo) {
		this.sMNo = sMNo;
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
	public String getsMTime() {
		return sMTime;
	}
	public void setsMTime(String sMTime) {
		this.sMTime = sMTime;
	}
	public String getrStfId() {
		return rStfId;
	}
	public void setrStfId(String rStfId) {
		this.rStfId = rStfId;
	}
	@Override
	public String toString() {
		return "SendMsg [sMNo=" + sMNo + ", stfNo=" + stfNo + ", mNo=" + mNo + ", sMTime=" + sMTime + ", rStfId="
				+ rStfId + "]";
	}
	
}