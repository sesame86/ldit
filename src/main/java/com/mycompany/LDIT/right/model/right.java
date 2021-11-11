package com.mycompany.LDIT.right.model;

public class right {
	private static final long serialVersionUID = 1111L;
	private int pro_no;
	private int stf_no;
	private int right_no;
	
	public right() {
		super();
	}

	@Override
	public String toString() {
		return "right [pro_no=" + pro_no + ", stf_no=" + stf_no + ", right_no=" + right_no + "]";
	}
	
	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public int getStf_no() {
		return stf_no;
	}

	public void setStf_no(int stf_no) {
		this.stf_no = stf_no;
	}

	public int getRight_no() {
		return right_no;
	}

	public void setRight_no(int right_no) {
		this.right_no = right_no;
	}	
}
