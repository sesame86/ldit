package com.mycompany.ldit.msg.model;

public class Msg {
	private static final long serialVersionUID = 1111L;
	private int m_no;
	private String m_title;
	private String m_content;
	
	public Msg() {
		super();
	}

	@Override
	public String toString() {
		return "msg [m_no=" + m_no + ", m_title=" + m_title + ", m_content=" + m_content + "]";
	}
	
	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public String getM_content() {
		return m_content;
	}

	public void setM_content(String m_content) {
		this.m_content = m_content;
	}	
}
