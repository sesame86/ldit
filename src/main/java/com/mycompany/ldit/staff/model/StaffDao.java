package com.mycompany.ldit.staff.model;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.staff.model.vo.Staff;

@Repository("staffDao")

//public class StaffDao 처음에 이었습니다.
public class StaffDao implements StaffDaoInterface {

	@Autowired
	private SqlSession sqlSession;
	
	// 조직도
	public List<Staff> einquire(){
		return sqlSession.selectList("StaffNS.einquire");
	}
	
	// 직원 등록
	public int eregist(Staff staff) {
		return sqlSession.insert("StaffNS.eregist", staff);
	}
	
	// 직원 정보 수정

	// 직원 삭제
	public int edelete(Staff staff) {
		return sqlSession.delete("StaffNS.edelete", staff);
	}
	
	//JH
	@Inject
	SqlSession sql; // mybais 실행 객체
	
	//01_01 사원 로그인 체크
	@Override
	public boolean loginCheck(Staff vo) {
		String name = sql.selectOne("StaffNS.loginCheck",vo);
		return (name == null) ? false : true;
	}
	//01_02 사원 로그인 정보
	@Override
	public Staff viewStaff(Staff vo) {
		return sql.selectOne("StaffNS.viewStaff",vo);
	}
	
	//02 사원 로그아웃
	@Override
	public void logout(HttpSession session) {
		
	}
}
