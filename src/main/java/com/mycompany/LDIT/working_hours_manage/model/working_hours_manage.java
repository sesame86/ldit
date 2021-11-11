package com.mycompany.LDIT.working_hours_manage.model;

import java.sql.Date;

public class working_hours_manage {
	private static final long serialVersionUID = 1111L;
	private Date wh_date;
	private Date wh_start;
	private Date wh_end;
	private int wh_total;
	private int wh_code;
	
	public working_hours_manage() {
		super();
	}

	@Override
	public String toString() {
		return "working_hours_manage [wh_date=" + wh_date + ", wh_start=" + wh_start + ", wh_end=" + wh_end
				+ ", wh_total=" + wh_total + ", wh_code=" + wh_code + "]";
	}
	
	public Date getWh_date() {
		return wh_date;
	}

	public void setWh_date(Date wh_date) {
		this.wh_date = wh_date;
	}

	public Date getWh_start() {
		return wh_start;
	}

	public void setWh_start(Date wh_start) {
		this.wh_start = wh_start;
	}

	public Date getWh_end() {
		return wh_end;
	}

	public void setWh_end(Date wh_end) {
		this.wh_end = wh_end;
	}

	public int getWh_total() {
		return wh_total;
	}

	public void setWh_total(int wh_total) {
		this.wh_total = wh_total;
	}

	public int getWh_code() {
		return wh_code;
	}

	public void setWh_code(int wh_code) {
		this.wh_code = wh_code;
	}
}
