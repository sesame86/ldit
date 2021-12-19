package com.mycompany.ldit.staff.model.vo;

import org.springframework.stereotype.Component;

import com.mycompany.ldit.department.model.vo.Department;
import com.mycompany.ldit.right.model.vo.Right;

@Component
public class Staff {
	private static final long serialVersionUID = 1111L;
	private int stfNo;
	private int deptNo;
	private String stfLvl;
	private String stfName;
	private String stfId;
	private String stfPasswd;
	private String stfImg;
	private String stfSign;
	private String stfPhone;
	private String stfMail;
	private String stfEnroll;
	private String stfNothere;
	private String deptName;
	private Department department;
	private StaffLike staffLike;
	private Right staffRight;
	
	public Staff() {
		super();
	}

	public Staff(int stfNo, int deptNo, String stfLvl, String stfName, String stfId, String stfPasswd, String stfImg,
			String stfSign, String stfPhone, String stfMail, String stfEnroll, String stfNothere, String deptName,
			Department department, StaffLike staffLike, Right staffRight) {
		super();
		this.stfNo = stfNo;
		this.deptNo = deptNo;
		this.stfLvl = stfLvl;
		this.stfName = stfName;
		this.stfId = stfId;
		this.stfPasswd = stfPasswd;
		this.stfImg = stfImg;
		this.stfSign = stfSign;
		this.stfPhone = stfPhone;
		this.stfMail = stfMail;
		this.stfEnroll = stfEnroll;
		this.stfNothere = stfNothere;
		this.deptName = deptName;
		this.department = department;
		this.staffLike = staffLike;
		this.staffRight = staffRight;
	}

	@Override
	public String toString() {
		return "Staff [stfNo=" + stfNo + ", deptNo=" + deptNo + ", stfLvl=" + stfLvl + ", stfName=" + stfName
				+ ", stfId=" + stfId + ", stfPasswd=" + stfPasswd + ", stfImg=" + stfImg + ", stfSign=" + stfSign
				+ ", stfPhone=" + stfPhone + ", stfMail=" + stfMail + ", stfEnroll=" + stfEnroll + ", stfNothere="
				+ stfNothere + ", deptName=" + deptName + ", department=" + department + ", staffLike=" + staffLike
				+ ", staffRight=" + staffRight + "]";
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getStfLvl() {
		return stfLvl;
	}

	public void setStfLvl(String stfLvl) {
		this.stfLvl = stfLvl;
	}

	public String getStfName() {
		return stfName;
	}

	public void setStfName(String stfName) {
		this.stfName = stfName;
	}

	public String getStfId() {
		return stfId;
	}

	public void setStfId(String stfId) {
		this.stfId = stfId;
	}

	public String getStfPasswd() {
		return stfPasswd;
	}

	public void setStfPasswd(String stfPasswd) {
		this.stfPasswd = stfPasswd;
	}

	public String getStfImg() {
		return stfImg;
	}

	public void setStfImg(String stfImg) {
		this.stfImg = stfImg;
	}

	public String getStfSign() {
		return stfSign;
	}

	public void setStfSign(String stfSign) {
		this.stfSign = stfSign;
	}

	public String getStfPhone() {
		return stfPhone;
	}

	public void setStfPhone(String stfPhone) {
		this.stfPhone = stfPhone;
	}

	public String getStfMail() {
		return stfMail;
	}

	public void setStfMail(String stfMail) {
		this.stfMail = stfMail;
	}

	public String getStfEnroll() {
		return stfEnroll;
	}

	public void setStfEnroll(String stfEnroll) {
		this.stfEnroll = stfEnroll;
	}

	public String getStfNothere() {
		return stfNothere;
	}

	public void setStfNothere(String stfNothere) {
		this.stfNothere = stfNothere;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public StaffLike getStaffLike() {
		return staffLike;
	}

	public void setStaffLike(StaffLike staffLike) {
		this.staffLike = staffLike;
	}

	public Right getStaffRight() {
		return staffRight;
	}

	public void setStaffRight(Right staffRight) {
		this.staffRight = staffRight;
	}

	
	
}