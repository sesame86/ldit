package com.mycompany.ldit.right.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.staff.model.vo.Staff;

@Repository("RightDao")
public class RightDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Staff> getStaffList() throws Exception {
		Map<String, Object> map1 =  new HashMap<String, Object>();
		map1.put("category", "제목");   // 작성자 // 내용 // 전체 // 제목
		map1.put("searchValue", "ej");
		return sqlSession.selectList("Right.searchStaffList", map1);
	}
}
