package com.mycompany.LDIT.app_doc_file.model;

public class app_doc_file {
	private static final long serialVersionUID = 1111L;
	private int ad_file_no;
	private String ad_file_title;
	private int doc_no;
	
	public app_doc_file() {
		super();
	}

	@Override
	public String toString() {
		return "approval_doc_file [ad_file_no=" + ad_file_no + ", ad_file_title=" + ad_file_title + ", doc_no=" + doc_no
				+ "]";
	}
	
	public int getAd_file_no() {
		return ad_file_no;
	}

	public void setAd_file_no(int ad_file_no) {
		this.ad_file_no = ad_file_no;
	}

	public String getAd_file_title() {
		return ad_file_title;
	}

	public void setAd_file_title(String ad_file_title) {
		this.ad_file_title = ad_file_title;
	}

	public int getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}	
}
