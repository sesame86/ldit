package com.mycompany.ldit.work.model.vo;

import java.sql.Date;

public class Work {
	private static final long serialVersionUID = 1111L;
	private int workId;
	private int stfNo;
	private String workTitle;
	private String workContent;
	private Date workStart;
	private Date workEnd;
	private int workFinish;

	public Work() {
	}

	@Override
	public String toString() {
		return "Work [workId=" + workId + ", stfNo=" + stfNo + ", workTitle=" + workTitle + ", workContent="
				+ workContent + ", workStart=" + workStart + ", workEnd=" + workEnd + ", workFinish=" + workFinish
				+ "]";
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public String getWorkTitle() {
		return workTitle;
	}

	public void setWorkTitle(String workTitle) {
		this.workTitle = workTitle;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public Date getWorkStart() {
		return workStart;
	}

	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}

	public Date getWorkEnd() {
		return workEnd;
	}

	public void setWorkEnd(Date workEnd) {
		this.workEnd = workEnd;
	}

	public int getWorkFinish() {
		return workFinish;
	}

	public void setWorkFinish(int workFinish) {
		this.workFinish = workFinish;
	}
}