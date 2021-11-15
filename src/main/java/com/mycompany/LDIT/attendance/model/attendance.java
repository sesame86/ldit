package com.mycompany.LDIT.attendance.model;

import java.sql.Date;

public class attendance {
	private static final long serialVersionUID = 1111L;
	private Date att_date;
	private int stf_no;
	private Date att_st_date;
	private Date att_start;
	private Date att_end_date;
	private Date att_end;
	private int xiu_no;
	private int wh_code;
	
	public attendance() {
		super();
	}

	@Override
	public String toString() {
		return "attendance [att_date=" + att_date + ", stf_no=" + stf_no + ", att_st_date=" + att_st_date
				+ ", att_start=" + att_start + ", att_end_date=" + att_end_date + ", att_end=" + att_end + ", xiu_no="
				+ xiu_no + ", wh_code=" + wh_code + "]";
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

	public Date getAtt_st_date() {
		return att_st_date;
	}

	public void setAtt_st_date(Date att_st_date) {
		this.att_st_date = att_st_date;
	}

	public Date getAtt_start() {
		return att_start;
	}

	public void setAtt_start(Date att_start) {
		this.att_start = att_start;
	}

	public Date getAtt_end_date() {
		return att_end_date;
	}

	public void setAtt_end_date(Date att_end_date) {
		this.att_end_date = att_end_date;
	}

	public Date getAtt_end() {
		return att_end;
	}

	public void setAtt_end(Date att_end) {
		this.att_end = att_end;
	}

	public int getXiu_no() {
		return xiu_no;
	}

	public void setXiu_no(int xiu_no) {
		this.xiu_no = xiu_no;
	}

	public int getWh_code() {
		return wh_code;
	}

	public void setWh_code(int wh_code) {
		this.wh_code = wh_code;
	}	
}
