package com.mycompany.ldit.department.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Department {
	private static final long serialVersionUID = 1111L;
	   private int deptNo;
	   private String deptName;
	   
	   public Department() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "department [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	   }
	   
	   public int getDeptNo() {
	      return deptNo;
	   }

	   public void setDeptNo(int deptNo) {
	      this.deptNo = deptNo;
	   }

	   public String getDeptName() {
	      return deptName;
	   }

	   public void setDeptName(String deptName) {
	      this.deptName = deptName;
	   }
}