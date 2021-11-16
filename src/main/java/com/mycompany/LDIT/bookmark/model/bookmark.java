package com.mycompany.ldit.bookmark.model;

public class BookMark {
	private static final long serialVersionUID = 1111L;
	   private int bookmark_id;
	   private int enroll_id;
	   private int enrolled_id;
	   
	   public BookMark() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "bookmark [bookmark_id=" + bookmark_id + ", enroll_id=" + enroll_id + ", enrolled_id=" + enrolled_id
	            + "]";
	   }
	   
	   public int getBookmark_id() {
	      return bookmark_id;
	   }

	   public void setBookmark_id(int bookmark_id) {
	      this.bookmark_id = bookmark_id;
	   }

	   public int getEnroll_id() {
	      return enroll_id;
	   }

	   public void setEnroll_id(int enroll_id) {
	      this.enroll_id = enroll_id;
	   }

	   public int getEnrolled_id() {
	      return enrolled_id;
	   }

	   public void setEnrolled_id(int enrolled_id) {
	      this.enrolled_id = enrolled_id;
	   }   
}
