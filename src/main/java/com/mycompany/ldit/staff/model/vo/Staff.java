package com.mycompany.ldit.staff.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.mycompany.ldit.department.model.vo.Department;

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
	private Date stfEnroll;
	private Date stfNothere;
	private String deptName;
	private Department department;
	
	public Staff() {
		super();
	}
	
	@Override
	public String toString() {
		return "Staff [stfNo=" + stfNo + ", deptNo=" + deptNo + ", stfLvl=" + stfLvl + ", stfName=" + stfName
				+ ", stfId=" + stfId + ", stfPasswd=" + stfPasswd + ", stfImg=" + stfImg + ", stfSign=" + stfSign
				+ ", stfPhone=" + stfPhone + ", stfMail=" + stfMail + ", stfEnroll=" + stfEnroll + ", stfNothere="
				+ stfNothere + ", deptName=" + deptName + ", department=" + department + "]";
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

	public Date getStfEnroll() {
		return stfEnroll;
	}

	public void setStfEnroll(Date stfEnroll) {
		this.stfEnroll = stfEnroll;
	}

	public Date getStfNothere() {
		return stfNothere;
	}

	public void setStfNothere(Date stfNothere) {
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
}