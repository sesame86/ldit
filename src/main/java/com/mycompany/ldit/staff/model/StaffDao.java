package com.mycompany.ldit.staff.model;

import java.util.List;
import java.util.Map;

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
	
	// 받은 쪽지함의 받은 직원 사원 번호 가져오기
	public int searchNo(String rStfId) {
		return sqlSession.selectOne("StaffNS.searchNo", rStfId);
	}
	
	// 조직도
	public List<Staff> organization(){
		return sqlSession.selectList("StaffNS.organization");
	}
	
	// 직원 등록
	public int eregist(Staff staff) {
		return sqlSession.insert("StaffNS.eregist", staff);
	}
	
	// 직원 정보 수정
	public int eupdate(Staff staff) {
		return sqlSession.update("StaffNS.eupdate", staff);
	}
	
	// 직원 삭제를 위한 전체 직원 조회
	public List<Staff> einquire(){
		return sqlSession.selectList("StaffNS.einquire");
	}
	
	// 직원 상세 정보
	public Staff profile(Staff staff) {
		return sqlSession.selectOne("StaffNS.profile", staff);
	}
	
	// 직원 삭제
	public int edelete(int stfNo) {
		return sqlSession.delete("StaffNS.edelete", stfNo);
	}
	
	// 사원 번호로 사원 아이디 조회
	public String searchId(int No) {
		return sqlSession.selectOne("StaffNS.searchId", No);
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

	@Override
	public List<Staff> getSearchStaffForApproval(String user_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> getSearchStaffApp(String user_name) {
		// TODO Auto-generated method stub
		return null;
	}

	//이거 확인해봐야됨
	public static List<Staff> getSearchStaffApp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//직원전체조회
	public List<Staff> getAllStaff() {
		return sqlSession.selectList("StaffNS.getAllStaff");
	}
	public int deleteLike(Map<String, Object> mapM) {
		return sqlSession.delete("StaffNS.deleteLike", mapM);
	}
	public int insertLike(Map<String, Object> mapM) {
		return sqlSession.insert("StaffNS.insertLike", mapM);
	}
	public List<Staff> chooseLikeStaff(int hostStfNo) {
		return sqlSession.selectList("StaffNS.chooseLikeStaff", hostStfNo);
	}
}
