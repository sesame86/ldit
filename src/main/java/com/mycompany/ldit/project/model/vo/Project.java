package com.mycompany.ldit.project.model.vo;

import java.sql.Date;

public class Project {
	private static final long serialVersionUID = 1111L;
	   private int pro_no;
	   private String pro_title;
	   private String pro_content;
	   private Date pro_start;
	   private Date pro_end;
	   private String pro_manager;
	   private char pro_status;
	   
	   public Project() {}
	   
	   
	   @Override
	   public String toString() {
	      return "project [pro_no=" + pro_no + ", pro_title=" + pro_title + ", pro_content=" + pro_content
	            + ", pro_start=" + pro_start + ", pro_end=" + pro_end + ", pro_manager=" + pro_manager + ", pro_status="
	            + pro_status + "]";
	   }

	   public int getPro_no() {
	      return pro_no;
	   }

	   public void setPro_no(int pro_no) {
	      this.pro_no = pro_no;
	   }

	   public String getPro_title() {
	      return pro_title;
	   }

	   public void setPro_title(String pro_title) {
	      this.pro_title = pro_title;
	   }

	   public String getPro_content() {
	      return pro_content;
	   }

	   public void setPro_content(String pro_content) {
	      this.pro_content = pro_content;
	   }

	   public Date getPro_start() {
	      return pro_start;
	   }

	   public void setPro_start(Date pro_start) {
	      this.pro_start = pro_start;
	   }

	   public Date getPro_end() {
	      return pro_end;
	   }

	   public void setPro_end(Date pro_end) {
	      this.pro_end = pro_end;
	   }

	   public String getPro_manager() {
	      return pro_manager;
	   }

	   public void setPro_manager(String pro_manager) {
	      this.pro_manager = pro_manager;
	   }

	   public char getPro_status() {
	      return pro_status;
	   }

	   public void setPro_status(char pro_status) {
	      this.pro_status = pro_status;
	   }
}
