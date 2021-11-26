package com.mycompany.ldit.staff.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mycompany.ldit.staff.model.vo.Staff;

public interface StaffServiceInterface {
	//조직도
	public List<Staff> einquire(Staff vo);

	//직원 등록
	public int join(Staff staff);

	//JH
	//01_01 사원 로그인 체크
	public boolean loginCheck(Staff vo, HttpSession session);

	//01_02 사원 로그인 정보
	public Staff viewStaff(Staff vo);

	//02 사원 로그 아웃
	public void logout(HttpSession session);
}
