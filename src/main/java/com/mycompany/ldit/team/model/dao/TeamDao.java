package com.mycompany.ldit.team.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.project.model.vo.Project;

@Repository("teamDao")
public class TeamDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Project getOneProject(int pro_no){
		return sqlSession.selectOne("Team.getOneProject", pro_no);
	}
}