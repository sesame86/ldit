package com.mycompany.LDIT.app_doc.model;

public class app_doc {
	private static final long serialVersionUID = 1111L;
	private int doc_no;
	private int dt_no;
	private String doc_title;
	private String doc_content;
	private String app_path;
	private int stf_no;
	
	public app_doc() {
		super();
	}

	@Override
	public String toString() {
		return "approval_doc [doc_no=" + doc_no + ", dt_no=" + dt_no + ", doc_title=" + doc_title + ", doc_content="
				+ doc_content + ", app_path=" + app_path + ", stf_no=" + stf_no + "]";
	}
	
	public int getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}

	public int getDt_no() {
		return dt_no;
	}

	public void setDt_no(int dt_no) {
		this.dt_no = dt_no;
	}

	public String getDoc_title() {
		return doc_title;
	}

	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}

	public String getDoc_content() {
		return doc_content;
	}

	public void setDoc_content(String doc_content) {
		this.doc_content = doc_content;
	}

	public String getApp_path() {
		return app_path;
	}

	public void setApp_path(String app_path) {
		this.app_path = app_path;
	}

	public int getStf_no() {
		return stf_no;
	}

	public void setStf_no(int stf_no) {
		this.stf_no = stf_no;
	}	
}
