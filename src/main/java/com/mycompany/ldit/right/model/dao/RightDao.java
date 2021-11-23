package com.mycompany.ldit.right.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.staff.model.vo.Staff;

@Repository("RightDao")
public class RightDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Staff> getStaffList(Staff vo) {
		System.out.println("DAO vo : " + vo);
		List<Staff> volist =  sqlSession.selectList("Right.searchStaffList", vo);
		System.out.println("volist : " + volist);
		return volist;
	}
}


