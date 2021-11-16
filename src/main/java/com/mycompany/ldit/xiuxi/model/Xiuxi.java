package com.mycompany.ldit.xiuxi.model;

public class Xiuxi {
	private static final long serialVersionUID = 1111L;
	   private int xiu_no;
	   private String xiu_reason;
	   private int xiu_official;
	   
	   public Xiuxi() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "xiuxi [xiu_no=" + xiu_no + ", xiu_reason=" + xiu_reason + ", xiu_official=" + xiu_official + "]";
	   }
	   
	   public int getXiu_no() {
	      return xiu_no;
	   }

	   public void setXiu_no(int xiu_no) {
	      this.xiu_no = xiu_no;
	   }

	   public String getXiu_reason() {
	      return xiu_reason;
	   }

	   public void setXiu_reason(String xiu_reason) {
	      this.xiu_reason = xiu_reason;
	   }

	   public int getXiu_official() {
	      return xiu_official;
	   }

	   public void setXiu_official(int xiu_official) {
	      this.xiu_official = xiu_official;
	   }
}
