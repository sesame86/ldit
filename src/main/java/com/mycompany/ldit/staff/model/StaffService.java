package com.mycompany.ldit.staff.model;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.staff.model.vo.Staff;

@Service("staffService")
public class StaffService implements StaffServiceInterface{

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public List<Staff> organization(Staff vo) throws Exception {
		List<Staff> orlist = null;
		orlist = staffDao.organization();
		System.out.println(orlist);
		return orlist;
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
		vo2.setStf_passwd("");
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
