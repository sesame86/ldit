package com.mycompany.ldit.project.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.ldit.project.model.vo.Project;

@Repository("ProjectDao")
public class ProjectDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertPJ(Project pJvo) throws Exception {
		return sqlSession.insert("Project.insertPJ", pJvo);
	}

}
