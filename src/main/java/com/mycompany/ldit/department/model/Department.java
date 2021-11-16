package com.mycompany.ldit.department.model;

public class Department {
	private static final long serialVersionUID = 1111L;
	   private int dept_no;
	   private String dept_name;
	   
	   public Department() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "department [dept_no=" + dept_no + ", dept_name=" + dept_name + "]";
	   }
	   
	   public int getDept_no() {
	      return dept_no;
	   }

	   public void setDept_no(int dept_no) {
	      this.dept_no = dept_no;
	   }

	   public String getDept_name() {
	      return dept_name;
	   }

	   public void setDept_name(String dept_name) {
	      this.dept_name = dept_name;
	   }
}
