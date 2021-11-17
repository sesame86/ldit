package com.mycompany.ldit.attendance.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class XiuxiApply {
	
	private static final long serialVersionUID = 1112L;
	private int xaNo;
	private int xiuNo;
	private int stfNo;
	private Date xaWhen;
	private Date xaStart;
	private Date xaEnd;
	
	public XiuxiApply() {
		super();
	}

	public XiuxiApply(int xaNo, int xiuNo, int stfNo, Date xaWhen, Date xaStart, Date xaEnd) {
		super();
		this.xaNo = xaNo;
		this.xiuNo = xiuNo;
		this.stfNo = stfNo;
		this.xaWhen = xaWhen;
		this.xaStart = xaStart;
		this.xaEnd = xaEnd;
	}

	@Override
	public String toString() {
		return "XiuxiApply [xaNo=" + xaNo + ", xiuNo=" + xiuNo + ", stfNo=" + stfNo + ", xaWhen=" + xaWhen
				+ ", xaStart=" + xaStart + ", xaEnd=" + xaEnd + "]";
	}

	public int getXaNo() {
		return xaNo;
	}

	public void setXaNo(int xaNo) {
		this.xaNo = xaNo;
	}

	public int getXiuNo() {
		return xiuNo;
	}

	public void setXiuNo(int xiuNo) {
		this.xiuNo = xiuNo;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public Date getXaWhen() {
		return xaWhen;
	}

	public void setXaWhen(Date xaWhen) {
		this.xaWhen = xaWhen;
	}

	public Date getXaStart() {
		return xaStart;
	}

	public void setXaStart(Date xaStart) {
		this.xaStart = xaStart;
	}

	public Date getXaEnd() {
		return xaEnd;
	}

	public void setXaEnd(Date xaEnd) {
		this.xaEnd = xaEnd;
	}
}
