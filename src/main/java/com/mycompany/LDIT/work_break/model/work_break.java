package com.mycompany.LDIT.work_break.model;

import java.sql.Date;

public class work_break {
	private static final long serialVersionUID = 1111L;
	private int br_no;
	private Date att_date;
	private int stf_no;
	private Date br_start;
	private Date br_end;
	
	public work_break() {
		super();
	}

	@Override
	public String toString() {
		return "work_break [br_no=" + br_no + ", att_date=" + att_date + ", stf_no=" + stf_no + ", br_start=" + br_start
				+ ", br_end=" + br_end + "]";
	}
	
	public int getBr_no() {
		return br_no;
	}

	public void setBr_no(int br_no) {
		this.br_no = br_no;
	}

	public Date getAtt_date() {
		return att_date;
	}

	public void setAtt_date(Date att_date) {
		this.att_date = att_date;
	}

	public int getStf_no() {
		return stf_no;
	}

	public void setStf_no(int stf_no) {
		this.stf_no = stf_no;
	}

	public Date getBr_start() {
		return br_start;
	}

	public void setBr_start(Date br_start) {
		this.br_start = br_start;
	}

	public Date getBr_end() {
		return br_end;
	}

	public void setBr_end(Date br_end) {
		this.br_end = br_end;
	}
}
