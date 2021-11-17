package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Xiuxi {
	
	private static final long serialVersionUID = 1112L;
	private int xiuNo;
	private String xiuReason;
	private int xiuOfficial;

	public Xiuxi() {
	}

	public Xiuxi(int xiuNo, String xiuReason, int xiuOfficial) {
		super();
		this.xiuNo = xiuNo;
		this.xiuReason = xiuReason;
		this.xiuOfficial = xiuOfficial;
	}

	@Override
	public String toString() {
		return "Xiuxi [xiuNo=" + xiuNo + ", xiuReason=" + xiuReason + ", xiuOfficial=" + xiuOfficial + "]";
	}

	public int getXiuNo() {
		return xiuNo;
	}

	public void setXiuNo(int xiuNo) {
		this.xiuNo = xiuNo;
	}

	public String getXiuReason() {
		return xiuReason;
	}

	public void setXiuReason(String xiuReason) {
		this.xiuReason = xiuReason;
	}

	public int getXiuOfficial() {
		return xiuOfficial;
	}

	public void setXiuOfficial(int xiuOfficial) {
		this.xiuOfficial = xiuOfficial;
	}

}
