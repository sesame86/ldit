package com.mycompany.ldit.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.project.model.dao.ProjectDao;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.right.model.vo.Right;
import com.mycompany.ldit.staff.model.vo.Staff;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectDao projectDao;

	@Override
	public int insertPJ(Project pJvo) throws Exception {
		return projectDao.insertPJ(pJvo);
	}
	
	@Override
	public int insertTM(Project pJvo) throws Exception {
		return projectDao.insertTM(pJvo);
	}
	
	@Override
	public int updatePjR(int stfNo) throws Exception {
		return projectDao.updatePjR(stfNo);
	}

	@Override
	public List<Project> getNewList(Staff stfNo) throws Exception {
		return projectDao.getNewList(stfNo);
	}

	@Override
	public List<Project> getContinueList(Staff stfNo) throws Exception {
		return projectDao.getContinueList(stfNo);
	}

	@Override
	public List<Project> getFinishList(Staff stfNo) throws Exception {
		return projectDao.getFinishList(stfNo);
	}

	@Override
	public List<Project> getAllList(Staff stfNo) throws Exception {
		return projectDao.getAllList(stfNo);
	}
	
	@Override
	public List<Right> getRightConfirm(Staff stfNo) throws Exception {
		return projectDao.getRightConfirm(stfNo);
	}

	@Override
	public List<Project> getDetailList(int proNo) throws Exception {
		return projectDao.getDetailList(proNo);
	}

}
