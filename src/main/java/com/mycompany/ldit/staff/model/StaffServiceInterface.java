package com.mycompany.ldit.staff.model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mycompany.ldit.staff.model.vo.Staff;

public interface StaffServiceInterface {
	// 받은 쪽지함의 받은 직원 사원 번호 가져오기
	public int searchNo(String rStfId);
	
	// 조직도
	public List<Staff> organization(Staff vo);

	// 직원 등록
	public int eregist(Staff staff);

	// 직원 삭제를 위한 전체 직원 조회
	public List<Staff> einquire(Staff vo);
	
	// 직원 상세 정보
	public Staff profile(Staff staff);
	
	// 직원 삭제
	public int edelete(int stfNo);
	
	// 직원 정보 수정
	public int eupdate(Staff staff);
	
	// JH
	// 01_01 사원 로그인 체크
	public boolean loginCheck(Staff vo, HttpSession session);

	// 01_02 사원 로그인 정보
	public Staff viewStaff(Staff vo);

	// 02 사원 로그 아웃
	public void logout(HttpSession session);
	
	//결재
	List<Staff> getSearchStaff(String userName); // Approval 자동완성
	
	//전체직원조회
	List<Staff> getAllStaff();
	//like를 위한 delete
	int deleteLike(Map<String, Object> mapM);
	//like insert
	int insertLike(Map<String, Object> mapM);
	//내가 찜한 직원 조회
	List<Staff> chooseLikeStaff(int hostStfNo);
	
}
