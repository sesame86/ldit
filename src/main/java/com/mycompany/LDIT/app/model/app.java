package com.mycompany.ldit.app.model;

public class App {
	private static final long serialVersionUID = 1111L;
	   private int app_no;
	   private int doc_no;
	   private int stf_no;
	   private String app_step;
	   private int app_result;
	   private String app_comment;
	   
	   public App() {
	      super();
	   }
	   
	   @Override
	   public String toString() {
	      return "approval [app_no=" + app_no + ", doc_no=" + doc_no + ", stf_no=" + stf_no + ", app_step=" + app_step
	            + ", app_result=" + app_result + ", app_comment=" + app_comment + "]";
	   }

	   public int getApp_no() {
	      return app_no;
	   }

	   public void setApp_no(int app_no) {
	      this.app_no = app_no;
	   }

	   public int getDoc_no() {
	      return doc_no;
	   }

	   public void setDoc_no(int doc_no) {
	      this.doc_no = doc_no;
	   }

	   public int getStf_no() {
	      return stf_no;
	   }

	   public void setStf_no(int stf_no) {
	      this.stf_no = stf_no;
	   }

	   public String getApp_step() {
	      return app_step;
	   }

	   public void setApp_step(String app_step) {
	      this.app_step = app_step;
	   }

	   public int getApp_result() {
	      return app_result;
	   }

	   public void setApp_result(int app_result) {
	      this.app_result = app_result;
	   }

	   public String getApp_comment() {
	      return app_comment;
	   }

	   public void setApp_comment(String app_comment) {
	      this.app_comment = app_comment;
	   }
}
