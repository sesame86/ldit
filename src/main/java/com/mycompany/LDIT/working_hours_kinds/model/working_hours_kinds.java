package com.mycompany.LDIT.working_hours_kinds.model;

public class working_hours_kinds {
	private static final long serialVersionUID = 1111L;
	private int wh_code;
	private String wh_name;
	
	public working_hours_kinds() {
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
