package com.mycompany.LDIT.team.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.LDIT.project.model.project;


@Repository("teamDao")
public class TeamDao {
	@Autowired
	private SqlSession sqlSession;
	
	public project getOneProject(int pro_no){
		return sqlSession.selectOne("Team.getOneProject", pro_no);
	}
}