package com.mycompany.ldit.project.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.project.model.dao.ProjectDao;
import com.mycompany.ldit.project.model.vo.Project;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectDao projectDao;

	@Override
	public int insertPJ(Project pJvo) throws Exception {
		return projectDao.insertPJ(pJvo);
	}
}
