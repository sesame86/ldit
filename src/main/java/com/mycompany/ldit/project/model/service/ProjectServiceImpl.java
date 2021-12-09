package com.mycompany.ldit.project.model.service;

import java.util.List;

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

	@Override
	public List<Project> getNewList(int proNo) throws Exception {
		return projectDao.getNewList(proNo);
	}

	@Override
	public List<Project> getContinueList(int proNo) throws Exception {
		return projectDao.getContinueList(proNo);
	}

	@Override
	public List<Project> getFinishList(int proNo) throws Exception {
		return projectDao.getFinishList(proNo);
	}
}
