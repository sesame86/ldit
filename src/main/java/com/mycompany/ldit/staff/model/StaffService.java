package com.mycompany.ldit.staff.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.staff.model.vo.Staff;

@Service("staffService")
public class StaffService implements StaffServiceInterface{

	@Autowired
	private StaffDao staffDao;
	
	// 조직도
	@Override
	public List<Staff> organization(Staff vo) {
		return staffDao.organization();
	}

	// 직원 등록
	@Override
	public int eregist(Staff staff) {
		int result = 0;
		try {
			result = staffDao.eregist(staff);
			System.out.println("직원 등록 성공 여부 :" + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 직원 삭제를 위한 전체 직원 조회
	public List<Staff> einquire(Staff vo){
		return staffDao.einquire();
	}
	
	// 직원 삭제
	public int edelete(Staff staff) {
		int result = 0;
		try {
			result = staffDao.edelete(staff);
			System.out.println("직원 삭제 성공 여부:" + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//JH
	//01_01 회원 로그인 체크
	//	@Inject
	//	StaffDao staffDao;
	@Override
	public boolean loginCheck(Staff vo, HttpSession session) {
	boolean result = staffDao.loginCheck(vo);
	if(result) {//true 일 경우 세션에 등록
		Staff vo2 = viewStaff(vo);
		vo2.setStfPasswd("");
		//세션 변수 등록
		session.setAttribute("loginUser", vo2);
		
		
		//session.setAttribute("stf_id", vo2.getStf_id());
		//session.setAttribute("stf_name", vo2.getStf_name());	
	}
	return result;
	}
	
	//01_02 회원 로그인 정보
	@Override
	public Staff viewStaff(Staff vo) {
		//return vo;
		return staffDao.viewStaff(vo);
	}
	
	//02 회원 로그 아웃
	@Override
	public void logout(HttpSession session) {
		//세션 변수 개별 삭제
		//session.removeAttrubute("stf_id");
		//세션 정보를 초기화 시킴
		session.invalidate();
	}
	
}
