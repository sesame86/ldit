package com.mycompany.ldit.issue.model;

public class Issue {
	private static final long serialVersionUID = 1111L;
	private int issue_id;
	private int work_id;
	private int stf_no;
	private String issue_title;
	private String issue_content;
	private int issue_revitalize;
	private int issue_check;
	private int issue_rank;
	
	public Issue() {
		super();
	}

	@Override
	public String toString() {
		return "issue [issue_id=" + issue_id + ", work_id=" + work_id + ", stf_no=" + stf_no + ", issue_title="
				+ issue_title + ", issue_content=" + issue_content + ", issue_revitalize=" + issue_revitalize
				+ ", issue_check=" + issue_check + ", issue_rank=" + issue_rank + "]";
	}
	
	public int getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}

	public int getWork_id() {
		return work_id;
	}

	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}

	public int getStf_no() {
		return stf_no;
	}

	public void setStf_no(int stf_no) {
		this.stf_no = stf_no;
	}

	public String getIssue_title() {
		return issue_title;
	}

	public void setIssue_title(String issue_title) {
		this.issue_title = issue_title;
	}

	public String getIssue_content() {
		return issue_content;
	}

	public void setIssue_content(String issue_content) {
		this.issue_content = issue_content;
	}

	public int getIssue_revitalize() {
		return issue_revitalize;
	}

	public void setIssue_revitalize(int issue_revitalize) {
		this.issue_revitalize = issue_revitalize;
	}

	public int getIssue_check() {
		return issue_check;
	}

	public void setIssue_check(int issue_check) {
		this.issue_check = issue_check;
	}

	public int getIssue_rank() {
		return issue_rank;
	}

	public void setIssue_rank(int issue_rank) {
		this.issue_rank = issue_rank;
	}	
}
