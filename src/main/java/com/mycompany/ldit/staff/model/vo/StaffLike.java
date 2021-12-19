package com.mycompany.ldit.staff.model.vo;

public class StaffLike {

	private int likeNO;
	private int hostStfNo;
	private int wantedStfNo;
	
	public StaffLike() {
	}

	public StaffLike(int likeNO, int hostStfNo, int wantedStfNo) {
		super();
		this.likeNO = likeNO;
		this.hostStfNo = hostStfNo;
		this.wantedStfNo = wantedStfNo;
	}

	@Override
	public String toString() {
		return "StaffLike [likeNO=" + likeNO + ", hostStfNo=" + hostStfNo + ", wantedStfNo=" + wantedStfNo + "]";
	}

	public int getLikeNO() {
		return likeNO;
	}

	public void setLikeNO(int likeNO) {
		this.likeNO = likeNO;
	}

	public int getHostStfNo() {
		return hostStfNo;
	}

	public void setHostStfNo(int hostStfNo) {
		this.hostStfNo = hostStfNo;
	}

	public int getWantedStfNo() {
		return wantedStfNo;
	}

	public void setWantedStfNo(int wantedStfNo) {
		this.wantedStfNo = wantedStfNo;
	}
	
}
