package com.mycompany.ldit.attendance.model.vo;

import org.springframework.stereotype.Component;

@Component
public class XiuxiApply {
	
	private static final long serialVersionUID = 1112L;
	private int xaNo;
	private String xiuNo;
	private int stfNo;
	private int xaWhen;
	private String xaStart;
	private String xaEnd;
	private Xiuxi xiuxi;
	
	public XiuxiApply() {
		super();
	}

	public XiuxiApply(int xaNo, String xiuNo, int stfNo, int xaWhen, String xaStart, String xaEnd, Xiuxi xiuxi) {
		super();
		this.xaNo = xaNo;
		this.xiuNo = xiuNo;
		this.stfNo = stfNo;
		this.xaWhen = xaWhen;
		this.xaStart = xaStart;
		this.xaEnd = xaEnd;
		this.xiuxi = xiuxi;
	}

	@Override
	public String toString() {
		return "XiuxiApply [xaNo=" + xaNo + ", xiuNo=" + xiuNo + ", stfNo=" + stfNo + ", xaWhen=" + xaWhen
				+ ", xaStart=" + xaStart + ", xaEnd=" + xaEnd + ", xiuxi=" + xiuxi + "]";
	}

	public int getXaNo() {
		return xaNo;
	}

	public void setXaNo(int xaNo) {
		this.xaNo = xaNo;
	}

	public String getXiuNo() {
		return xiuNo;
	}

	public void setXiuNo(String xiuNo) {
		this.xiuNo = xiuNo;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public int getXaWhen() {
		return xaWhen;
	}

	public void setXaWhen(int xaWhen) {
		this.xaWhen = xaWhen;
	}

	public String getXaStart() {
		return xaStart;
	}

	public void setXaStart(String xaStart) {
		this.xaStart = xaStart;
	}

	public String getXaEnd() {
		return xaEnd;
	}

	public void setXaEnd(String xaEnd) {
		this.xaEnd = xaEnd;
	}

	public Xiuxi getXiuxi() {
		return xiuxi;
	}

	public void setXiuxi(Xiuxi xiuxi) {
		this.xiuxi = xiuxi;
	}
	
}
