package com.mycompany.ldit.appdoctype.model;

public class AppDocType {
	private static final long serialVersionUID = 1111L;
	   private int doc_type_no;
	   private String doc_type_title;
	   private String doc_type_content;
	   
	   public AppDocType() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "approval_doc_type [doc_type_no=" + doc_type_no + ", doc_type_title=" + doc_type_title
	            + ", doc_type_content=" + doc_type_content + "]";
	   }
	   
	   public int getDoc_type_no() {
	      return doc_type_no;
	   }

	   public void setDoc_type_no(int doc_type_no) {
	      this.doc_type_no = doc_type_no;
	   }

	   public String getDoc_type_title() {
	      return doc_type_title;
	   }

	   public void setDoc_type_title(String doc_type_title) {
	      this.doc_type_title = doc_type_title;
	   }

	   public String getDoc_type_content() {
	      return doc_type_content;
	   }

	   public void setDoc_type_content(String doc_type_content) {
	      this.doc_type_content = doc_type_content;
	   }   
}
