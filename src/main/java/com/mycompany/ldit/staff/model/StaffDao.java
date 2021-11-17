package com.mycompany.ldit.staff.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("staffDao")
public class StaffDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Staff> organization() throws Exception{
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("stf_name", "백건호");
		return sqlSession.selectList("StaffNS.organization", map1);
	}
}
