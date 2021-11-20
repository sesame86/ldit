package com.mycompany.ldit.staff.model;

import java.util.HashMap;
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
	
	public List<Staff> organization() throws Exception{
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("stf_name", "백건호");
		return sqlSession.selectList("StaffNS.organization", map1);
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
