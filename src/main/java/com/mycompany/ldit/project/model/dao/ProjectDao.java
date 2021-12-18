package com.mycompany.ldit.project.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.staff.model.vo.Staff;

@Repository("ProjectDao")
public class ProjectDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertPJ(Project pJvo) throws Exception {
		return sqlSession.insert("Project.insertPJ", pJvo);
	}
	public List<Project> getNewList(Staff stfNo) throws Exception {
		return sqlSession.selectList("Project.getNewList", stfNo);
	}
	public List<Project> getContinueList(Staff stfNo) throws Exception {
		return sqlSession.selectList("Project.getContinueList", stfNo);
	}
	public List<Project> getFinishList(Staff stfNo) throws Exception {
		return sqlSession.selectList("Project.getFinishList", stfNo);
	}
	public List<Project> getAllList(Staff stfNo) throws Exception {
		return sqlSession.selectList("Project.getAllList", stfNo);
	}
	public List<Project> getDetailList(int proNo) throws Exception {
		return sqlSession.selectList("Project.getDetailList", proNo);
	}

}
