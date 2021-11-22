package com.mycompany.ldit.staff.model.vo;

import java.sql.Date;

public class Staff {
	private static final long serialVersionUID = 1111L;
	   private int stf_no;
	   private int dept_no;
	   private String stf_lvl;
	   private String stf_name;
	   private String stf_id;
	   private String stf_passwd;
	   private String stf_img;
	   private String stf_sign;
	   private String stf_phone;
	   private String stf_mail;
	   private Date stf_enroll;
	   private Date stf_nothere;
	   
	   public Staff() {
	      super();
	   }

	   public Staff(String stf_name, String stf_sign, String stf_phone) {
		   super();
		   this.stf_name=stf_name;
		   this.stf_sign=stf_sign;
		   this.stf_phone=stf_phone;
	   }
	   @Override
	   public String toString() {
	      return "staff [stf_no=" + stf_no + ", dept_no=" + dept_no + ", stf_lvl=" + stf_lvl + ", stf_name=" + stf_name
	            + ", stf_id=" + stf_id + ", stf_passwd=" + stf_passwd + ", stf_img=" + stf_img + ", stf_sign="
	            + stf_sign + ", stf_phone=" + stf_phone + ", stf_mail=" + stf_mail + ", stf_enroll=" + stf_enroll
	            + ", stf_nothere=" + stf_nothere + "]";
	   }
	   
	   public int getStf_no() {
	      return stf_no;
	   }

	   public void setStf_no(int stf_no) {
	      this.stf_no = stf_no;
	   }

	   public int getDept_no() {
	      return dept_no;
	   }

	   public void setDept_no(int dept_no) {
	      this.dept_no = dept_no;
	   }

	   public String getStf_lvl() {
	      return stf_lvl;
	   }

	   public void setStf_lvl(String stf_lvl) {
	      this.stf_lvl = stf_lvl;
	   }

	   public String getStf_name() {
	      return stf_name;
	   }

	   public void setStf_name(String stf_name) {
	      this.stf_name = stf_name;
	   }

	   public String getStf_id() {
	      return stf_id;
	   }

	   public void setStf_id(String stf_id) {
	      this.stf_id = stf_id;
	   }

	   public String getStf_passwd() {
	      return stf_passwd;
	   }

	   public void setStf_passwd(String stf_passwd) {
	      this.stf_passwd = stf_passwd;
	   }

	   public String getStf_img() {
	      return stf_img;
	   }

	   public void setStf_img(String stf_img) {
	      this.stf_img = stf_img;
	   }

	   public String getStf_sign() {
	      return stf_sign;
	   }

	   public void setStf_sign(String stf_sign) {
	      this.stf_sign = stf_sign;
	   }

	   public String getStf_phone() {
	      return stf_phone;
	   }

	   public void setStf_phone(String stf_phone) {
	      this.stf_phone = stf_phone;
	   }

	   public String getStf_mail() {
	      return stf_mail;
	   }

	   public void setStf_mail(String stf_mail) {
	      this.stf_mail = stf_mail;
	   }

	   public Date getStf_enroll() {
	      return stf_enroll;
	   }

	   public void setStf_enroll(Date stf_enroll) {
	      this.stf_enroll = stf_enroll;
	   }

	   public Date getStf_nothere() {
	      return stf_nothere;
	   }

	   public void setStf_nothere(Date stf_nothere) {
	      this.stf_nothere = stf_nothere;
	   }
}
