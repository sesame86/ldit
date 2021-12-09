package com.mycompany.ldit.project.model.service;

import java.util.List;

import com.mycompany.ldit.project.model.vo.Project;

public interface ProjectService {
	public int insertPJ(Project pJvo) throws Exception;
	public List<Project> getNewList(int pro_No) throws Exception;
	public List<Project> getContinueList(int pro_No) throws Exception;
	public List<Project> getFinishList(int pro_No) throws Exception;
}
