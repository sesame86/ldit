package com.mycompany.ldit.work.model;

import java.sql.Date;

public class Work {
	private static final long serialVersionUID = 1111L;
	   private int work_id;
	   private int stf_no;
	   private String work_title;
	   private String work_content;
	   private Date work_start;
	   private Date work_end;
	   private int work_finish;
	   
	   public Work() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "work [work_id=" + work_id + ", stf_no=" + stf_no + ", work_title=" + work_title + ", work_content="
	            + work_content + ", work_start=" + work_start + ", work_end=" + work_end + ", work_finish="
	            + work_finish + "]";
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

	   public String getWork_title() {
	      return work_title;
	   }

	   public void setWork_title(String work_title) {
	      this.work_title = work_title;
	   }

	   public String getWork_content() {
	      return work_content;
	   }

	   public void setWork_content(String work_content) {
	      this.work_content = work_content;
	   }

	   public Date getWork_start() {
	      return work_start;
	   }

	   public void setWork_start(Date work_start) {
	      this.work_start = work_start;
	   }

	   public Date getWork_end() {
	      return work_end;
	   }

	   public void setWork_end(Date work_end) {
	      this.work_end = work_end;
	   }

	   public int getWork_finish() {
	      return work_finish;
	   }

	   public void setWork_finish(int work_finish) {
	      this.work_finish = work_finish;
	   }
}
