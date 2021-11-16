package com.mycompany.ldit.pluswork.model;

import java.sql.Date;

public class PlusWork {
	private static final long serialVersionUID = 1111L;
	   private Date att_date;
	   private int stf_no;
	   private int pw_code;
	   private Date pw_hours;
	   
	   public PlusWork() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "plus_work [att_date=" + att_date + ", stf_no=" + stf_no + ", pw_code=" + pw_code + ", pw_hours="
	            + pw_hours + "]";
	   }
	   
	   public Date getAtt_date() {
	      return att_date;
	   }

	   public void setAtt_date(Date att_date) {
	      this.att_date = att_date;
	   }

	   public int getStf_no() {
	      return stf_no;
	   }

	   public void setStf_no(int stf_no) {
	      this.stf_no = stf_no;
	   }

	   public int getPw_code() {
	      return pw_code;
	   }

	   public void setPw_code(int pw_code) {
	      this.pw_code = pw_code;
	   }

	   public Date getPw_hours() {
	      return pw_hours;
	   }

	   public void setPw_hours(Date pw_hours) {
	      this.pw_hours = pw_hours;
	   }
}
