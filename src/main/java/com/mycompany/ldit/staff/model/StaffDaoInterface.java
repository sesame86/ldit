package com.mycompany.ldit.staff.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mycompany.ldit.staff.model.vo.Staff;

public interface StaffDaoInterface {
	
	// 받은 쪽지함의 받은 직원 사원 번호 가져오기
	public int searchNo(String rStfId);
	
	// 조직도
	public List<Staff> organization();

	// 직원등록
	public int eregist(Staff staff);
	
	// 직원 삭제를 위한 전체 직원 조회
	public List<Staff> einquire();
	
	// 직원 상세 정보
	public Staff profile(Staff staff);
	
	// 직원 정보 수정
	public int eupdate(Staff staff);
	
	// 직원 삭제
	public int edelete(int stfNo);
	
	// JH
	// 01_01 사원 로그인 체크
	public boolean loginCheck(Staff vo);

	// 01_02 사원 로그인 정보
	public Staff viewStaff(Staff vo);

	// 02 사원 로그 아웃
	public void logout(HttpSession session);

	// 결재
	public List<Staff> getSearchStaffForApproval(String user_name);

	List<Staff> getSearchStaffApp(String user_name); // Approval 자동완성

}
