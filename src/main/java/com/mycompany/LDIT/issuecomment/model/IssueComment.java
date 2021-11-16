package com.mycompany.ldit.issuecomment.model;

public class IssueComment {
	private static final long serialVersionUID = 1111L;
	   private int icom_id;
	   private int issue_id;
	   private int stf_no;
	   private int work_id;
	   private int pro_no;
	   private String icom_content;
	   
	   public IssueComment() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "issue_comment [icom_id=" + icom_id + ", issue_id=" + issue_id + ", stf_no=" + stf_no + ", work_id="
	            + work_id + ", pro_no=" + pro_no + ", icom_content=" + icom_content + "]";
	   }
	   
	   public int getIcom_id() {
	      return icom_id;
	   }

	   public void setIcom_id(int icom_id) {
	      this.icom_id = icom_id;
	   }

	   public int getIssue_id() {
	      return issue_id;
	   }

	   public void setIssue_id(int issue_id) {
	      this.issue_id = issue_id;
	   }

	   public int getStf_no() {
	      return stf_no;
	   }

	   public void setStf_no(int stf_no) {
	      this.stf_no = stf_no;
	   }

	   public int getWork_id() {
	      return work_id;
	   }

	   public void setWork_id(int work_id) {
	      this.work_id = work_id;
	   }

	   public int getPro_no() {
	      return pro_no;
	   }

	   public void setPro_no(int pro_no) {
	      this.pro_no = pro_no;
	   }

	   public String getIcom_content() {
	      return icom_content;
	   }

	   public void setIcom_content(String icom_content) {
	      this.icom_content = icom_content;
	   }
}
