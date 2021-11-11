package com.mycompany.LDIT.receive_msg.model;

public class receive_msg {
	private static final long serialVersionUID = 1111L;
	private int r_m_no;
	private int stf_no;
	private int m_no;
	private String r_m_time;
	private int r_m_check;
	private int s_stf_no;
	
	public receive_msg() {
		super();
	}

	@Override
	public String toString() {
		return "receive_msg [r_m_no=" + r_m_no + ", stf_no=" + stf_no + ", m_no=" + m_no + ", r_m_time=" + r_m_time
				+ ", r_m_check=" + r_m_check + ", s_stf_no=" + s_stf_no + "]";
	}
	
	public int getR_m_no() {
		return r_m_no;
	}

	public void setR_m_no(int r_m_no) {
		this.r_m_no = r_m_no;
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

	public String getR_m_time() {
		return r_m_time;
	}

	public void setR_m_time(String r_m_time) {
		this.r_m_time = r_m_time;
	}

	public int getR_m_check() {
		return r_m_check;
	}

	public void setR_m_check(int r_m_check) {
		this.r_m_check = r_m_check;
	}

	public int getS_stf_no() {
		return s_stf_no;
	}

	public void setS_stf_no(int s_stf_no) {
		this.s_stf_no = s_stf_no;
	}
}
