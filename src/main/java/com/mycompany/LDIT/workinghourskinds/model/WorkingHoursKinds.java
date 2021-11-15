package com.mycompany.ldit.workinghourskinds.model;

public class WorkingHoursKinds {
	private static final long serialVersionUID = 1111L;
	private int wh_code;
	private String wh_name;
	
	public WorkingHoursKinds() {
		super();
	}

	@Override
	public String toString() {
		return "working_hours_kinds [wh_code=" + wh_code + ", wh_name=" + wh_name + "]";
	}
	
	public int getWh_code() {
		return wh_code;
	}

	public void setWh_code(int wh_code) {
		this.wh_code = wh_code;
	}

	public String getWh_name() {
		return wh_name;
	}

	public void setWh_name(String wh_name) {
		this.wh_name = wh_name;
	}
}
