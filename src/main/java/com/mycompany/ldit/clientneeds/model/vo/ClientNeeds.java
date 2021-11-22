package com.mycompany.ldit.clientneeds.model.vo;

public class ClientNeeds {
	private static final long serialVersionUID = 1111L;
	   private int cn_id;
	   private int pro_no;
	   private String cn_title;
	   private String cn_content;
	   private int cn_priority;
	   private String cn_deactivate;
	   
	   public ClientNeeds() {
	      super();
	   }
	   
	   @Override
	   public String toString() {
	      return "client_needs [cn_id=" + cn_id + ", pro_no=" + pro_no + ", cn_title=" + cn_title + ", cn_content="
	            + cn_content + ", cn_priority=" + cn_priority + ", cn_deactivate=" + cn_deactivate + "]";
	   }

	   public int getCn_id() {
	      return cn_id;
	   }

	   public void setCn_id(int cn_id) {
	      this.cn_id = cn_id;
	   }

	   public int getPro_no() {
	      return pro_no;
	   }

	   public void setPro_no(int pro_no) {
	      this.pro_no = pro_no;
	   }

	   public String getCn_title() {
	      return cn_title;
	   }

	   public void setCn_title(String cn_title) {
	      this.cn_title = cn_title;
	   }

	   public String getCn_content() {
	      return cn_content;
	   }

	   public void setCn_content(String cn_content) {
	      this.cn_content = cn_content;
	   }

	   public int getCn_priority() {
	      return cn_priority;
	   }

	   public void setCn_priority(int cn_priority) {
	      this.cn_priority = cn_priority;
	   }

	   public String getCn_deactivate() {
	      return cn_deactivate;
	   }

	   public void setCn_deactivate(String cn_deactivate) {
	      this.cn_deactivate = cn_deactivate;
	   }
}
