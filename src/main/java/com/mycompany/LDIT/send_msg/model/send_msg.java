package com.mycompany.LDIT.send_msg.model;

public class send_msg {
	private static final long serialVersionUID = 1111L;
	private int s_m_no;
	private int stf_no;
	private int m_no;
	private String s_m_time;
	private int r_stf_no;
	
	public send_msg() {
		super();
	}

	@Override
	public String toString() {
		return "send_msg [s_m_no=" + s_m_no + ", stf_no=" + stf_no + ", m_no=" + m_no + ", s_m_time=" + s_m_time
				+ ", r_stf_no=" + r_stf_no + "]";
	}
	
	public int getS_m_no() {
		return s_m_no;
	}

	public void setS_m_no(int s_m_no) {
		this.s_m_no = s_m_no;
	}

	public int getStf_no() {
		return stf_no;
	}

	public void setStf_no(int stf_no) {
		this.stf_no = stf_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getS_m_time() {
		return s_m_time;
	}

	public void setS_m_time(String s_m_time) {
		this.s_m_time = s_m_time;
	}

	public int getR_stf_no() {
		return r_stf_no;
	}

	public void setR_stf_no(int r_stf_no) {
		this.r_stf_no = r_stf_no;
	}
}
