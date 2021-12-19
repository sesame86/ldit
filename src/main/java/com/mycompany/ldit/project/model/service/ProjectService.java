package com.mycompany.ldit.project.model.service;

import java.util.List;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.right.model.vo.Right;
import com.mycompany.ldit.staff.model.vo.Staff;

public interface ProjectService {
	public int insertPJ(Project pJvo) throws Exception;
	public int insertTM(Project pJvo) throws Exception;
	public int updatePjR(int stfNo) throws Exception;
	public List<Project> getNewList(Staff stfNo) throws Exception;
	public List<Project> getContinueList(Staff stfNo) throws Exception;
	public List<Project> getFinishList(Staff stfNo) throws Exception;
	public List<Project> getAllList(Staff stfNo) throws Exception;
	public List<Right> getRightConfirm(Staff stfNo) throws Exception;
	public List<Project> getDetailList(int proNo) throws Exception;
}
