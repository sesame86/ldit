package com.mycompany.ldit.staff.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mycompany.ldit.staff.model.vo.Staff;

public interface StaffDaoInterface {
	// 조직도
	public List<Staff> organization();

	// 직원등록
	public int eregist(Staff staff);
	
	// 직원 삭제를 위한 전체 직원 조회
	public List<Staff> einquire();
	
	// 직원 삭제
	public int edelete(Staff staff);
	
	// JH
	// 01_01 사원 로그인 체크
	public boolean loginCheck(Staff vo);

	// 01_02 사원 로그인 정보
	public Staff viewStaff(Staff vo);

	// 02 사원 로그 아웃
	public void logout(HttpSession session);

}
