package com.mycompany.ldit.team.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.team.model.vo.Team;

@Repository("teamDao")
public class TeamDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Team> getOneProjectTeam(int pro_no){
		return sqlSession.selectList("Team.getOneProjectTeam", pro_no);
	}
	public Project getOneProject(int pro_no){
		return sqlSession.selectOne("Team.getOneProject", pro_no);
	}
}