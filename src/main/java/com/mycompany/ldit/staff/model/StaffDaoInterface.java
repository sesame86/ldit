package com.mycompany.ldit.staff.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mycompany.ldit.staff.model.vo.Staff;

public interface StaffDaoInterface {

	// 조직도
	public List<Staff> organization();

	// 직원등록
	public int eregist(Staff staff);
	
	// JH
	// 01_01 사원 로그인 체크
	public boolean loginCheck(Staff vo);

	// 01_02 사원 로그인 정보
	public Staff viewStaff(Staff vo);

	// 02 사원 로그 아웃
	public void logout(HttpSession session);

}
