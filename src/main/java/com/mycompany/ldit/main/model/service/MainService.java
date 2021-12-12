package com.mycompany.ldit.main.model.service;

import java.util.List;

import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.project.model.vo.Project;

public interface MainService {
	public Attendance getAttendance(int stfNo) throws Exception;
	public List<Project> getUserProject(int stfNo) throws Exception;
}
