package com.mycompany.ldit.workcomment.model;

public class WorkComment {
	private static final long serialVersionUID = 1111L;
	   private int wcom_id;
	   private int work_id;
	   private int stf_no;
	   private String wcom_content;
	   
	   public WorkComment() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "work_comment [wcom_id=" + wcom_id + ", work_id=" + work_id + ", stf_no=" + stf_no + ", wcom_content="
	            + wcom_content + "]";
	   }
	   
	   public int getWcom_id() {
	      return wcom_id;
	   }

	   public void setWcom_id(int wcom_id) {
	      this.wcom_id = wcom_id;
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

	   public String getWcom_content() {
	      return wcom_content;
	   }

	   public void setWcom_content(String wcom_content) {
	      this.wcom_content = wcom_content;
	   }
}
